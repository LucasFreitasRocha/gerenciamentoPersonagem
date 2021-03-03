package com.gp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gp.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
