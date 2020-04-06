package br.com.acqio.empresa.repository;


import br.com.acqio.empresa.model.Empresa.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    Page<Empresa> findByRazaoSocial(String nomeFantasia, Pageable paginacao);

    Page<Empresa> findByNomeFantasia(String nomeFantasia, Pageable paginacao);

    @Query(value = "SELECT e FROM Empresa e WHERE e.razaoSocial = :razaoSocial and e.nomeFantasia = :nomeFantasia")
    Page<Empresa> findByRazaoSocialAndNomeFantasia(String razaoSocial, String nomeFantasia, Pageable paginacao);
}
