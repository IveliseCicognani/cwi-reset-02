package br.com.banco.desgraca.domain;

import br.com.banco.desgraca.domain.enumeradores.TipoTransacao;

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
}

