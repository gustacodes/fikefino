package com.academia.fikefino.model;

import org.springframework.stereotype.Component;

@Component
public enum Planos {

    DIAMANTE("DIAMANTE"),
    OURO("OUTO"),
    PRATA("PRATA"),
    BRONZE("BRONZE");

    private String planos;
    Planos(String planos) {
        this.planos = planos;
    }

    public String getPlanos() {
        return planos;
    }

}
