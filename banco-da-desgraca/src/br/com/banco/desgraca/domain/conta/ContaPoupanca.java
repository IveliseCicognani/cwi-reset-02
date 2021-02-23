package br.com.banco.desgraca.domain.conta;
import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.domain.enumeradores.InstituicaoBancaria;
import br.com.banco.desgraca.domain.DadosContaBancaria;
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
        return null;
    }

    @Override
    public void sacar(Double valor) {

        if (valor >= 50){
            valor +=valor*0.2;
            verificaSaldoPositivo(valor,getSaldo());
            setSaldo(getSaldo() + valor);

            System.out.println("Sacando valor R$ "+DecimalFormat.getCurrencyInstance().format(valor)+ " da " +getTipoConta()+
                    " "+getInstituicaoBancaria());
            transacao.add(new Transacao(TipoTransacao.SAQUE, Data.getDataTransacao(),valor));
        }else {
            throw new ValorInformadoInvalido("Valor informado é inválido para saque!");
        }

    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        if(contaDestino.getInstituicaoBancaria() == (getInstituicaoBancaria())){
            valor +=valor*0.05;
            verificaSaldoPositivo(valor,getSaldo());
            setSaldo(getSaldo() + valor);
            transacao.add(new Transacao(TipoTransacao.TRANSFERENCIA, Data.getDataTransacao(), valor));
        }else {
            valor+=valor*0.1;
            verificaSaldoPositivo(valor,getSaldo());
            setSaldo(getSaldo() + valor);
            transacao.add(new Transacao(TipoTransacao.TRANSFERENCIA, Data.getDataTransacao(), valor));
        }
        System.out.println("Transferindo valor "+ DecimalFormat.getCurrencyInstance().format(valor)+ " da " +super.getTipoConta().getDescricao()+
                " " +super.getInstituicaoBancaria().getDescricao()+", Número " +super.getNumeroConta()+ " para a " +
                " conta " +contaDestino.getInstituicaoBancaria()+".");

    }

    public void validaContaPoupanca(){
        if (super.getInstituicaoBancaria().equals(InstituicaoBancaria.NUBANK)){
            throw new ValidaInstituicao("Instituição não permite Poupança");
        }
    }

    @Override
    public String toString() {
        return "Conta Poupança "+super.toString();
    }
}
