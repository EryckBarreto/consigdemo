package com.db1group.consigdemo.services;

import com.db1group.consigdemo.models.Convenio;
import com.db1group.consigdemo.repositories.ConvenioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConvenioService {

    final ConvenioRepository convenioRepository;

    public ConvenioService(ConvenioRepository convenioRepository) {

        this.convenioRepository = convenioRepository;
    }

    @Transactional
    public Convenio save(Convenio convenio) {

        return convenioRepository.save(convenio);
    }

    public boolean existsByNomeConvenio(String nomeConvenio) {

        return convenioRepository.existsByNomeConvenio(nomeConvenio);
    }

    public List<Convenio> findAll() {

        return convenioRepository.findAll();
    }

    public Optional<Convenio> findByNomeConvenio(String nomeConvenio) {
        return convenioRepository.findByNomeConvenio(nomeConvenio);
    }

    @Transactional
    public void delete(Convenio convenio) {
        convenioRepository.delete(convenio);
    }

}
