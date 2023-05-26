package com.academia.fikefino.services;

import com.academia.fikefino.entities.Aluno;
import com.academia.fikefino.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository ar;

    public Aluno save(Aluno aluno) {
        return ar.save(aluno);
    }

    public List<Aluno> findAll() {
        return ar.findAll();
    }

}
