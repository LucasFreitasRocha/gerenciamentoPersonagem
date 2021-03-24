package com.gp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gp.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	 @Query("SELECT p FROM Pessoa p WHERE p.cpf = :cpf OR p.email = :email")
	List<Usuario> findByCpfOrEmail(String cpf, String email);

}
