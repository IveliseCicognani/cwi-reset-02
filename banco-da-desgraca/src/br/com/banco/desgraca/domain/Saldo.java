package br.com.banco.desgraca.domain;

import java.text.DecimalFormat;

public class Saldo {

    private double saldo;

    public Saldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public String consultarSaldo() {
        return "O saldo atual da sua conta é: R$ " + DecimalFormat.getCurrencyInstance().format(saldo) + ".";
    }
}
