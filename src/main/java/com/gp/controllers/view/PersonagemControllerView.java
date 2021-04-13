package com.gp.controllers.view;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gp.dto.PersonagemDTO;
import com.gp.model.Personagem;
import com.gp.services.PersonagemService;

@Controller
@RequestMapping(path = "/personagens")
public class PersonagemControllerView {
	@Autowired
	private PersonagemService service;

	@GetMapping
	public String GetAll(Model model) {
		model.addAttribute("personagens", service.findAll());
		return "personagens/personagens";
	}

	@GetMapping(value = "/novo")
	public String cadastro(Model model) {
		model.addAttribute("personagemDTO", new PersonagemDTO());
		return "personagens/formPersonagem";
	}

	@PostMapping(value = "/novo")
	public String save(@Valid @ModelAttribute PersonagemDTO personagemDTO, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("msgErros", result.getAllErrors());
			return "personagens/formPersonagem";

		}
		try {
			service.create(personagemDTO);
			model.addAttribute("msgSucesso", "Personagem cadastrado com sucesso.");
			model.addAttribute("personagemDTO", new PersonagemDTO());
			return "personagens/formPersonagem";
		} catch (Exception e) {
			model.addAttribute("msgErros", new ObjectError("Personagem", e.getMessage()));
			return "formPersonagem";
		}

	}
	
	@GetMapping(value = "/show/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Personagem personagem = service.find(id);

		model.addAttribute("personagem", personagem);
		return "personagens/personagem";
	}

	@GetMapping(value = "/update/{id}")
	public String alterar(@PathVariable("id") Long id, Model model) {
		Personagem personagem = service.find(id);

		model.addAttribute("personagemDTO", new PersonagemDTO(personagem));
		return "personagens/formPersonagem";
	}

	@PostMapping(path = "/update/{id}")
	public String update(@Valid @ModelAttribute PersonagemDTO personagemDTO, BindingResult result,
			@PathVariable("id") Long id, Model model) {
		// valores de retorno padão

		if (result.hasErrors()) {
			model.addAttribute("msgErros", result.getAllErrors());
			return "personagens/formPersonagem";
		}

		try {
			service.update(id, personagemDTO);
			model.addAttribute("msgSucesso", "Personagem atualizado com sucesso.");
			model.addAttribute("personagem", personagemDTO);
			return "personagens/formPersonagem";
		} catch (Exception e) {
			model.addAttribute("msgErros", new ObjectError("Personagem", e.getMessage()));
			return "personagens/formPersonagem";
		}
	}

	@GetMapping(path = "/{id}/deletar")
	public String deletar(@PathVariable("id") Long id) {
		service.delete(id);
		return "redirect:/personagens";
	}

}
