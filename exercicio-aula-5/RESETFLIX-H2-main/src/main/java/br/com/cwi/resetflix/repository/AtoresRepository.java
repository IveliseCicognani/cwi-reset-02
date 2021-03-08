package br.com.cwi.resetflix.repository;


import br.com.cwi.resetflix.entity.AtorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtoresRepository extends JpaRepository<AtorEntity, Long> {

}
