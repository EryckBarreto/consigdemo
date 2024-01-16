package com.db1group.consigdemo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Cliente {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Getter
    @Setter
    @Column(nullable = false)
    private String nome;
    @Getter
    @Setter
    @Column(nullable = false)
    private String cpf;
    @Getter
    @Setter
    @Column()
    private String email;


//    public void setId(Integer id) {
//    }
}
