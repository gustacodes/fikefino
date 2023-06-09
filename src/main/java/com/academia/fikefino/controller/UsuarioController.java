package com.academia.fikefino.controller;

import com.academia.fikefino.entities.Usuario;
import com.academia.fikefino.repositories.PapeisRespository;
import com.academia.fikefino.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/admin")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PapeisRespository papeisRespository;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/cadastro")
    public ModelAndView admin() {
        ModelAndView mv = new ModelAndView("admin");
        return mv;
    }

    @PostMapping("/cadastro")
    public RedirectView save(Usuario user) {
        user.setSenha(encoder.encode(user.getSenha()));
        usuarioService.save(user);
        return new RedirectView("/admin/funcionarios");
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email) {
        UserDetails userDetails = usuarioService.loadUserByUsername(email);
        return "funcionarios"; // Retorne o nome do template para exibir após o login
    }

    @GetMapping("/funcionarios")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("funcionarios");
        mv.addObject("usuarios", usuarioService.findAll());
        return mv;
    }

    @DeleteMapping("/{id}")
    public RedirectView deleteById(@PathVariable Long id) {
        usuarioService.deleteById(id);
        return new RedirectView("/admin/usuarios");
    }

}
