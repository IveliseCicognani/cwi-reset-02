package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.SeriesEntity;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesSerieResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;

import java.util.List;

public class ConsultarDetalhesSerieResponseMapper {
    public ConsultarDetalhesSerieResponse mapear(SeriesEntity serieSalva, DiretorEntity diretor, List<AtorEntity> atores) {
        DiretoresResponse diretoresResponse = new DiretoresResponse(diretor.getId(), diretor.getNome());
        List<AtoresResponse> atoresResponses = new AtoresResponseMapper().mapear(atores);

        return new ConsultarDetalhesSerieResponse(serieSalva.getId(), serieSalva.getNome(),
                serieSalva.getGenero(), diretoresResponse, atoresResponses);
    }
}
