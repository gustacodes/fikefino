package com.academia.fikefino.controller;

import com.academia.fikefino.entities.Papeis;
import com.academia.fikefino.entities.Usuario;
import com.academia.fikefino.repositories.PapeisRespository;
import com.academia.fikefino.services.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/admin")
@Validated
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PapeisRespository papeisRespository;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/acesso-negado")
    public String negado() {
        return "acesso-negado";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        session.invalidate();

        return "redirect:/admin/login";
    }

    @GetMapping("/cadastro")
    public ModelAndView admin() {
        Iterable<Papeis> papeis = papeisRespository.findAll();
        ModelAndView mv = new ModelAndView("admin");
        mv.addObject("papeis", papeis);
        return mv;
    }

    @PostMapping("/cadastro")
    public RedirectView save(Usuario user) {

        List<Papeis> papeis = papeisRespository.findAll();
        ModelAndView mv = new ModelAndView("admin");
        mv.addObject("papeis", papeis);
        user.setPass(encoder.encode(user.getPassword()));
        usuarioService.save(user);
        return new RedirectView("/admin/login");
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(Usuario usuario) {
        return "redirect:/aluno";
    }

    @GetMapping("/funcionarios")
    public ModelAndView findAll() {
        Iterable<Usuario> usuarios = usuarioService.findAll();
        ModelAndView mv = new ModelAndView("funcionarios");
        mv.addObject("usuarios", usuarios);
        return mv;
    }

    @DeleteMapping("/{id}")
    public RedirectView deleteById(@PathVariable Long id) {
        usuarioService.deleteById(id);
        return new RedirectView("/admin/funcionarios");
    }

}
