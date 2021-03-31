package com.gp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gp.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	 @Query("SELECT u FROM #{#entityName} u WHERE u.cpf = :cpf OR u.email = :email")
	List<Usuario> findByCpfOrEmail(String cpf, String email);

}
