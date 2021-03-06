package br.com.cwi.resetflix.response;

import java.util.List;

import br.com.cwi.resetflix.domain.Genero;

public class ConsultarDetalhesSerieResponse {
    private Long id;
    private String nome;
    private Genero genero;
    private DiretoresResponse diretor;
    private List<AtoresResponse> atores;

    public ConsultarDetalhesSerieResponse(Long id, String nome, Genero genero, DiretoresResponse diretor, List<AtoresResponse> atores) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.diretor = diretor;
        this.atores = atores;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Genero getGenero() {
        return genero;
    }

    public DiretoresResponse getDiretor() {
        return diretor;
    }

    public List<AtoresResponse> getAtores() {
        return atores;
    }
}


