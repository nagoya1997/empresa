package br.com.acqio.empresa.model.Empresa.dto;

import br.com.acqio.empresa.model.Empresa.Empresa;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmpresaDetailsDTO {

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
    private String email;
    private String telefone;
    private String celular;
    private String cep;
    private String logradouro;
    private String bairro;
    private String numero;
    private String complemento;
    private Long codigoRevenda;
    private Double aliquotaPis;
    private Double aliquotaCofins;

    //Info Cidade
    private String nomeCidade;

    //Info Estado
    private String nomeEstado;
    private String abreviacao;

    public EmpresaDetailsDTO(Empresa empresa) {
        this.id = empresa.getId();
        this.razaoSocial = empresa.getRazaoSocial();
        this.nomeFantasia = empresa.getNomeFantasia();
        this.cnpj = empresa.getCnpj();
        this.inscricaoEstadual = empresa.getInscricaoEstadual();
        this.inscricaoEstadualSubstitutoTributario = empresa.getInscricaoEstadualSubstitutoTributario();
        this.inscricaoMunicipal = empresa.getInscricaoMunicipal();
        this.regimeTributario = empresa.getRegimeTributario();
        this.cnaePrincipal = empresa.getCnaePrincipal();
        this.nire = empresa.getNire();
        this.dataNire = empresa.getDataNire();
        this.dataCadastro = empresa.getDataCadastro();
        this.email = empresa.getEmail();
        this.telefone = empresa.getTelefone();
        this.celular = empresa.getCelular();
        this.cep = empresa.getCep();
        this.logradouro = empresa.getLogradouro();
        this.bairro = empresa.getBairro();
        this.numero = empresa.getNumero();
        this.complemento = empresa.getComplemento();
        this.nomeCidade = empresa.getCidade().getNome();
        this.nomeEstado = empresa.getCidade().getEstado().getNome();
        this.abreviacao = empresa.getCidade().getEstado().getAbreviacao();
        this.codigoRevenda = empresa.getCodigoRevenda();
        this.aliquotaPis = empresa.getAliquotaPis();
        this.aliquotaCofins = empresa.getAliquotaCofins();
    }
}
