package com.academia.fikefino.enums;

public enum Beneficios {

    DIAMANTE("Passeio de lancha com Iran"),
    OURO("Passeio de Jangada com Iran"),
    PRATA("Passeio de Canoa com Iran");

    private String beneficios;

    Beneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public String getBeneficios() {
        return beneficios;
    }
}
