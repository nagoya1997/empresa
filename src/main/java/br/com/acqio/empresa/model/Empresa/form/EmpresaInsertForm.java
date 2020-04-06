package br.com.acqio.empresa.model.Empresa.form;

import br.com.acqio.empresa.model.Cidade.Cidade;
import br.com.acqio.empresa.model.Empresa.Empresa;
import br.com.acqio.empresa.repository.CidadeRepository;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class EmpresaInsertForm {

    //Info Empresa
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

    //Info Cidade
    @NotNull
    @NotEmpty
    private String nomeCidade;

    public Empresa converter(CidadeRepository cidadeRepository) {
        Cidade cidade = cidadeRepository.findByNome(nomeCidade);
        Empresa empresa = new Empresa();
        empresa.setRazaoSocial(razaoSocial);
        empresa.setNomeFantasia(nomeFantasia);
        empresa.setCnpj(cnpj);
        empresa.setInscricaoEstadual(inscricaoEstadual);
        empresa.setInscricaoEstadualSubstitutoTributario(inscricaoEstadualSubstitutoTributario);
        empresa.setInscricaoMunicipal(inscricaoMunicipal);
        empresa.setRegimeTributario(regimeTributario);
        empresa.setCnaePrincipal(cnaePrincipal);
        empresa.setNire(nire);
        empresa.setDataNire(LocalDate.now());
        empresa.setDataCadastro(LocalDate.now());
        empresa.setEmail(email);
        empresa.setTelefone(telefone);
        empresa.setCelular(celular);
        empresa.setCep(cep);
        empresa.setLogradouro(logradouro);
        empresa.setBairro(bairro);
        empresa.setNumero(numero);
        empresa.setComplemento(complemento);
        empresa.setCidade(cidade);
        return empresa;
    }
}
