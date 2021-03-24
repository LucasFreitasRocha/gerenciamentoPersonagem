package com.gp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.enums.AparenciaEnum;
import com.gp.enums.ArmaduraEnum;
import com.gp.exceptions.ObjectNotFoundException;
import com.gp.model.Personagem;
import com.gp.repository.PersonagemRepository;

@Service
public class PersonagemService {
	@Autowired
	private PersonagemRepository repo;

	public List<Personagem> index() {
		return repo.findAll();
	}

	public Personagem find(Long id) {
		Optional<Personagem> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Personagem não encontrado com esse id: " + id));
	}

	public Personagem create(Personagem personagem) {
		updateAtributos(personagem);
		try {
			return repo.save(personagem);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao salvar o personagem.");
		}
	}

	public void update(Long id, Personagem personagem) {
		find(id);
		updateAtributos(personagem);
		personagem.setId(id);
		repo.save(personagem);
	}

	public void delete(Long id, Personagem personagem) {
		find(id);
		personagem.setId(id);
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
			personagem.getClasse().setInteligencia(6);
			personagem.getCorpo().setArmadura(ArmaduraEnum.LEVE);
			break;

		}
		switch (personagem.getSexo()) {
		case MASCULINO:
			personagem.getCorpo().setAparencia(AparenciaEnum.MASCULINA);
			break;
		case FEMINIO:
			personagem.getCorpo().setAparencia(AparenciaEnum.FEMINIA);
			break;
		case OUTROS:
			break;
		default:
			break;
		}
	
		return personagem;
	}

}
