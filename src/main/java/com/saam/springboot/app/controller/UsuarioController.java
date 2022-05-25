package com.saam.springboot.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saam.springboot.app.models.entity.Usuario;
import com.saam.springboot.app.models.service.IUsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping(value="/info/{id}")
	public String ver(@PathVariable(value="id") Long id, Map<String, Object> model) {
		Usuario usuario = usuarioService.findOne(id);
		if(usuario ==null) {
			return "redirect:/listar";
		}
		model.put("usuario", usuario);
		model.put("titulo", "Detalles del Usuario: " + usuario.getNombre());
		return "info";
	}
	
	@RequestMapping(value = { "listar"}, method = RequestMethod.GET)
	public String Listar(Model model) {
		model.addAttribute("titulo", "Listado de Usuarios Registrados");
		model.addAttribute("usuarios", usuarioService.findAll());
		return "listar";
	}
	
	
}
