package com.academia.fikefino.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_aluno")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @Email
    private String email;
    @NotBlank
    private String senha;
    @NotBlank
    private String usarname;
    @NotBlank
    private String cpf;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;
    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Planos plano;
    private Double mensalidade;
    private String beneficios;

}
