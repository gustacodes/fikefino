package com.academia.fikefino.controller;

import com.academia.fikefino.entities.Aluno;
import com.academia.fikefino.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService as;

    @GetMapping
    public ResponseEntity<List<Aluno>> findAll() {
        List<Aluno> aluno = as.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(aluno);
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Aluno> save(@RequestBody Aluno aluno) {
        return ResponseEntity.status(HttpStatus.CREATED).body( as.save(aluno));
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        as.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
