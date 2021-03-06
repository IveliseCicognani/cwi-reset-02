package br.com.cwi.resetflix.entity;

import br.com.cwi.resetflix.domain.Genero;

import java.util.List;

public class SeriesEntity {

    private Long id;
    private int episodios;
    private Genero genero;
    private Long idDiretor;
    private List<Long> idsAtores;
    private String nome;
    private int temporadas;

    public SeriesEntity(int episodios, Genero genero, Long idDiretor, List<Long> idsAtores, String nome, int temporadas) {
        this.episodios = episodios;
        this.genero = genero;
        this.idDiretor = idDiretor;
        this.idsAtores = idsAtores;
        this.nome = nome;
        this.temporadas = temporadas;
    }

    public SeriesEntity(Long id, int episodios, Genero genero, Long idDiretor, List<Long> idsAtores, String nome, int temporadas) {
        this.id = id;
        this.episodios = episodios;
        this.genero = genero;
        this.idDiretor = idDiretor;
        this.idsAtores = idsAtores;
        this.nome = nome;
        this.temporadas = temporadas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Long getIdDiretor() {
        return idDiretor;
    }

    public void setIdDiretor(Long idDiretor) {
        this.idDiretor = idDiretor;
    }

    public List<Long> getIdsAtores() {
        return idsAtores;
    }

    public void setIdsAtores(List<Long> idsAtores) {
        this.idsAtores = idsAtores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }
}
