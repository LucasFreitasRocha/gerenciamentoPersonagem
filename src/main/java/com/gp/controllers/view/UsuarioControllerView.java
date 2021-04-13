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
import com.gp.model.Usuario;
import com.gp.services.UsuarioService;

@Controller
@RequestMapping(path = "/users")
public abstract class UsuarioControllerView {
	@Autowired private UsuarioService service;
	
	@GetMapping
	public String GetAll(Model model) {
		model.addAttribute("users", service.findAll());
		return "users/users";
	}

	@GetMapping(value = "/novo")
	public String cadastro(Model model) {
		model.addAttribute("user", new Usuario());
		return "personagens/formPersonagem";
	}
	@PostMapping(value = "/novo")
	public String save(@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("msgErros", result.getAllErrors());
			return "users/formUser";

		}
		try {
			service.create(usuario);
			model.addAttribute("msgSucesso", "Usuario cadastrado com sucesso.");
			model.addAttribute("personagemDTO", new PersonagemDTO());
			return "users/formUser";
		} catch (Exception e) {
			model.addAttribute("msgErros", new ObjectError("Personagem", e.getMessage()));
			return "users/formUser";
		}

	}
	
	@GetMapping(value = "/show/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Usuario usuario = service.find(id);

		model.addAttribute("usuario", usuario);
		return "users/usuario";
	}
	
	@GetMapping(value = "/update/{id}")
	public String alterar(@PathVariable("id") Long id, Model model) {
		Usuario usuario = service.find(id);

		model.addAttribute("usuario", usuario);
		return "users/formUser";
	}

	@PostMapping(path = "/update/{id}")
	public String update(@Valid @ModelAttribute Usuario usuario, BindingResult result,
			@PathVariable("id") Long id, Model model) {
		// valores de retorno padão

		if (result.hasErrors()) {
			model.addAttribute("msgErros", result.getAllErrors());
			return "users/formUser";
		}

		try {
			service.update(id, usuario);
			model.addAttribute("msgSucesso", "Personagem atualizado com sucesso.");
			model.addAttribute("usuario", usuario);
			return "users/formUser";
		} catch (Exception e) {
			model.addAttribute("msgErros", new ObjectError("usuario", e.getMessage()));
			return "users/formUser";
		}
	}

	@GetMapping(path = "/{id}/deletar")
	public String deletar(@PathVariable("id") Long id) {
		service.delete(id);
		return "redirect:/personagens";
	}

}
