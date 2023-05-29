package com.academia.fikefino.controller;

import com.academia.fikefino.entities.Aluno;
import com.academia.fikefino.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> findAll() {
        List<Aluno> aluno = alunoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(aluno);
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Aluno> save(@RequestBody Aluno aluno) {
        return ResponseEntity.status(HttpStatus.CREATED).body( alunoService.save(aluno));
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
