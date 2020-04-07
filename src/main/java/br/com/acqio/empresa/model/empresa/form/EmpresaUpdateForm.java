package br.com.acqio.empresa.model.empresa.form;

import br.com.acqio.empresa.model.empresa.Empresa;
import br.com.acqio.empresa.repository.EmpresaRepository;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class EmpresaUpdateForm {

    @NotNull
    @NotEmpty
    private String razaoSocial;
    @NotNull
    @NotEmpty
    private String nomeFantasia;
    @NotNull
    @NotEmpty
    private String cnpj;
    @NotNull
    @NotEmpty
    private String inscricaoEstadual;
    @NotNull
    @NotEmpty
    private String inscricaoEstadualSubstitutoTributario;
    @NotNull
    @NotEmpty
    private String inscricaoMunicipal;
    @NotNull
    @NotEmpty
    private String regimeTributario;
    @NotNull
    @NotEmpty
    private String cnaePrincipal;
    @NotNull
    @NotEmpty
    private String nire;
    @NotNull
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    private String telefone;
    @NotNull
    @NotEmpty
    private String celular;
    @NotNull
    @NotEmpty
    private String cep;
    @NotNull
    @NotEmpty
    private String logradouro;
    @NotNull
    @NotEmpty
    private String bairro;
    @NotNull
    @NotEmpty
    private String numero;
    @NotNull
    @NotEmpty
    private String complemento;

    public Empresa atualizar(Long id, EmpresaRepository empresaRepository) {
        Empresa empresa = empresaRepository.getOne(id);
        empresa.setRazaoSocial(this.razaoSocial);
        empresa.setNomeFantasia(this.nomeFantasia);
        empresa.setCnpj(this.cnpj);
        empresa.setInscricaoEstadual(this.inscricaoEstadual);
        empresa.setInscricaoEstadualSubstitutoTributario(this.inscricaoEstadualSubstitutoTributario);
        empresa.setInscricaoMunicipal(this.inscricaoMunicipal);
        empresa.setRegimeTributario(this.regimeTributario);
        empresa.setCnaePrincipal(this.cnaePrincipal);
        empresa.setNire(this.nire);
        empresa.setEmail(this.email);
        empresa.setTelefone(this.telefone);
        empresa.setCelular(this.celular);
        empresa.setCep(this.cep);
        empresa.setLogradouro(this.logradouro);
        empresa.setBairro(this.bairro);
        empresa.setNumero(this.numero);
        empresa.setComplemento(this.complemento);
        return empresa;
    }

}
