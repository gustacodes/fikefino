package com.academia.fikefino.controller;

import com.academia.fikefino.entities.Admin;
import com.academia.fikefino.entities.Papeis;
import com.academia.fikefino.repositories.PapeisRespository;
import com.academia.fikefino.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private PapeisRespository papeisRespository;

    @Autowired
    private BCryptPasswordEncoder criptografia;

    private boolean temAutorizacao(Admin admin, String papel) {
        for (Papeis pp : admin.getPapeis()) {
            if (pp.getNome().equals(papel)) {
                return true;
            }
        }
        return false;
    }

    @GetMapping("/cadastro")
    public ModelAndView admin() {
        ModelAndView mv = new ModelAndView("admin");
        return mv;
    }

    @PostMapping("/cadastro")
    public RedirectView save(Admin admin, Model model) {

        Papeis papel = papeisRespository.findByNome("USER");
        model.addAttribute("papeis", papel);
        List<Papeis> papeis = new ArrayList<>();
        papeis.add(papel);
        admin.setPapeis(papeis);
        String senhaCriptografada = criptografia.encode(admin.getSenha());
        admin.setSenha(senhaCriptografada);
        adminService.save(admin);
        return new RedirectView("/admin/usuarios");
    }

    @GetMapping("/login")
    public String index(@CurrentSecurityContext(expression = "authentication.usuario") String login) {
        Admin usuario = adminService.findByUsuario(login);

        String redirectURL = "";
        if (temAutorizacao(usuario, "ADMIN")) {
            redirectURL = "/admin/funcionarios";
        } else if (temAutorizacao(usuario, "USER")) {
            redirectURL = "/admin/alunos";
        }
        return redirectURL;

    }

    @PostMapping("/login/{email}")
    public String login(@PathVariable String email){
         return "redirect:/admin/alunos";
    }

    @GetMapping("/funcionarios")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("funcionarios");
        mv.addObject("usuarios", adminService.findAll());
        return mv;
    }

    @DeleteMapping("/{id}")
    public RedirectView deleteById(@PathVariable Long id) {
        adminService.deleteById(id);
        return new RedirectView("/admin/usuarios");
    }

}
