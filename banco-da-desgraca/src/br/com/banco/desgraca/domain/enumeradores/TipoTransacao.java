package br.com.banco.desgraca.domain.enumeradores;

public enum TipoTransacao {
    SAQUE("Saque"),
    DEPOSITO("Depósito"),
    TRANSFERENCIA("Transferência"),
    EXTRATO("Extrato"),
    SALDO("Saldo");

    TipoTransacao(String descricao) {
        this.descricao = descricao;
    }

    private String descricao;

}