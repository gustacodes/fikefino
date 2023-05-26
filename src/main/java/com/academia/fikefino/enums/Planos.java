package com.academia.fikefino.enums;

public enum Planos {

    DIAMANTE("DIAMANTE"),
    OURO("OURO"),
    PRATA("PRATA");

    private String planos;
    Planos(String planos) {
        this.planos = planos;
    }

    public String getPlanos() {
        return planos;
    }

}
