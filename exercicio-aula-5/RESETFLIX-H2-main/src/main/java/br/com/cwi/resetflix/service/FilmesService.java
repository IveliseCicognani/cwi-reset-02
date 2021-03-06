package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.exception.BadRequestException;
import br.com.cwi.resetflix.exception.NotFoundException;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesFilmeResponseMapper;
import br.com.cwi.resetflix.mapper.FilmeEntityMapper;
import br.com.cwi.resetflix.mapper.FilmeResponseMapper;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.DiretorRepository;
import br.com.cwi.resetflix.repository.FilmeRepository;
import br.com.cwi.resetflix.request.CriarFilmeRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.FilmeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.nonNull;
import static org.apache.logging.log4j.util.Strings.isEmpty;

@Service
public class FilmesService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private AtoresRepository atoresRepository;

    @Autowired
    private DiretorRepository diretoresRepository;

    @Autowired
    private FilmeResponseMapper filmeResponseMapper;

    @Autowired
    private FilmeEntityMapper filmeEntityMapper;

    @Autowired
    private ConsultarDetalhesFilmeResponseMapper consultarDetalhesFilmeResponseMapper;

    public List<FilmeResponse> getFilmes(final Genero genero) {

        final List<FilmeEntity> filmes;

        if (nonNull(genero)) {
            filmes = filmeRepository.findAllByGenero(genero);
        } else {
            filmes = filmeRepository.findAll();
        }

        return filmeResponseMapper.mapear(filmes);
    }

    public Long criarFilme(final CriarFilmeRequest request) {

        if (request == null || isEmpty(request.getNome())) {
            throw new BadRequestException("Dados inválidos para cadastro de filme");
        }

        final FilmeEntity filmeSalvar = filmeEntityMapper.mapear(request);
        return filmeRepository.save(filmeSalvar).getId();
    }

    public ConsultarDetalhesFilmeResponse consultarDetalhesFilme(final Long id) {
        final FilmeEntity filmeSalvo = filmeRepository.findById(id).orElse(null);
        if (filmeSalvo == null) {
            throw new NotFoundException("Filme não encontrado");
        }

        return consultarDetalhesFilmeResponseMapper.mapear(filmeSalvo);
    }
}
