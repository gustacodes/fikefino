package com.academia.fikefino.controller;

import com.academia.fikefino.entities.Aluno;
import com.academia.fikefino.entities.Planos;
import com.academia.fikefino.repositories.PlanosRepository;
import com.academia.fikefino.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/aluno")
@Validated
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private PlanosRepository planosRepository;

    @GetMapping
    public ModelAndView findAll() {
        List<Aluno> alunos = alunoService.findAll();
        ModelAndView mv = new ModelAndView("alunos");
        mv.addObject("alunos", alunos);
        return mv;
    }

    @GetMapping("/cadastro")
    public ModelAndView cadastro() {
        ModelAndView mv = new ModelAndView("cadastro");
        mv.addObject("aluno", new Aluno());
        return mv;
    }

    @PostMapping("/cadastro")
    public String save(Aluno aluno, @RequestParam("opcao") String opcaoSelecionada, BindingResult result) {

        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView("cadastro");
            mv.addObject("aluno", aluno);
            return "/aluno/cadastro";
        }
            var meuPlano = new Planos();
            meuPlano.setPlano(opcaoSelecionada);
            planosRepository.save(meuPlano);
            Aluno plano = alunoService.tipoPlano(opcaoSelecionada, meuPlano.getId(), aluno);

            return "redirect:/aluno";


    }

    @DeleteMapping("/{id}")
    public RedirectView deleteById(@PathVariable Long id) {
        alunoService.deleteById(id);
        return new RedirectView("/aluno");
    }

    @PutMapping("/{id}")
    public RedirectView update(@PathVariable Long id, @RequestParam("opcao") String opcaoSelecionada, Aluno aluno) {
        var meuPlano = new Planos();
        meuPlano.setPlano(opcaoSelecionada);
        planosRepository.save(meuPlano);
        Aluno plano = alunoService.tipoPlano(opcaoSelecionada, meuPlano.getId(), aluno);
        return new RedirectView("/aluno");
    }

}
