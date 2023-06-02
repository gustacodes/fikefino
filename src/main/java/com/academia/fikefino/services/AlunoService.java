package com.academia.fikefino.services;

import com.academia.fikefino.entities.Aluno;
import com.academia.fikefino.enums.Beneficios;
import com.academia.fikefino.enums.Mensalidade;
import com.academia.fikefino.enums.Planos;
import com.academia.fikefino.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    //Método de seleção do plano (Tipo, Mensalidade e Benefício)
    public String tipoPlano(String planoSelecionado, Aluno aluno) {

        switch(planoSelecionado) {
            case "DIAMANTE":
                aluno.setPlano(planoSelecionado);
                aluno.setMensalidade(Mensalidade.DIAMANTE.getMensalidade());
                aluno.setBeneficios(Beneficios.DIAMANTE.getBeneficios());
                break;
            case "OURO":
                aluno.setPlano(planoSelecionado);
                aluno.setMensalidade(Mensalidade.OURO.getMensalidade());
                aluno.setBeneficios(Beneficios.OURO.getBeneficios());
                break;
            case "PRATA":
                aluno.setPlano(planoSelecionado);
                aluno.setMensalidade(Mensalidade.PRATA.getMensalidade());
                aluno.setBeneficios(Beneficios.PRATA.getBeneficios());
                break;
        }

        /*if(planoSelecionado.equals("DIAMANTE")) {
            aluno.setPlano(planoSelecionado);
            aluno.setMensalidade(Mensalidade.DIAMANTE.getMensalidade());
            aluno.setBeneficios(Beneficios.DIAMANTE.getBeneficios());

        } else if(planoSelecionado.equals("OURO")) {
            aluno.setPlano(planoSelecionado);
            aluno.setMensalidade(Mensalidade.OURO.getMensalidade());
            aluno.setBeneficios(Beneficios.OURO.getBeneficios());

        } else if(planoSelecionado.equals("PRATA")) {
            aluno.setPlano(planoSelecionado);
            aluno.setMensalidade(Mensalidade.PRATA.getMensalidade());
            aluno.setBeneficios(Beneficios.PRATA.getBeneficios());
        }*/

        return planoSelecionado;
    }

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public ResponseEntity<String> login(Aluno aluno) {
        Aluno al = alunoRepository.findByUsarname(aluno.getUsarname());

        if(al != null && al.getSenha().equals(aluno.getSenha())){
            return ResponseEntity.ok("Login realizado");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public void deleteById(Long id) {
        alunoRepository.deleteById(id);
    }

    @Transactional
    public Aluno update(Long id, Aluno aluno) {
        aluno.setId(id);
        //tipoPlano(aluno);
        return alunoRepository.save(aluno);
    }
}
