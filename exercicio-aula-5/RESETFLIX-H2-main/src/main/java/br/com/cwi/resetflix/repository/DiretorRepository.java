package br.com.cwi.resetflix.repository;

import br.com.cwi.resetflix.entity.DiretorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiretorRepository extends JpaRepository<DiretorEntity, Long> {
}
