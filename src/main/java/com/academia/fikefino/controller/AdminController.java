package com.academia.fikefino.controller;

import com.academia.fikefino.entities.Admin;
import com.academia.fikefino.entities.Papeis;
import com.academia.fikefino.repositories.PapeisRespository;
import com.academia.fikefino.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private PapeisRespository papeisRespository;

    @GetMapping("/cadastro")
    public ModelAndView admin() {
        ModelAndView mv = new ModelAndView("admin");
        return mv;
    }

    @PostMapping("/cadastro")
    public RedirectView save(Admin admin) {
        adminService.save(admin);
        return new RedirectView("/admin/usuarios");
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("funcionarios");
        return mv;
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
