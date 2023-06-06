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

        var p = new Planos();

        if(opcaoSelecionada.equalsIgnoreCase(p.getDiamante())) {
            p.setDiamante(opcaoSelecionada);
            aluno.setMensalidade(Mensalidade.DIAMANTE.getMensalidade());
            aluno.setBeneficios(Beneficios.DIAMANTE.getBeneficios());
        } else if(opcaoSelecionada.equalsIgnoreCase(p.getOuro())) {
            p.setOuro(opcaoSelecionada);
            aluno.setMensalidade(Mensalidade.OURO.getMensalidade());
            aluno.setBeneficios(Beneficios.OURO.getBeneficios());
        } else {
            p.setPrata(opcaoSelecionada);
            aluno.setMensalidade(Mensalidade.PRATA.getMensalidade());
            aluno.setBeneficios(Beneficios.PRATA.getBeneficios());
        }

        Aluno plano = alunoService.tipoPlano(p, aluno);
        planosRepository.save(p);
        alunoService.save(aluno);

        return new RedirectView("/aluno/todos-alunos");
    }

    @DeleteMapping("/{id}")
    public RedirectView deleteById(@PathVariable Long id) {
        alunoService.deleteById(id);
        return new RedirectView("/aluno/todos-alunos");
    }

    /*@PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody Aluno aluno) {
        Aluno updateAluno = alunoService.update(id, aluno);
        return ResponseEntity.status(HttpStatus.OK).body(updateAluno);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Aluno aluno) {
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.login(aluno).getBody());
    }*/

}
