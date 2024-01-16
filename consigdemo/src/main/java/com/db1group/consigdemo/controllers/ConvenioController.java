package com.db1group.consigdemo.controllers;

import com.db1group.consigdemo.dtos.ConvenioDto;
import com.db1group.consigdemo.models.Convenio;
import com.db1group.consigdemo.services.ConvenioService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/convenios")
public class ConvenioController {

    final ConvenioService convenioService;

    public ConvenioController(ConvenioService convenioService) {

        this.convenioService = convenioService;
    }

    @PostMapping
    public ResponseEntity<Object> saveConvenio(@RequestBody @Valid ConvenioDto convenioDto){

        if(convenioService.existsByNomeConvenio(convenioDto.getNomeConvenio())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Convênio já cadastrado no sistema.");
        }

        var convenio = new Convenio();
        BeanUtils.copyProperties(convenioDto, convenio);
        return ResponseEntity.status(HttpStatus.CREATED).body(convenioService.save(convenio));
    }

    @GetMapping
    public ResponseEntity<List<Convenio>> getTodosConvenios(){
        return ResponseEntity.status(HttpStatus.OK).body(convenioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getApenasUmConvenio(@PathVariable(value = "id") String nomeConvenio){
        Optional<Convenio> convenioOptional = convenioService.findByNomeConvenio(nomeConvenio);
        if (!convenioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Convênio não encontrado, manobrown.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(convenioOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteConvenio(@PathVariable(value = "id") String nomeConvenio){
        Optional<Convenio> convenioOptional = convenioService.findByNomeConvenio(nomeConvenio);
        if (!convenioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Convênio não encontrado.");
        }
        convenioService.delete(convenioOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Convênio deletado com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateConvenio(@PathVariable(value = "id") String nomeConvenio,
                                                @RequestBody @Valid ConvenioDto convenioDto){
        Optional<Convenio> convenioOptional = convenioService.findByNomeConvenio(nomeConvenio);
        if (!convenioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Convênio não encontrado.");
        }
        var convenio = new Convenio();
        BeanUtils.copyProperties(convenioDto, convenio);
        convenio.setId(convenioOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(convenioService.save(convenio));
    }

}

