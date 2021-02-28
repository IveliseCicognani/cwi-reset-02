package br.com.banco.desgraca.domain.contas;
import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.domain.enumeradores.InstituicaoBancaria;
import br.com.banco.desgraca.domain.enumeradores.TipoConta;
import br.com.banco.desgraca.domain.enumeradores.TipoTransacao;
import br.com.banco.desgraca.exception.ValidaInstituicao;
import br.com.banco.desgraca.exception.ValorInformadoInvalido;

import java.text.DecimalFormat;

public class ContaDigital extends DadosContaBancaria implements ContaBancaria {


    public ContaDigital(InstituicaoBancaria instituicaoBancaria, int numeroConta) {
        super(instituicaoBancaria, numeroConta);
        setTipoConta(TipoConta.CONTA_DIGITAL);
        validaContaDigital();
    }

    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return super.getInstituicaoBancaria();
    }

    @Override
    public Double consultarSaldo() {
        System.out.println("\n\t\tSeu saldo atual é de: R$ " +super.consultarSaldo());
        return super.consultarSaldo();
    }

    @Override
    public void sacar(Double valor) {
        verificaSaldoPositivo(valor, getSaldo());
        if(valor >= 10){
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
        mesmaConta(contaDestino);
        verificaSaldoPositivo(valor, getSaldo());
        setSaldo(getSaldo() - valor);
        transacao.add(new Transacao(TipoTransacao.TRANSFERENCIA, Data.getDataTransacao(), valor));
        System.out.println("\n\t\t----- TRANSFERINDO "+ DecimalFormat.getCurrencyInstance().format(valor)+ " -----\n\t\t DE: " +getTipoConta().getDescricao()+
                " " +getInstituicaoBancaria().getDescricao()+" " +super.getNumeroConta()+ "\n\t\t PARA: "
                + ((DadosContaBancaria)contaDestino).getTipoConta().getDescricao()+ " "
                +contaDestino.getInstituicaoBancaria().getDescricao()+" " +((DadosContaBancaria)contaDestino).getNumeroConta()+"");

        contaDestino.depositar(valor);
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
