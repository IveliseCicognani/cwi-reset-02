package br.com.cwi.resetflix.repository;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.SeriesEntity;
import br.com.cwi.resetflix.exception.NotFoundMessageException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SeriesRepository {

    private List<SeriesEntity> series = new ArrayList<>();
    private Long contadorIds = 1l;


    public List<SeriesEntity> getSeries(){
        return series;
    }

    public Long criarSerie(SeriesEntity serieSalvar){
        if(serieSalvar.getId() == null){
            serieSalvar.setId(contadorIds);
            contadorIds++;
        }
        series.add(serieSalvar);
        return serieSalvar.getId();
    }

    public SeriesEntity encontrarSeriePorId(Long id){
        for(SeriesEntity seriesEntity : series){
            if(seriesEntity.getId().equals(id)){
                return seriesEntity;
            }else{
                throw new NotFoundMessageException("Não foi possível localizar a série informado!");
            }
        }
        return null;
    }



    public List<Long> acharAtoresSerieporId(Long id){
        for (SeriesEntity serie : series){
             if(serie.getId().equals(id)){
                    return serie.getIdsAtores();
                }
            }
        return null;
    }
}
