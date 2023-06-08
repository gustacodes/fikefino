package com.academia.fikefino.component;

import com.academia.fikefino.entities.Papeis;
import com.academia.fikefino.repositories.PapeisRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CarregadoraDados implements CommandLineRunner {

    @Autowired
    private PapeisRespository papelRepository;

    @Override
    public void run(String... args) throws Exception {

        String[] papeis = {"ADMIN", "USER"};

        for (String papelString: papeis) {
            Papeis papel = papelRepository.findByNome(papelString);
            if (papel == null) {
                papel = new Papeis(papelString);
                papelRepository.save(papel);
            }
        }
    }

}
