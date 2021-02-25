package br.com.banco.desgraca.exception;

public class ValidaMesmaContaException extends RuntimeException {

    public ValidaMesmaContaException(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}