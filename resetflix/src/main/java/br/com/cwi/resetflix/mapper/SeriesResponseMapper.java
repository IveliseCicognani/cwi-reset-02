package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.SeriesEntity;
import br.com.cwi.resetflix.response.SerieResponse;

import java.util.ArrayList;
import java.util.List;

public class SeriesResponseMapper {

    public List<SerieResponse> mapear(List<SeriesEntity> series){
        List<SerieResponse> seriesEncontradas = new ArrayList<>();

        for(SeriesEntity seriesEntity : series){
            seriesEncontradas.add(new SerieResponse(seriesEntity.getId(), seriesEntity.getNome(),
                                        seriesEntity.getGenero()));
        }

        return seriesEncontradas;

    }
}
