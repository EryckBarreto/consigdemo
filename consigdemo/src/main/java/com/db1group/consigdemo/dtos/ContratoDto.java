package com.db1group.consigdemo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public class ContratoDto {

    @NotBlank
    private Integer numeroContrato;
    @NotBlank
    @Size(max = 11)
    private String cpf;
    @NotBlank
    private Integer totalParcelas;

    public Integer getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(Integer numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getTotalParcelas() {
        return totalParcelas;
    }

    public void setTotalParcelas(Integer totalParcelas) {
        this.totalParcelas = totalParcelas;
    }
}