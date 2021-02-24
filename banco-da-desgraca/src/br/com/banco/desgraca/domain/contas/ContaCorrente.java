package br.com.banco.desgraca.domain.contas;
import br.com.banco.desgraca.domain.enumeradores.InstituicaoBancaria;
import br.com.banco.desgraca.exception.ValorInformadoInvalido;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class ContaCorrente extends DadosContaBancaria implements ContaBancaria {


    public ContaCorrente(InstituicaoBancaria instituicaoBancaria, int numeroConta) {
        super(instituicaoBancaria, numeroConta);
    }

    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return getInstituicaoBancaria();
    }

    @Override
    public Double consultarSaldo() {
        return null;
    }

    @Override
    public void depositar(Double valor) {

    }

    @Override
    public void sacar(Double valor) {
        if(valor % 5 == 0){
            valor = valor;
        }else{
            throw new ValorInformadoInvalido("Valor informado é inválido para saque!");
        }
        System.out.println("Sacando valor R$ " + DecimalFormat.getCurrencyInstance().format(valor) + " da " +toString());

    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        if(getInstituicaoBancaria().equals(contaDestino)){
           valor= valor;
        }else {
            valor=+valor*0.1;
        }
        System.out.println("Transferindo valor R$ "+ DecimalFormat.getCurrencyInstance().format(valor) + " da " +toString() +
                "para a " +contaDestino+".");
    }

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {

    }

    @Override
    public String toString() {
        return "Conta Corrente "+super.toString();
    }

}
