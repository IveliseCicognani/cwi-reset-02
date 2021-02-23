package br.com.banco.desgraca.exception;

public class ValidaInstituicao extends RuntimeException {

    public ValidaInstituicao(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}
