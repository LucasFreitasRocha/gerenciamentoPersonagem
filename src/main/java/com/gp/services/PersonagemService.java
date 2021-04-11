package com.gp.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.dto.PersonagemDTO;
import com.gp.enums.AparenciaEnum;
import com.gp.enums.ArmaduraEnum;
import com.gp.exceptions.ObjectNotFoundException;
import com.gp.model.Personagem;
import com.gp.model.Usuario;
import com.gp.repository.PersonagemRepository;

@Service
public class PersonagemService {
	@Autowired
	private PersonagemRepository repo;
	@Autowired
	private UsuarioService usuarioService;

			

	public List<Personagem> findAll() {
		return repo.findAll();
	}

	public Personagem find(Long id) {
		Optional<Personagem> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Personagem não encontrado com esse id: " + id));
	}
	@Transactional
	public Personagem create(PersonagemDTO personagemDTO) {
		Personagem personagem = new Personagem(personagemDTO);
		Usuario usuario = usuarioService.find(personagemDTO.getUsuarioId());
		personagem.setUsuario(usuario);
		updateAtributos(personagem);

			personagem.setClasse(personagem.getClasse());
			return repo.save(personagem);
	
	}

	public void update(Long id, PersonagemDTO personagemDTO) {
		Personagem personagem = find(id);
		personagem.update(personagemDTO);
		updateAtributos(personagem);
		personagem.setId(id);
		repo.save(personagem);
	}

	public void delete(Long id) {
		Personagem personagem = find(id);
		
		repo.delete(personagem);
	}

	private Personagem updateAtributos(Personagem personagem) {
		
		
		
		switch (personagem.getClasse().getTipoClasse()) {
		case GUERREIRO:
			personagem.getClasse().setForca(10);
			personagem.getClasse().setAgilidade(8);
			personagem.getClasse().setInteligencia(6);
			personagem.getCorpo().setArmadura(ArmaduraEnum.PESADA);
			break;
		case MAGO:
			personagem.getClasse().setForca(6);
			personagem.getClasse().setAgilidade(8);
			personagem.getClasse().setInteligencia(10);
			personagem.getCorpo().setArmadura(ArmaduraEnum.LEVE);
			break;
		case LADINO:
			personagem.getClasse().setForca(6);
			personagem.getClasse().setAgilidade(10);
			personagem.getClasse().setInteligencia(8);
			personagem.getCorpo().setArmadura(ArmaduraEnum.LEVE);
			break;

		}
		switch (personagem.getSexo()) {
		case MASCULINO:
			personagem.getCorpo().setAparencia(AparenciaEnum.MASCULINA);
			break;
		case FEMININO:
			personagem.getCorpo().setAparencia(AparenciaEnum.FEMININA);
			break;
		case OUTROS:
			break;
		default:
			break;
		}
	
		return personagem;
	}

	public List<Personagem> findByUsuario(Long usuarioId) {
		Usuario usuario = usuarioService.find(usuarioId);
		return repo.findByUsuario(usuario);
	}

}
