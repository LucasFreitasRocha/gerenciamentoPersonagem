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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gp.dto.PersonagemDTO;
import com.gp.model.Personagem;
import com.gp.services.PersonagemService;


@RestController
@RequestMapping(value = "/api/personagem")
public class PersonagemController {
	@Autowired private PersonagemService service;

	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody PersonagemDTO personagemDTO) {
		Personagem personagem = service.create(personagemDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(personagem.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Personagem> showPersonage(@PathVariable Long id ){
	
		return ResponseEntity.ok(service.find(id));
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> updatePersonage(@PathVariable Long id , @RequestBody PersonagemDTO personagemDTO){
		service.update(id, personagemDTO);
		return ResponseEntity.noContent().build();
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletePersonage(@PathVariable Long id ){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	@GetMapping(value = "/all")
	public ResponseEntity<List<Personagem>> findall(){
		return ResponseEntity.ok(service.findAll());
	}
	@GetMapping
	public ResponseEntity<List<Personagem>> findByUsuario(@RequestParam Long usuarioId){
		return ResponseEntity.ok(service.findByUsuario(usuarioId));
	}
}
