package br.com.acqio.empresa.util;

public class JunitWiseUtil {

    public static String putEmpresaEntityJson() {
        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        sb.append("{ \"razaoSocial\": \"NovoDado\",")
                .append(" \"nomeFantasia\": \"NovoDado\",")
                .append(" \"cnpj\": \"NovoDado\",")
                .append(" \"inscricaoEstadual\": \"NovoDado\",")
                .append(" \"inscricaoEstadualSubstitutoTributario\": \"NovoDado\",")
                .append(" \"inscricaoMunicipal\": \"NovoDado\",")
                .append(" \"regimeTributario\": \"NovoDado\",")
                .append(" \"cnaePrincipal\": \"NovoDado\",")
                .append(" \"nire\": \"NovoDado\",")
                .append(" \"email\": \"NovoDado\",")
                .append(" \"telefone\": \"NovoDado\",")
                .append(" \"celular\": \"NovoDado\",")
                .append(" \"cep\": \"NovoDado\",")
                .append(" \"logradouro\": \"NovoDado\",")
                .append(" \"bairro\": \"NovoDado\",")
                .append(" \"numero\": \"NovoDado\",")
                .append(" \"complemento\": \"NovoDado\"}");
        return sb.toString();
    }

    public static String postEmpresaEntityJson() {
        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        sb.append("{ \"razaoSocial\": \"NovoDado\",")
                .append(" \"nomeFantasia\": \"NovoDado\",")
                .append(" \"cnpj\": \"NovoDado\",")
                .append(" \"inscricaoEstadual\": \"NovoDado\",")
                .append(" \"inscricaoEstadualSubstitutoTributario\": \"NovoDado\",")
                .append(" \"inscricaoMunicipal\": \"NovoDado\",")
                .append(" \"regimeTributario\": \"NovoDado\",")
                .append(" \"cnaePrincipal\": \"NovoDado\",")
                .append(" \"nire\": \"NovoDado\",")
                .append(" \"email\": \"NovoDado\",")
                .append(" \"telefone\": \"NovoDado\",")
                .append(" \"celular\": \"NovoDado\",")
                .append(" \"cep\": \"NovoDado\",")
                .append(" \"logradouro\": \"NovoDado\",")
                .append(" \"bairro\": \"NovoDado\",")
                .append(" \"numero\": \"NovoDado\",")
                .append(" \"complemento\": \"NovoDado\",")
                .append(" \"codigoRevenda\": \"1\",")
                .append(" \"aliquotaPis\": \"1.0\",")
                .append(" \"aliquotaCofins\": \"1.0\",")
                .append(" \"nomeCidade\": \"São Paulo\"}");
        return sb.toString();
    }

    public static String putEmpresaEntityJsonWithMissingFields() {
        //Alguns campos estão faltando

        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        sb.append("{ \"razaoSocial\": \"NovoDado\",")
                .append(" \"nomeFantasia\": \"NovoDado\",")
                .append(" \"inscricaoEstadual\": \"NovoDado\",")
                .append(" \"inscricaoEstadualSubstitutoTributario\": \"NovoDado\",")
                .append(" \"inscricaoMunicipal\": \"NovoDado\",")
                .append(" \"regimeTributario\": \"NovoDado\",")
                .append(" \"nire\": \"NovoDado\",")
                .append(" \"email\": \"NovoDado\",")
                .append(" \"telefone\": \"NovoDado\",")
                .append(" \"cep\": \"NovoDado\",")
                .append(" \"logradouro\": \"NovoDado\",")
                .append(" \"numero\": \"NovoDado\",")
                .append(" \"complemento\": \"NovoDado\"}");

        return sb.toString();
    }

    public static String postEmpresaEntityJsonWithMissingFields() {
        //Alguns campos estão faltando

        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        sb.append("{ \"razaoSocial\": \"NovoDado\",")
                .append(" \"nomeFantasia\": \"NovoDado\",")
                .append(" \"inscricaoEstadual\": \"NovoDado\",")
                .append(" \"inscricaoEstadualSubstitutoTributario\": \"NovoDado\",")
                .append(" \"inscricaoMunicipal\": \"NovoDado\",")
                .append(" \"regimeTributario\": \"NovoDado\",")
                .append(" \"nire\": \"NovoDado\",")
                .append(" \"email\": \"NovoDado\",")
                .append(" \"telefone\": \"NovoDado\",")
                .append(" \"cep\": \"NovoDado\",")
                .append(" \"logradouro\": \"NovoDado\",")
                .append(" \"numero\": \"NovoDado\",")
                .append(" \"complemento\": \"NovoDado\",")
                .append(" \"codigoRevenda\": \"1\",")
                .append(" \"aliquotaPis\": \"1.0\",")
                .append(" \"aliquotaCofins\": \"1.0\",")
                .append(" \"nomeCidade\": \"São Paulo\"}");
        return sb.toString();
    }

    public static String putEmpresaEntityJsonWithBlankFields() {
        //Alguns campos não têm input

        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        sb.append("{ \"razaoSocial\": \"NovoDado\",")
                .append(" \"nomeFantasia\": \"NovoDado\",")
                .append(" \"cnpj\": \"NovoDado\",")
                .append(" \"inscricaoEstadual\": \"NovoDado\",")
                .append(" \"inscricaoEstadualSubstitutoTributario\": \"\",")
                .append(" \"inscricaoMunicipal\": \"NovoDado\",")
                .append(" \"regimeTributario\": \"NovoDado\",")
                .append(" \"cnaePrincipal\": \" \",")
                .append(" \"nire\": \"NovoDado\",")
                .append(" \"email\": \"NovoDado\",")
                .append(" \"telefone\": \"NovoDado\",")
                .append(" \"celular\": \"NovoDado\",")
                .append(" \"cep\": \"\",")
                .append(" \"logradouro\": \" \",")
                .append(" \"bairro\": \"NovoDado\",")
                .append(" \"numero\": \"NovoDado\",")
                .append(" \"complemento\": \"\",")
                .append(" \"codigoRevenda\": \"1\",")
                .append(" \"aliquotaPis\": \"1.0\",")
                .append(" \"aliquotaCofins\": \"1.0\",")
                .append(" \"nomeCidade\": \"São Paulo\"}");
        return sb.toString();
    }

    public static String postEmpresaEntityJsonWithBlankFields() {
        //Alguns campos não têm input

        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        sb.append("{ \"razaoSocial\": \"NovoDado\",")
                .append(" \"nomeFantasia\": \"NovoDado\",")
                .append(" \"cnpj\": \"NovoDado\",")
                .append(" \"inscricaoEstadual\": \"NovoDado\",")
                .append(" \"inscricaoEstadualSubstitutoTributario\": \"\",")
                .append(" \"inscricaoMunicipal\": \"NovoDado\",")
                .append(" \"regimeTributario\": \"NovoDado\",")
                .append(" \"cnaePrincipal\": \" \",")
                .append(" \"nire\": \"NovoDado\",")
                .append(" \"email\": \"NovoDado\",")
                .append(" \"telefone\": \"NovoDado\",")
                .append(" \"celular\": \"NovoDado\",")
                .append(" \"cep\": \"\",")
                .append(" \"logradouro\": \" \",")
                .append(" \"bairro\": \"NovoDado\",")
                .append(" \"numero\": \"NovoDado\",")
                .append(" \"complemento\": \"\",")
                .append(" \"codigoRevenda\": \"1\",")
                .append(" \"aliquotaPis\": \"1.0\",")
                .append(" \"aliquotaCofins\": \"1.0\",")
                .append(" \"nomeCidade\": \"São Paulo\"}");
        return sb.toString();
    }

}
