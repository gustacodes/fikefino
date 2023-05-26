package com.academia.fikefino.model;

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
