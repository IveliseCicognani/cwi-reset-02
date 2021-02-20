package com.company.domain;
import com.company.exception.ExceptionEditora;

public class Editora {
    private String nome;
    private String localizacao;

    public Editora(String nome, String localizacao) {
       validaEditora(nome);
        this.nome = nome;
        this.localizacao = localizacao;
    }

    private void validaEditora(String nome){
        if(nome.equals(("DC Comics"))){
        throw new ExceptionEditora("Não é possível cadastrar esta editora.");
    }
    }

    public String getNome() {
        return nome;
    }
}
