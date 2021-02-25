package br.com.banco.desgraca.domain.contas;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.domain.enumeradores.InstituicaoBancaria;
import br.com.banco.desgraca.domain.enumeradores.TipoConta;
import br.com.banco.desgraca.domain.enumeradores.TipoTransacao;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;
import br.com.banco.desgraca.exception.ValidaMesmaContaException;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class DadosContaBancaria{

    protected int numeroConta;
    private InstituicaoBancaria instituicaoBancaria;
    private Double saldo;
    protected TipoConta tipoConta;
    protected List<Transacao> transacao = new ArrayList<Transacao>();

    public DadosContaBancaria(InstituicaoBancaria instituicaoBancaria, int numeroConta) {
        this.instituicaoBancaria = instituicaoBancaria;
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
    }

    public Double consultarSaldo(){
        return getSaldo();
    }

    public boolean mesmaConta(ContaBancaria contaDestino){
        if ((contaDestino).equals(numeroConta)){
            throw new ValidaMesmaContaException("Conta de ORIGEM igual a DESTINO!");
        }else {
            return false;
        }
    }

    public void depositar(Double valor){
        setSaldo(getSaldo() + valor);
        transacao.add(new Transacao(TipoTransacao.DEPOSITO, Data.getDataTransacao(), valor));
        System.out.println("\n\t\t----- DEPOSITANDO "+ DecimalFormat.getCurrencyInstance().format(valor)+ " -----\n\t\t NA: " +getTipoConta().getDescricao()+
                " " +getInstituicaoBancaria().getDescricao()+" " +numeroConta+ "");
    }

    public void exibirExtrato(LocalDate inicio, LocalDate fim){
        System.out.println("\n\t----- EXTRATO " + tipoConta.getDescricao() + " "
                + getInstituicaoBancaria().getDescricao()+ " "
                +numeroConta+
                " -----");
        for(Transacao transacao : transacao){
            if (transacao.getDataTransacao().compareTo(inicio) >= 0 && transacao.getDataTransacao().compareTo(fim) <=0){
                System.out.println(transacao.toString());
            }
        }
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
