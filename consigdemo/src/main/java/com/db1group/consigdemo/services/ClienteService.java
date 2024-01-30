package com.db1group.consigdemo.services;

import com.db1group.consigdemo.dtos.ClienteDto;
import com.db1group.consigdemo.models.Cliente;
import com.db1group.consigdemo.repositories.ClienteRepository;
import com.db1group.consigdemo.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public ClienteDto findById(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado."));
        return new ClienteDto(cliente);
    }

    @Transactional(readOnly = true)
    public Page<ClienteDto> findAll(String name, Pageable pageable) {
        Page<Cliente> result = clienteRepository.searchByName(name, pageable);
        return result.map(x -> new ClienteDto(x));
    }
//
//    @Transactional
//    public ProductDTO insert(ProductDTO dto) {
//        Product entity = new Product();
//        copyDtoToEntity(dto, entity);
//        entity = productRepository.save(entity);
//        return new ProductDTO(entity);
//    }
//
//    @Transactional
//    public ProductDTO update(Long id, ProductDTO dto) {
//        try {
//            Product entity = productRepository.getReferenceById(id);
//            copyDtoToEntity(dto, entity);
//            entity = productRepository.save(entity);
//            return new ProductDTO(entity);
//        }
//        catch (EntityNotFoundException e) {
//            throw new ResourceNotFoundException("Recurso não encontrado.");
//        }
//
//    }
//
//    @Transactional(propagation = Propagation.SUPPORTS)
//    public void delete(Long id) {
//        if (!productRepository.existsById(id)) {
//            throw new ResourceNotFoundException("Recurso não encontrado");
//        }
//        try {
//            productRepository.deleteById(id);
//        }
//        catch (DataIntegrityViolationException e) {
//            throw new DatabaseException("Falha de integridade referencial");
//        }
//    }
//
//    private void copyDtoToEntity(ClienteDto dto, Cliente model) {
//        model.setName(dto.getName());
//        model.setCpf(dto.get());
//        model.setPrice(dto.getPrice());
//        model.setImgUrl(dto.getImgUrl());
//
//
//    }


}
