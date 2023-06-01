package com.academia.fikefino.controller;

import com.academia.fikefino.entities.Aluno;
import com.academia.fikefino.enums.Planos;
import com.academia.fikefino.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> findAll() {
        List<Aluno> aluno = alunoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(aluno);
    }

    @GetMapping("/cadastro-aluno")
    public ModelAndView save() {
        ModelAndView mv = new ModelAndView("cadastro");
        return mv;
    }

    @PostMapping("/cadastro-aluno")
    public RedirectView save(@RequestParam("opcao") String opcaoSelecionada, Aluno aluno) {
        String plano = alunoService.tipoPlano(opcaoSelecionada, aluno);
        aluno.setPlano(plano);
        alunoService.save(aluno);
        return new RedirectView("/aluno/cadastro-aluno");
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        alunoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody Aluno aluno) {
        Aluno updateAluno = alunoService.update(id, aluno);
        return ResponseEntity.status(HttpStatus.OK).body(updateAluno);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Aluno aluno) {
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.login(aluno).getBody());
    }

}
