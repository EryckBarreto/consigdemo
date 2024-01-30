package com.db1group.consigdemo.controllers;

import com.db1group.consigdemo.dtos.UsuarioDto;
import com.db1group.consigdemo.models.Usuario;
import com.db1group.consigdemo.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/usuarios")
public class UsuarioController {

    final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Object> saveUsuario(@RequestBody @Valid UsuarioDto usuarioDto){

        if(usuarioService.existsByCpf(usuarioDto.getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF já está cadastrado no sistema.");
        }

        var usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDto, usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getTodosUsuarios(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getApenasUmUsuario(@PathVariable(value = "id") Integer id){
        Optional<Usuario> usuarioOptional = usuarioService.findById(id);
        if (!usuarioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado, tente novamente.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuarioOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUsuario(@PathVariable(value = "id") Integer id){
        Optional<Usuario> usuarioOptional = usuarioService.findById(id);
        if (!usuarioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }
        usuarioService.delete(usuarioOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso.");
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Object> updateUsuario(@PathVariable(value = "id") Integer id,
//                                                @RequestBody @Valid UsuarioDto usuarioDto){
//        Optional<Usuario> usuarioOptional = usuarioService.findById(id);
//        if (!usuarioOptional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
//        }
//        var usuario = new Usuario();
//        BeanUtils.copyProperties(usuarioDto, usuario);
//        usuario.setId(usuarioOptional.get().getId());
//        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(usuario));
//    }

}
