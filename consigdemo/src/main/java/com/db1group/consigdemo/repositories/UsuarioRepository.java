package com.db1group.consigdemo.repositories;

import com.db1group.consigdemo.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    boolean existsByCpf(String cpf);

}
