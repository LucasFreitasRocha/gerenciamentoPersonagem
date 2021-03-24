package com.gp.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.exceptions.ObjectNotFoundException;
import com.gp.model.Usuario;
import com.gp.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repo;

	public List<Usuario> index() {
		return repo.findAll();
	}

	public Usuario find(Long id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado com esse id: " + id));
	}

	public Usuario create(Usuario usuario) {
		verificaCpfEmailCadastrado(usuario.getCpf(), usuario.getEmail());
		try {
			return repo.save(usuario);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao salvar o usuario.");
		}
	}

	public void update(Long id, Usuario usuario) {
		find(id);
		usuario.setId(id);
		repo.save(usuario);
	}
	public void delete(Long id, Usuario usuario) {
		find(id);
		usuario.setId(id);
		repo.delete(usuario);
	}
	private void verificaCpfEmailCadastrado(String cpf, String email) {
		List<Usuario> result = repo.findByCpfOrEmail(cpf, email);
		if (!result.isEmpty()) {
			throw new RuntimeException("CPF ou EMAIL já cadastrados.");
		}
	}
}
