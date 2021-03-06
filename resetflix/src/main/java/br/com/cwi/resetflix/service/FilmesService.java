package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesFilmesResponseMapper;
import br.com.cwi.resetflix.mapper.FilmeEntityMapper;
import br.com.cwi.resetflix.mapper.FilmeResponseMapper;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.DiretoresRepository;
import br.com.cwi.resetflix.repository.FilmesRepository;
import br.com.cwi.resetflix.request.CriarFilmeRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;
import br.com.cwi.resetflix.response.FilmeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmesService {

    @Autowired
    private DiretoresRepository diretoresRepository;

    @Autowired
    AtoresRepository atoresRepository;

    @Autowired
    private FilmesRepository filmesRepository;

    static FilmeEntityMapper MAPPER_ENTITY = new FilmeEntityMapper();
    static FilmeResponseMapper MAPPER_RESPONSE = new FilmeResponseMapper();
    static ConsultarDetalhesFilmesResponseMapper MAPPER_DETALHES_FILME = new ConsultarDetalhesFilmesResponseMapper();

    public Long criarFilme(CriarFilmeRequest request){
        FilmeEntity filmeSalvar = MAPPER_ENTITY.mapear(request);
        return filmesRepository.criarFilme(filmeSalvar);
    }

    public List<FilmeResponse> getFilmes(Genero genero) {

        List<FilmeEntity> filmes = filmesRepository.getFilmes();
        List<FilmeEntity> filmesGenero = new ArrayList<FilmeEntity>();

        if (genero != null) {
            for (FilmeEntity filme : filmes) {
                if (filme.getGenero().equals(genero)) {
                    filmesGenero.add(filme);
                }
            }
            return MAPPER_RESPONSE.mapear(filmesGenero);
        }
        return MAPPER_RESPONSE.mapear(filmes);
    }

    public ConsultarDetalhesFilmeResponse consultaDetalhesFilmes(Long id) {
        FilmeEntity filmeSalvo = filmesRepository.acharFilmePorId(id);
        DiretorEntity diretor = diretoresRepository.acharDiretorPorId(filmeSalvo.getIdDiretor());
        List<AtorEntity> atores = atoresRepository.listaDeFilmesPorAtor(id);
        return MAPPER_DETALHES_FILME.mapear(filmeSalvo, diretor, atores);


    }
}
