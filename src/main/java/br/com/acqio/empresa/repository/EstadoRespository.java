package br.com.acqio.empresa.repository;

import br.com.acqio.empresa.model.estado.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRespository extends JpaRepository<Estado, Long> {

    Estado findByNome(String nomeEstado);

}
