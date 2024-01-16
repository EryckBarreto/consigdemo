package com.db1group.consigdemo.repositories;

import com.db1group.consigdemo.models.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Integer> {

    boolean existsByNumeroContrato(Integer numeroContrato);
}