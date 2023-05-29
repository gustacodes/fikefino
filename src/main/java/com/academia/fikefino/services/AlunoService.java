package com.academia.fikefino.services;

import com.academia.fikefino.entities.Aluno;
import com.academia.fikefino.enums.Beneficios;
import com.academia.fikefino.enums.Mensalidade;
import com.academia.fikefino.enums.Planos;
import com.academia.fikefino.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository ar;

    public Aluno save(Aluno aluno) {
        Planos plano = aluno.getPlano();

        if(plano.getPlanos().equals("DIAMANTE")) {
            aluno.setMensalidade(Mensalidade.DIAMANTE.getMensalidade());
            aluno.setBeneficios(Beneficios.DIAMANTE.getBeneficios());

        } else if(plano.getPlanos().equals("OURO")) {
            aluno.setMensalidade(Mensalidade.OURO.getMensalidade());
            aluno.setBeneficios(Beneficios.OURO.getBeneficios());
            
        } else if(plano.getPlanos().equals("PRATA")) {
            aluno.setMensalidade(Mensalidade.PRATA.getMensalidade());
            aluno.setBeneficios(Beneficios.PRATA.getBeneficios());
        }

        return ar.save(aluno);
    }

    public List<Aluno> findAll() {
        return ar.findAll();
    }

    public void deleteById(Long id) {
        ar.deleteById(id);
    }

    public Aluno update(Long id, Aluno aluno) {
        aluno.setId(id);
        return ar.save(aluno);
    }
}
