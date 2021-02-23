package br.com.banco.desgraca.exception;

public class ValorInformadoInvalido extends RuntimeException {

    public ValorInformadoInvalido(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}
