package com.academia.fikefino.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_mensalidade")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mensalidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    public static Double mensalidadeDiamante = 199.9;
    @NotNull
    public static Double mensalidadeOuro = 149.9;
    @NotNull
    public static Double mensalidadePrata = 99.9;

}
