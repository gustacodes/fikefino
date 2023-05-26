package com.academia.fikefino.controller;

import com.academia.fikefino.entities.Aluno;
import com.academia.fikefino.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService as;

    @GetMapping("/cadastro")
    public ModelAndView save() {
        ModelAndView mv = new ModelAndView("cadastro");
        return mv;
    }

    @PostMapping("/cadastro")
    public ModelAndView save(Aluno aluno) {
        ModelAndView mv = new ModelAndView("cadastro");
        as.save(aluno);
        return mv;
    }

}
