package com.db1group.consigdemo.services;

import com.db1group.consigdemo.models.Contrato;
import com.db1group.consigdemo.repositories.ContratoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratoService {

    final ContratoRepository contratoRepository;

    public ContratoService(ContratoRepository contratoRepository) {

        this.contratoRepository = contratoRepository;
    }

    @Transactional
    public Contrato save(Contrato contrato) {

        return contratoRepository.save(contrato);
    }

    public boolean existsByNumeroContrato(Integer numeroContrato) {

        return contratoRepository.existsByNumeroContrato(numeroContrato);
    }

    public List<Contrato> findAll() {

        return contratoRepository.findAll();
    }

    public Optional<Contrato> findById(Integer numeroContrato) {

        return contratoRepository.findById(numeroContrato);
    }

    @Transactional
    public void delete(Contrato contrato) {

        contratoRepository.delete(contrato);
    }


}
