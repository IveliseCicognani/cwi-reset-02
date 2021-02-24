package br.com.banco.desgraca.domain;

import br.com.banco.desgraca.domain.contas.DadosContaBancaria;
import br.com.banco.desgraca.domain.enumeradores.InstituicaoBancaria;
import br.com.banco.desgraca.domain.enumeradores.TipoConta;
import br.com.banco.desgraca.domain.enumeradores.TipoTransacao;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Date;

public class Transacao {

    public TipoTransacao tipoTransacao;
    public LocalDate dataTransacao;
    public Double valor;

    public Transacao(TipoTransacao tipoTransacao, LocalDate dataTransacao, Double valor) {
        this.tipoTransacao = tipoTransacao;
        this.dataTransacao = dataTransacao;
        this.valor = valor;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public Double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "   " + tipoTransacao.getFator()+
                "   R$ " + valor +
                "  " + dataTransacao +
                ' ';
    }

    //    @Override
//    public String toString() {
//        return " ---------- EXTRATO " + tipoConta.getDescricao() + " " + instituicaoBancaria.getDescricao()+
//                " " +conta.getNumeroConta()+ "----------\n"
//                +tipoTransacao.getFator()+
//                " R$ " + valor +
//                ", "+dataTransacao +
//                "------------------------------"+
//                '}';
//    }
}

