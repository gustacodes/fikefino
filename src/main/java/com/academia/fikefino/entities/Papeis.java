package com.academia.fikefino.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "tb_papeis")
@AllArgsConstructor
@NoArgsConstructor
public class Papeis {

    @Id
    private String nome;
    @ManyToMany(mappedBy = "papeis")
    private Set<Admin> admins;

    public Papeis(String nome) {
        this.nome = nome;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(Set<Admin> admins) {
        this.admins = admins;
    }
}
