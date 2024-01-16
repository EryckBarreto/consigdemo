package com.db1group.consigdemo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
public class Contrato {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer numeroContrato;
    @Getter
    @Setter
    @Column(nullable = false)
    private String cpf;
    @Getter
    @Setter
    @Column(nullable = false)
    private Integer totalParcelas;
}
