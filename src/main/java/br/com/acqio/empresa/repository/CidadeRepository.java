package br.com.acqio.empresa.repository;

import br.com.acqio.empresa.model.Cidade.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    Cidade findByNome(String nomeCidade);
}
