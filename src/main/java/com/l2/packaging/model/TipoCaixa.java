package com.l2.packaging.model;

import java.util.Arrays;
import java.util.Comparator;

public enum TipoCaixa {
    CAIXA_1("Caixa 1", 30, 40, 80),
    CAIXA_2("Caixa 2", 80, 50, 40),
    CAIXA_3("Caixa 3", 50, 80, 60);

    private final String descricao;
    private final int altura;
    private final int largura;
    private final int comprimento;

    TipoCaixa(String descricao, int altura, int largura, int comprimento) {
        this.descricao = descricao;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getAltura() {
        return altura;
    }

    public int getLargura() {
        return largura;
    }

    public int getComprimento() {
        return comprimento;
    }

    public int getVolume() {
        return altura * largura * comprimento;
    }

    public static TipoCaixa findCaixa(int alturaItem, int larguraItem, int comprimentoItem) {
        return Arrays.stream(TipoCaixa.values())
                .filter(caixa -> alturaItem <= caixa.getAltura() &&
                        larguraItem <= caixa.getLargura() &&
                        comprimentoItem <= caixa.getComprimento())
                .min(Comparator.comparingInt(TipoCaixa::getVolume))
                .orElse(null);
    }
}
