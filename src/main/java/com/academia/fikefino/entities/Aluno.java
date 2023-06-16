package com.academia.fikefino.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

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
    @NotEmpty(message = "Campo nome obrigatório")
    private String nome;
    @NotEmpty(message = "Campo e-mail obrigatório")
    @Email(message = "E-mail inválido")
    private String email;
    @NotEmpty(message = "Campo usuario obrigatório")
    private String username;
    @NotEmpty(message = "Campo CPF obrigatório")
    @CPF
    private String cpf;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Past
    private LocalDate dataNascimento;
    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Planos plano;
    @NotBlank
    private String meuPlano;
    private Double mensalidade;
    private String beneficios;

}
