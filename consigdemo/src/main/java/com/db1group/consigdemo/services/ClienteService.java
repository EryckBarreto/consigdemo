package com.db1group.consigdemo.services;

import com.db1group.consigdemo.models.Cliente;
import com.db1group.consigdemo.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {

        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public Cliente save(Cliente cliente) {

        return clienteRepository.save(cliente);
    }

    public boolean existsByCpf(String cpf) {

        return clienteRepository.existsByCpf(cpf);
    }

    public List<Cliente> findAll() {

        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Integer id) {
        return clienteRepository.findById(id);
    }

    @Transactional
    public void delete(Cliente cliente) {
        clienteRepository.delete(cliente);
    }

}
