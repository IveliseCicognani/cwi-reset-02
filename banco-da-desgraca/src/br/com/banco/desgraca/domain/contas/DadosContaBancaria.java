package br.com.banco.desgraca.domain.contas;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.domain.enumeradores.InstituicaoBancaria;
import br.com.banco.desgraca.domain.enumeradores.TipoConta;
import br.com.banco.desgraca.domain.enumeradores.TipoTransacao;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class DadosContaBancaria {

    private int numeroConta;
    private InstituicaoBancaria instituicaoBancaria;
    private Double saldo;
    private TipoConta tipoConta;
    protected List<Transacao> transacao = new ArrayList<Transacao>();

    public DadosContaBancaria(InstituicaoBancaria instituicaoBancaria, int numeroConta) {
        this.instituicaoBancaria = instituicaoBancaria;
        this.numeroConta = numeroConta;
    }

    public Double consultarSaldo(){
        return getSaldo();
    }

    public void depositar(Double valor){
        saldo = saldo + valor;
        System.out.println("Depósito no valor R$ "+ DecimalFormat.getCurrencyInstance().format(valor)+ " na Conta" +numeroConta+".");
        transacao.add(new Transacao(TipoTransacao.DEPOSITO, Data.getDataTransacao(), valor));

    }

    public void exibirExtrato(LocalDate inicio, LocalDate fim){
        for(Transacao transacao : transacao){
            if (transacao.getDataTransacao().compareTo(inicio) >= 0 && transacao.getDataTransacao().compareTo(fim) <=0){
                System.out.println("\n ---------- EXTRATO " + tipoConta.getDescricao() + " "
                                + instituicaoBancaria.getDescricao()+ " "
                                +numeroConta+
                                " ----------");
                System.out.println(transacao.toString());
            }

        };
    }

    public boolean verificaSaldoPositivo(Double valor, Double saldo){
        if((saldo - valor) >= 0){
            return true;
        }
        else{
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar a transação!");
        }

    }

    @Override
    public String toString() {
        return "DadosContaBancaria{" +
                "numeroContaCorrente=" + getNumeroConta() +
                ", instituicaoBancaria=" + getInstituicaoBancaria().getDescricao() +
                ", saldo=" + getSaldo() +
                ", tipoConta=" + getTipoConta().getDescricao() +
                '}';
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public InstituicaoBancaria getInstituicaoBancaria() {
        return instituicaoBancaria;
    }

    public void setInstituicaoBancaria(InstituicaoBancaria instituicaoBancaria) {
        this.instituicaoBancaria = instituicaoBancaria;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

}
