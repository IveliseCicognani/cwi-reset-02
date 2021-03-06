package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.entity.SeriesEntity;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesSerieResponseMapper;
import br.com.cwi.resetflix.mapper.SeriesEntityMapper;
import br.com.cwi.resetflix.mapper.SeriesResponseMapper;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.DiretoresRepository;
import br.com.cwi.resetflix.repository.SeriesRepository;
import br.com.cwi.resetflix.request.CriarSerieRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesSerieResponse;
import br.com.cwi.resetflix.response.SerieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeriesService {

    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private DiretoresRepository diretoresRepository;

    @Autowired
    private AtoresRepository atoresRepository;

    static SeriesEntityMapper MAPPER_ENTITY = new SeriesEntityMapper();
    static SeriesResponseMapper MAPPER_RESPONSE = new SeriesResponseMapper();
    static ConsultarDetalhesSerieResponseMapper MAPPER_DETALHES_SERIE = new ConsultarDetalhesSerieResponseMapper();

    public Long criarSerie(CriarSerieRequest request){
        SeriesEntity serieSalvar = MAPPER_ENTITY.mapear(request);
        return seriesRepository.criarSerie(serieSalvar);
    }

    public List<SerieResponse> getSeries(Genero genero) {

        List<SeriesEntity> series = seriesRepository.getSeries();
        List<SeriesEntity> seriesGenero = new ArrayList<>();

        if(genero != null){
            for(SeriesEntity serie : series){
                if(serie.getGenero().equals(genero)){
                    seriesGenero.add(serie);
                }
            }
            return MAPPER_RESPONSE.mapear(seriesGenero);
        }
        return MAPPER_RESPONSE.mapear(series);
    }

    public ConsultarDetalhesSerieResponse consultarDetalhesSeries(Long id) {
        SeriesEntity serieSalva = seriesRepository.encontrarSeriePorId(id);
        DiretorEntity diretor = diretoresRepository.acharDiretorPorId(serieSalva.getId());
        List<Long> idsAtoresSerie = seriesRepository.acharAtoresSerieporId(id);
        List<AtorEntity> atoresSerie = atoresRepository.acharAtoresDaSerie(idsAtoresSerie);
        return MAPPER_DETALHES_SERIE.mapear(serieSalva, diretor, atoresSerie);



    }
}
