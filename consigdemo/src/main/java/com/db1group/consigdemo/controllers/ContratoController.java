package com.db1group.consigdemo.controllers;

import com.db1group.consigdemo.dtos.ContratoDto;
import com.db1group.consigdemo.models.Contrato;
import com.db1group.consigdemo.services.ContratoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/contratos")
public class ContratoController {

    final ContratoService contratoService;

    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    @PostMapping
    public ResponseEntity<Object> saveContrato(@RequestBody @Valid ContratoDto contratoDto){

        if(contratoService.existsByNumeroContrato(contratoDto.getNumeroContrato())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Contrato já cadastrado no sistema.");
        }

        var contrato = new Contrato();
        BeanUtils.copyProperties(contratoDto, contrato);
        return ResponseEntity.status(HttpStatus.CREATED).body(contratoService.save(contrato));
    }

    @GetMapping
    public ResponseEntity<List<Contrato>> getTodosContratos(){
        return ResponseEntity.status(HttpStatus.OK).body(contratoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getApenasUmContrato(@PathVariable(value = "id") Integer numeroContrato){
        Optional<Contrato> contratoOptional = contratoService.findById(numeroContrato);
        if (!contratoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contrato não encontrado, manobrown.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(contratoOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCliente(@PathVariable(value = "id") Integer numeroContrato){
        Optional<Contrato> contratoOptional = contratoService.findById(numeroContrato);
        if (!contratoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contrato não encontrado.");
        }
        contratoService.delete(contratoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Contrato deletado com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCliente(@PathVariable(value = "id") Integer numeroContrato,
                                                @RequestBody @Valid ContratoDto contratoDto){
        Optional<Contrato> contratoOptional = contratoService.findById(numeroContrato);
        if (!contratoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contrato não encontrado.");
        }
        var contrato = new Contrato();
        BeanUtils.copyProperties(contratoDto, contrato);
        contrato.setNumeroContrato(contratoOptional.get().getNumeroContrato());
        return ResponseEntity.status(HttpStatus.OK).body(contratoService.save(contrato));
    }

}
