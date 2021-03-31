package com.gp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gp.model.Personagem;
import com.gp.model.Usuario;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long>{

	@Query("SELECT p FROM #{#entityName} p where p.usuario = :usuario")
	List<Personagem> findByUsuario(Usuario usuario);

}
