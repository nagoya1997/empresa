package br.com.acqio.empresa.model.empresa.dto;

public class EmpresaErrorDTO {

    private String campo;
    private String erro;

    public EmpresaErrorDTO(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
