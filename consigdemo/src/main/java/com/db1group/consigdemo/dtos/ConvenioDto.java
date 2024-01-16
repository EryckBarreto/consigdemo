package com.db1group.consigdemo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public class ConvenioDto {

    @NotBlank
    private Integer id;
    @NotBlank
    @Size(max = 14)
    private String cnpj;
    @NotBlank
    private String nomeConvenio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeConvenio() {
        return nomeConvenio;
    }

    public void setNomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }
}
