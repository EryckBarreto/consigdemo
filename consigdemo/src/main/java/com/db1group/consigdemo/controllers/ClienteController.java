package com.db1group.consigdemo.controllers;

import com.db1group.consigdemo.dtos.ClienteDto;
import com.db1group.consigdemo.models.Cliente;
import com.db1group.consigdemo.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    public ClienteService clienteService;


    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> findById(@PathVariable Long id) {
        ClienteDto dto = clienteService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ClienteDto>> findAll(
            @RequestParam(name = "name", defaultValue = "")
            String name, Pageable pageable) {
        Page<ClienteDto> dto = clienteService.findAll(name, pageable);
        return ResponseEntity.ok(dto);
    }


//    @PostMapping
//    public ResponseEntity<Object> saveCliente(@RequestBody @Valid ClienteDto clienteDto){
//
//        if(clienteService.existsByCpf(clienteDto.getCpf())){
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF já está cadastrado no sistema.");
//        }
//
//        var cliente = new Cliente();
//        BeanUtils.copyProperties(clienteDto, cliente);
//        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Cliente>> getTodosClientes(){
//        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
//    }
//
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> deleteCliente(@PathVariable(value = "id") Integer id){
//        Optional<Cliente> clienteOptional = clienteService.findById(id);
//        if (!clienteOptional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
//        }
//        clienteService.delete(clienteOptional.get());
//        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso.");
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Object> updateCliente(@PathVariable(value = "id") Integer id,
//                                                    @RequestBody @Valid ClienteDto clienteDto){
//        Optional<Cliente> clienteOptional = clienteService.findById(id);
//        if (!clienteOptional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
//        }
//        var cliente = new Cliente();
//        BeanUtils.copyProperties(clienteDto, cliente);
//        cliente.setId(clienteOptional.get().getId());
//        return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(cliente));
//    }

}
