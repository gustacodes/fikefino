package com.academia.fikefino.controller;

import com.academia.fikefino.entities.Aluno;
import com.academia.fikefino.entities.Planos;
import com.academia.fikefino.enums.Beneficios;
import com.academia.fikefino.enums.Mensalidade;
import com.academia.fikefino.repositories.PlanosRepository;
import com.academia.fikefino.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private PlanosRepository planosRepository;

    @GetMapping("/todos-alunos")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("alunos");
        List<Aluno> aluno = alunoService.findAll();
        mv.addObject("alunos", aluno);
        return mv;
    }

    @GetMapping
    public ModelAndView save() {
        ModelAndView mv = new ModelAndView("cadastro");
        return mv;
    }

    @PostMapping
    public RedirectView save(@RequestParam("opcao") String opcaoSelecionada, Aluno aluno) {

        var meuPlano = new Planos();
        meuPlano.setPlano(opcaoSelecionada);
        planosRepository.save(meuPlano);
        Aluno plano = alunoService.tipoPlano(opcaoSelecionada, meuPlano.getId(), aluno);

        return new RedirectView("/aluno/todos-alunos");
    }

    @DeleteMapping("/{id}")
    public RedirectView deleteById(@PathVariable Long id) {
        alunoService.deleteById(id);
        return new RedirectView("/aluno/todos-alunos");
    }

    @PutMapping("/{id}")
    public RedirectView update(@PathVariable Long id, Aluno aluno) {
        Aluno updateAluno = alunoService.update(id, aluno);
        return new RedirectView("/aluno/todos-alunos");
    }

}
