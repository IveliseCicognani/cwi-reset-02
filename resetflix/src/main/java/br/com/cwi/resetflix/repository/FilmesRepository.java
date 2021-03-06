package br.com.cwi.resetflix.repository;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.cwi.resetflix.exception.NotFoundMessageException;
import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.FilmeEntity;

@Repository
public class FilmesRepository {

    static List<FilmeEntity> filmes = new ArrayList<>();
    private Long contadorIds = 1l;

    public List<FilmeEntity> getFilmes(){
        return filmes;
    }

    public Long criarFilme(FilmeEntity filmeSalvar){
        if(filmeSalvar.getId() == null){
            filmeSalvar.setId(contadorIds);
            contadorIds++;
        }

        filmes.add(filmeSalvar);
        return filmeSalvar.getId();
    }

    public List<FilmeEntity> acharFilmesAtor(final Long id) {
        List<FilmeEntity> filmesAtores = new ArrayList<FilmeEntity>();
        for (FilmeEntity filmeEntity : filmes) {
            for (Long idAtor : filmeEntity.getIdsAtores()) {
                if (idAtor.equals(id)) {
                    filmesAtores.add(filmeEntity);
                }
            }
        }
        return filmesAtores;
    }

    public List<FilmeEntity> acharFilmesDiretor(Long id) {
        List<FilmeEntity> filmesDiretores = new ArrayList<FilmeEntity>();
        for (FilmeEntity filmeEntity : filmes) {
            if (filmeEntity.getIdDiretor().equals(id)) {
                filmesDiretores.add(filmeEntity);
            }
        }
        return filmesDiretores;
    }

    public FilmeEntity acharFilmePorId(Long id) {
        for (FilmeEntity filmeEntity : filmes) {
            if (filmeEntity.getId().equals(id)) {
                return filmeEntity;
            }else {
                throw new NotFoundMessageException("Não foi possível localizar o filme informado!");
            }
        }
        return null;
    }
}
