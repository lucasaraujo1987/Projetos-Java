package com.br.DTO;

public class EndereçoMembroDTO {
    
    private int id_endereco;
    private String cep_endereco, logradouro_endereco, numero_endereco, complemento_endereco, bairro_endereco, cidade_endereco, uf_endereco, pais_endereco;

    public int getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public String getCep_endereco() {
        return cep_endereco;
    }

    public void setCep_endereco(String cep_endereco) {
        this.cep_endereco = cep_endereco;
    }

    public String getLogradouro_endereco() {
        return logradouro_endereco;
    }

    public void setLogradouro_endereco(String logradouro_endereco) {
        this.logradouro_endereco = logradouro_endereco;
    }

    public String getNumero_endereco() {
        return numero_endereco;
    }

    public void setNumero_endereco(String numero_endereco) {
        this.numero_endereco = numero_endereco;
    }

    public String getComplemento_endereco() {
        return complemento_endereco;
    }

    public void setComplemento_endereco(String complemento_endereco) {
        this.complemento_endereco = complemento_endereco;
    }

    public String getBairro_endereco() {
        return bairro_endereco;
    }

    public void setBairro_endereco(String bairro_endereco) {
        this.bairro_endereco = bairro_endereco;
    }

    public String getCidade_endereco() {
        return cidade_endereco;
    }

    public void setCidade_endereco(String cidade_endereco) {
        this.cidade_endereco = cidade_endereco;
    }

    public String getUf_endereco() {
        return uf_endereco;
    }

    public void setUf_endereco(String uf_endereco) {
        this.uf_endereco = uf_endereco;
    }

    public String getPais_endereco() {
        return pais_endereco;
    }

    public void setPais_endereco(String pais_endereco) {
        this.pais_endereco = pais_endereco;
    }
    
}
