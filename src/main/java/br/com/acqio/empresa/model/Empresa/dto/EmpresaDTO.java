package br.com.acqio.empresa.model.Empresa.dto;

import br.com.acqio.empresa.model.Empresa.Empresa;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
public class EmpresaDTO {

    //Info Empresa
    private Long id;
    private String razaoSocial;
    private String nomeFantasia;

    //Info Cidade
    private String nomeCidade;

    //Info Estado
    private String nomeEstado;
    private String abreviacao;

    public EmpresaDTO(Empresa empresa) {
        this.id = empresa.getId();
        this.razaoSocial = empresa.getRazaoSocial();
        this.nomeFantasia = empresa.getNomeFantasia();
        this.nomeCidade = empresa.getCidade().getNome();
        this.nomeEstado = empresa.getCidade().getEstado().getNome();
        this.abreviacao = empresa.getCidade().getEstado().getAbreviacao();
    }

    public static Page<EmpresaDTO> converter(Page<Empresa> list) {
        return list.map(EmpresaDTO::new);
    }
}
