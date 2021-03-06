package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.entity.SeriesEntity;
import br.com.cwi.resetflix.request.CriarFilmeRequest;
import br.com.cwi.resetflix.request.CriarSerieRequest;

public class SeriesEntityMapper {

    public SeriesEntity mapear(CriarSerieRequest request){
        return new SeriesEntity(request.getEpisodios(), request.getGenero(), request.getIdDiretor(), request.getIdsAtores(), request.getNome(),
                request.getTemporadas());
    }
}
