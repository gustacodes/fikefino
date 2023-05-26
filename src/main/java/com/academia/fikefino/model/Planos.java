package com.academia.fikefino.model;

public enum Planos {

    DIAMANTE("DIAMANTE"),
    OURO("OUTO"),
    PRATA("PRATA");

    private String planos;
    Planos(String planos) {
        this.planos = planos;
    }

    public String getPlanos() {
        return planos;
    }

}
