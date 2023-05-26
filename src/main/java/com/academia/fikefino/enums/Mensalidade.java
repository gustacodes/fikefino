package com.academia.fikefino.enums;

public enum Mensalidade {

    DIAMANTE(199.9),
    OURO(149.9),
    PRATA(99.9);

    private Double mesalidade;
    Mensalidade(Double mesalidade) {
        this.mesalidade = mesalidade;
    }

    public Double getMensalidade() {
        return mesalidade;
    }
}
