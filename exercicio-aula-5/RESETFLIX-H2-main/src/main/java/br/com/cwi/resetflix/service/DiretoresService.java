package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.exception.BadRequestException;
import br.com.cwi.resetflix.exception.NotFoundException;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesDiretorResponseMapper;
import br.com.cwi.resetflix.mapper.DiretorEntityMapper;
import br.com.cwi.resetflix.mapper.DiretoresResponseMapper;
import br.com.cwi.resetflix.repository.DiretorRepository;
import br.com.cwi.resetflix.request.CriarDiretorRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesDiretorResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.apache.logging.log4j.util.Strings.isEmpty;

@Service
public class DiretoresService {

    @Autowired
    private DiretorRepository diretoresRepository;

    @Autowired
    private DiretoresResponseMapper diretoresResponseMapper;

    @Autowired
    private DiretorEntityMapper diretorEntityMapper;

    @Autowired
    private ConsultarDetalhesDiretorResponseMapper consultarDetalhesDiretorResponseMapper;

    public List<DiretoresResponse> getDiretores() {
        final List<DiretorEntity> diretores = diretoresRepository.findAll();
        return diretoresResponseMapper.mapear(diretores);
    }

    public Long criarDiretor(final CriarDiretorRequest request) {

        if (request == null || isEmpty(request.getNome())) {
            throw new BadRequestException("Dados inválidos para cadastro de diretor");
        }

        final DiretorEntity diretorSalvar = diretorEntityMapper.mapear(request);

        return diretoresRepository.save(diretorSalvar).getId();
    }

    public ConsultarDetalhesDiretorResponse consultarDetalhesDiretor(final Long id) {

        Optional<DiretorEntity> diretoOptional = diretoresRepository.findById(id);

        DiretorEntity diretorEntity = diretoOptional
                .orElseThrow(() -> new NotFoundException("Diretor não encontrado"));

        return consultarDetalhesDiretorResponseMapper.mapear(diretorEntity);
    }
}
