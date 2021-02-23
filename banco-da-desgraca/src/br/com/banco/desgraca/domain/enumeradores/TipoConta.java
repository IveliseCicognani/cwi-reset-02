package br.com.banco.desgraca.domain.enumeradores;

public enum TipoConta {

    CONTA_CORRENTE ("Conta Corrente"),
    CONTA_POUPANCA ("Conta Poupança"),
    CONTA_DIGITAL ("Conta Digital");

    private String descricao;

    TipoConta(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
