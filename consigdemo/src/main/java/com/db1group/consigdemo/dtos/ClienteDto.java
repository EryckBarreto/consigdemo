package com.db1group.consigdemo.dtos;

import com.db1group.consigdemo.models.Cliente;

public class ClienteDto {

    private Long id;
    private String name;
    private String cpf;
    private String email;


    public ClienteDto(Long id, String name, String cpf, String email) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    public ClienteDto(Cliente model) {
        id = model.getId();
        name = model.getName();
        cpf = model.getCpf();
        email = model.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }
}
