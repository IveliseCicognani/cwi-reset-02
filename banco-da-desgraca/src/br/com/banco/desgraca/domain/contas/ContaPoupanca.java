package br.com.banco.desgraca.domain.contas;
import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.domain.enumeradores.InstituicaoBancaria;
import br.com.banco.desgraca.domain.enumeradores.TipoConta;
import br.com.banco.desgraca.domain.enumeradores.TipoTransacao;
import br.com.banco.desgraca.exception.ValidaInstituicao;
import br.com.banco.desgraca.exception.ValorInformadoInvalido;

import java.text.DecimalFormat;

public class ContaPoupanca extends DadosContaBancaria implements ContaBancaria{

    public ContaPoupanca(InstituicaoBancaria instituicaoBancaria, int numeroConta) {
        super(instituicaoBancaria, numeroConta);
        setTipoConta(TipoConta.CONTA_POUPANCA);
        validaContaPoupanca();
    }

    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return super.getInstituicaoBancaria();
    }

    @Override
    public void sacar(Double valor) {
        verificaSaldoPositivo(valor, getSaldo());
        if (valor >= 50){
            valor += valor * 0.02;
            setSaldo(getSaldo() - valor);
        } else {
            throw new ValorInformadoInvalido("Valor informado é inválido para saque!");
        }
        transacao.add(new Transacao(TipoTransacao.SAQUE, Data.getDataTransacao(), valor));
        System.out.println("\n\t\t----- SACANDO "+ DecimalFormat.getCurrencyInstance().format(valor)+ " -----\n\t\t DE: " +getTipoConta().getDescricao()+
                " " +getInstituicaoBancaria().getDescricao()+" " +super.getNumeroConta()+ "");

    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        Double valorOriginal = valor;
        mesmaConta(contaDestino);
        if (contaDestino.getInstituicaoBancaria() == (super.getInstituicaoBancaria())) {
            valor += valor * 0.05;
        } else {
            valor += valor * 0.1;
        }
        verificaSaldoPositivo(valor, getSaldo());
        setSaldo(getSaldo() - valor);
        transacao.add(new Transacao(TipoTransacao.TRANSFERENCIA, Data.getDataTransacao(), valor));
        System.out.println("\n\t\t----- TRANSFERINDO " + DecimalFormat.getCurrencyInstance().format(valor) + " -----\n\t DE: " + getTipoConta().getDescricao() +
                " " + getInstituicaoBancaria().getDescricao() + " " + super.getNumeroConta() + "\n\t PARA: "
                + ((DadosContaBancaria) contaDestino).getTipoConta().getDescricao() + " "
                + contaDestino.getInstituicaoBancaria().getDescricao() + " " + ((DadosContaBancaria) contaDestino).getNumeroConta() + "");

        contaDestino.depositar(valorOriginal);
    }

        public void validaContaPoupanca(){
        if (super.getInstituicaoBancaria().equals(InstituicaoBancaria.NUBANK)){
            throw new ValidaInstituicao("Instituição não permite Poupança!");
        }
    }

    @Override
    public Double consultarSaldo() {
        System.out.println("\n\t\tSeu saldo atual é de: R$ " +super.consultarSaldo());
        return super.consultarSaldo();
    }

    @Override
    public String toString() {
        return "Conta Poupança ";
    }
}
