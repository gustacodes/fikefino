package com.academia.fikefino.controller;

import com.academia.fikefino.entities.Admin;
import com.academia.fikefino.services.AdminService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public ModelAndView admin() {
        ModelAndView mv = new ModelAndView("admin");
        return mv;
    }

    @PostMapping
    public RedirectView save(Admin admin) {
        adminService.save(admin);
        return new RedirectView("/admin/usuarios");
    }

    @GetMapping("/usuarios")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("usuarios");
        mv.addObject("usuarios", adminService.findAll());
        return mv;
    }

    @DeleteMapping("/{id}")
    public RedirectView deleteById(@PathVariable Long id) {
        adminService.deleteById(id);
        return new RedirectView("/admin/usuarios");
    }

}
