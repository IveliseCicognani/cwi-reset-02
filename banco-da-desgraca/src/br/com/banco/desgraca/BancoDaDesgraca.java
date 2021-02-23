package br.com.banco.desgraca;

import br.com.banco.desgraca.domain.conta.ContaBancaria;
import br.com.banco.desgraca.domain.conta.ContaPoupanca;
import br.com.banco.desgraca.domain.enumeradores.InstituicaoBancaria;
import br.com.banco.desgraca.domain.conta.ContaCorrente;
import br.com.banco.desgraca.domain.enumeradores.TipoConta;

import java.time.LocalDate;

public class BancoDaDesgraca {

    public static void main(String[] args) throws Exception {

        ContaPoupanca cp1 = new ContaPoupanca(InstituicaoBancaria.BANCO_DO_BRASIL, 554);
        ContaPoupanca cp2 = new ContaPoupanca(InstituicaoBancaria.BANCO_DO_BRASIL, 120);

        cp1.setSaldo(500.00);
        cp1.transferir(51.0,cp2);
        cp1.exibirExtrato(LocalDate.of(2020,02,22), LocalDate.of(2021,02,22));


    }
}
