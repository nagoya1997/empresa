package br.com.acqio.empresa.repository;

import br.com.acqio.empresa.model.Cidade.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    Optional<Cidade> findByNome(String nomeCidade);
}
