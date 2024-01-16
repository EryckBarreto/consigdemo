package com.db1group.consigdemo.repositories;

import com.db1group.consigdemo.models.Convenio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ConvenioRepository extends JpaRepository<Convenio, Integer> {

    boolean existsByNomeConvenio(String nomeConvenio);

    Optional<Convenio> findByNomeConvenio(String nomeConvenio);
}