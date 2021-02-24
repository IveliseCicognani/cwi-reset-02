package br.com.banco.desgraca.domain.enumeradores;

public enum InstituicaoBancaria {

    BANCO_DO_BRASIL("Banco do Brasil"),
    BRADESCO("Bradesco"),
    CAIXA("Caixa"),
    ITAU("Itaú"),
    NUBANK("Nubank");

    protected String descricao;

    InstituicaoBancaria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
