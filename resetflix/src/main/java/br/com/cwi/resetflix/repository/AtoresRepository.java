package br.com.cwi.resetflix.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.resetflix.entity.SeriesEntity;
import br.com.cwi.resetflix.exception.NotFoundException;
import br.com.cwi.resetflix.exception.NotFoundMessageException;
import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.entity.AtorEntity;

@Repository
public class AtoresRepository {

    static List<AtorEntity> atores = new ArrayList<>();
    static Long contadorIds = 1l;

    public List<AtorEntity> getAtores(){
        return atores;
    }

    public Long criarAtor(final AtorEntity atorSalvar) {
        if(atorSalvar.getId() == null){
            atorSalvar.setId(contadorIds);
            contadorIds++;
        }

        atores.add(atorSalvar);

        return atorSalvar.getId();
    }

    public AtorEntity acharAtorPorId(final Long id) {

        for(AtorEntity atorEntity : atores){
            if(atorEntity.getId().equals(id)){
                return atorEntity;
            }
            else{
                throw new NotFoundMessageException("Não foi possível localizar o ator informado!");
            }
        }

        return null;
    }

    public List<AtorEntity> acharAtoresDaSerie(List<Long> idAtoresSerie) {
        List<AtorEntity> listaAtoresDaSerie = new ArrayList<>();
        for (AtorEntity ator : atores){
            for(Long idAtor : idAtoresSerie){
                if(ator.getId().equals(idAtor)){
                    listaAtoresDaSerie.add(ator);
                }
            }
        }
        return listaAtoresDaSerie;
    }

    public List<AtorEntity> listaDeFilmesPorAtor(final Long id) {
        List<AtorEntity> filmesAtor = new ArrayList<AtorEntity>();
        for (AtorEntity ator : atores) {
            for (Long idFilme : ator.getIdsFilmes()) {
                if (idFilme.equals(id)) {
                    filmesAtor.add(ator);
                }
            }
        }
        return filmesAtor;
    }

}
