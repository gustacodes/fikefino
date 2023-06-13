package com.academia.fikefino.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@Table(name = "tb_papeis")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Papeis implements GrantedAuthority {

    @Id
    private String nome;
    @ManyToMany(mappedBy = "papeis")
    private Set<Usuario> admins;

    public Papeis(String nome) {
        this.nome = nome;
    }

    @Override
    public String getAuthority() {
        return nome;
    }
}
