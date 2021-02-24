package br.com.banco.desgraca.domain.enumeradores;

public enum TipoTransacao {
    SAQUE("Saque", "-"),
    DEPOSITO("Depósito", "+"),
    TRANSFERENCIA("Transferência", "-"),
    EXTRATO("Extrato", " "),
    SALDO("Saldo", " ");

    private String descricao;
    private String fator;

    TipoTransacao(String descricao, String fator) {
        this.descricao = descricao;
        this.fator = fator;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getFator() {
        return fator;
    }
}