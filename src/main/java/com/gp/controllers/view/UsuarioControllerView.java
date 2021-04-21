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
@RequestMapping(path = "/usuarios")
public  class UsuarioControllerView {
	@Autowired private UsuarioService service;
	 
	@GetMapping 
	public String GetAll(Model model) {
		model.addAttribute("users", service.findAll());
		return "usuarios/usuarios"; 
	}

	@GetMapping(value = "/usuario")
	public String cadastro(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuarios/formUsuario";   
	}
	@PostMapping(value = "/usuario")
	public String save(@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("msgErros", result.getAllErrors());
			return "usuarios/formUsuario";

		}
		try {
			service.create(usuario);
			model.addAttribute("msgSucesso", "Usuario cadastrado com sucesso.");
			model.addAttribute("personagemDTO", new PersonagemDTO());
			return "usuarios/formUsuario";
		} catch (Exception e) {
			model.addAttribute("msgErros", new ObjectError("Personagem", e.getMessage()));
			return "usuarios/formUsuario";
		}

	}
	
	@GetMapping(value = "/show/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Usuario usuario = service.find(id);

		model.addAttribute("usuario", usuario);
		return "usuarios/usuario"; 
	}
	
	@GetMapping(value = "/usuario/{id}")
	public String alterar(@PathVariable("id") Long id, Model model) {
		Usuario usuario = service.find(id);

		model.addAttribute("usuario", usuario);
		return "usuarios/formUsuario";
	}

	@PostMapping(path = "/usuario/{id}")
	public String update(@Valid @ModelAttribute Usuario usuario, BindingResult result,
			@PathVariable("id") Long id, Model model) {
		// valores de retorno padão

		if (result.hasErrors()) {
			model.addAttribute("msgErros", result.getAllErrors());
			return "usuarios/formUsuario";
		}

		try {
			service.update(id, usuario);
			model.addAttribute("msgSucesso", "Personagem atualizado com sucesso.");
			model.addAttribute("usuario", usuario);
			return "usuarios/formUsuario";
		} catch (Exception e) {
			model.addAttribute("msgErros", new ObjectError("usuario", e.getMessage()));
			return "usuarios/formUsuario";
		}
	}

	@GetMapping(path = "/{id}/deletar")
	public String deletar(@PathVariable("id") Long id) {
		service.delete(id);
		return "redirect:/usuarios"; 
	}

}
