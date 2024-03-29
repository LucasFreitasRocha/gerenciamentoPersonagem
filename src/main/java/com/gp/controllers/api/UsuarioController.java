package com.gp.controllers.api;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gp.model.Usuario;
import com.gp.services.UsuarioService;

@RestController
@RequestMapping(value = "/api//users")
public class UsuarioController {
	@Autowired private UsuarioService service;

	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	@PostMapping
	public ResponseEntity<?> createUsuario( @Valid @RequestBody Usuario usuario) {
		usuario = service.create(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> showUsuario(@PathVariable Long id ){
		return ResponseEntity.ok(service.find(id));
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> updateUsuario(@PathVariable Long id , @RequestBody Usuario usuario){
		service.update(id, usuario);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}" )
	public ResponseEntity<Void> deleteUsuario(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
