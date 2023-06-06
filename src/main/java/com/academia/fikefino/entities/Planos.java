package com.academia.fikefino.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_planos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Planos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String diamante = "DIAMANTE";
    @NotNull
    private String ouro = "OURO";
    @NotNull
    private String prata = "PRATA";
    @ManyToMany(mappedBy = "plano")
    private Set<Aluno> aluno;

}
