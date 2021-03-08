package br.com.cwi.resetflix.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

public class DiretorEntity {
    
    Long id;
    String nome;
    List<Long> idsFilmes;

    public DiretorEntity(String nome, List<Long> idsFilmes) {
        this.nome = nome;
        this.idsFilmes = idsFilmes;
    }

    public DiretorEntity(Long id, String nome, List<Long> idsFilmes) {
        this.id = id;
        this.nome = nome;
        this.idsFilmes = idsFilmes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Long> getIdsFilmes() {
        return idsFilmes;
    }

    public void setIdsFilmes(List<Long> idsFilmes) {
        this.idsFilmes = idsFilmes;
    }
}
