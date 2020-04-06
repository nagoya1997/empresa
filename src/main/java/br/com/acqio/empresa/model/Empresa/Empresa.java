package br.com.acqio.empresa.model.Empresa;

import br.com.acqio.empresa.model.Cidade.Cidade;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private String inscricaoEstadual;
    private String inscricaoEstadualSubstitutoTributario;
    private String inscricaoMunicipal;
    private String regimeTributario;
    private String cnaePrincipal;
    private String nire;
    private LocalDate dataNire;
    private LocalDate dataCadastro;
    private Boolean ativo = false;
    private Boolean matriz = false;
    private String email;
    private String telefone;
    private String celular;
    private String cep;
    private String logradouro;
    private String bairro;
    private String numero;
    private String complemento;
    @ManyToOne
    private Cidade cidade;
    private Long codigoRevenda;
    private Double aliquotaPis;
    private Double aliquotaCofins;

    public Empresa(String razaoSocial, String nomeFantasia) {
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
    }

    public Empresa() {
    }
}
