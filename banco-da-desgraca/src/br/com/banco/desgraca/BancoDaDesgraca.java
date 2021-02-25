package br.com.banco.desgraca;

import br.com.banco.desgraca.domain.contas.ContaBancaria;
import br.com.banco.desgraca.domain.contas.ContaCorrente;
import br.com.banco.desgraca.domain.contas.ContaDigital;
import br.com.banco.desgraca.domain.contas.ContaPoupanca;
import br.com.banco.desgraca.domain.enumeradores.InstituicaoBancaria;

import java.time.LocalDate;

public class BancoDaDesgraca {

    public static void main(String[] args) throws Exception {

//        ContaCorrente cp1 = new ContaCorrente(InstituicaoBancaria.ITAU, 884);
//        ContaDigital cp2 = new ContaDigital(InstituicaoBancaria.ITAU,665);
        ContaPoupanca cp1 = new ContaPoupanca(InstituicaoBancaria.ITAU, 884);
        ContaDigital cp2 = new ContaDigital(InstituicaoBancaria.NUBANK,665);

        cp1.setSaldo(500.00);
       cp1.sacar(60.0);
        cp1.transferir(100.00,cp2);
        cp2.transferir(50.00,cp1);
        //cp2.depositar(100.0);
        //cp2.sacar(10.0);
        cp1.consultarSaldo();

       cp1.exibirExtrato(LocalDate.of(2020,02,22), LocalDate.of(2021,02,22));
       cp2.exibirExtrato(LocalDate.of(2020,02,22), LocalDate.of(2021,02,22));


    }
}
