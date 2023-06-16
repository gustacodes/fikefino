package com.academia.fikefino.services;

import com.academia.fikefino.entities.Aluno;
import com.academia.fikefino.entities.Planos;
import com.academia.fikefino.enums.Beneficios;
import com.academia.fikefino.enums.Mensalidade;
import com.academia.fikefino.repositories.AlunoRepository;
import com.academia.fikefino.repositories.PlanosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private PlanosRepository planosRepository;

    //Método de seleção do plano (Tipo, Mensalidade e Benefício)
    public Aluno tipoPlano(String planoSelecionado, Long id, Aluno aluno) {

        Optional<Planos> meuPlano = planosRepository.findById(id);

        if(meuPlano.isPresent() && meuPlano.get().getPlano().equals("DIAMANTE")) {
            Planos planoEscolhido = meuPlano.get();
            aluno.setPlano(planoEscolhido);
            aluno.setMeuPlano(meuPlano.get().getPlano());
            aluno.setMensalidade(Mensalidade.DIAMANTE.getMensalidade());
            aluno.setBeneficios(Beneficios.DIAMANTE.getBeneficios());

        } else if(meuPlano.isPresent() && meuPlano.get().getPlano().equals("OURO")) {
            Planos planoEscolhido = meuPlano.get();
            aluno.setPlano(planoEscolhido);
            aluno.setMeuPlano(meuPlano.get().getPlano());
            aluno.setMensalidade(Mensalidade.OURO.getMensalidade());
            aluno.setBeneficios(Beneficios.OURO.getBeneficios());

        } else if(meuPlano.isPresent() && meuPlano.get().getPlano().equals("PRATA")) {
            Planos planoEscolhido = meuPlano.get();
            aluno.setPlano(planoEscolhido);
            aluno.setMeuPlano(meuPlano.get().getPlano());
            aluno.setMensalidade(Mensalidade.PRATA.getMensalidade());
            aluno.setBeneficios(Beneficios.PRATA.getBeneficios());
        } else {

            throw new IllegalArgumentException("Plano não encontrado");
        }

        return alunoRepository.save(aluno);
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public void deleteById(Long id) {
        alunoRepository.deleteById(id);
    }

    public Optional<Aluno> findById(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno;
    }
}
