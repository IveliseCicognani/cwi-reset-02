package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.DadosContaBancaria;
import br.com.banco.desgraca.domain.enumeradores.InstituicaoBancaria;
import br.com.banco.desgraca.exception.ValidaInstituicao;
import br.com.banco.desgraca.exception.ValorInformadoInvalido;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class ContaDigital extends DadosContaBancaria implements ContaBancaria {


    public ContaDigital(InstituicaoBancaria instituicaoBancaria, int numeroConta) {
        super(instituicaoBancaria, numeroConta);
    }

    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return null;
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

        if(valor >= 10){
            valor = valor;
        } else {
            throw new ValorInformadoInvalido("Valor informado é inválido para saque!");
        }
        System.out.println("Sacando valor R$ "+DecimalFormat.getCurrencyInstance().format(valor)+ " da " +toString());

    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        System.out.println("Transferindo valor R$ "+ DecimalFormat.getCurrencyInstance().format(valor)+ " da " +toString() +
                " para a " +contaDestino+".");
    }

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {

    }

    public void validaContaDigital(){
        if (!(getInstituicaoBancaria().equals(InstituicaoBancaria.ITAU) || getInstituicaoBancaria().equals(InstituicaoBancaria.NUBANK))){
            throw new ValidaInstituicao("Instituição não permite Conta Digital");
        }
    }

    @Override
    public String toString() {
        return "Conta Digital "+super.toString();
    }
}
