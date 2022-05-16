package com.saam.springboot.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saam.springboot.app.models.entity.Mascota;
import com.saam.springboot.app.models.entity.Usuario;
import com.saam.springboot.app.models.service.IUsuarioService;

@Controller
@RequestMapping("/mascota")
public class MascotaController {

	@Autowired
	private IUsuarioService usuarioService;
	
    //-----------------Metodo Para Registrar las Mascotas--------//
	@RequestMapping("/form")
	public String crearMascota(Map<String, Object> model) {

		Mascota mascota = new Mascota();
		model.put("mascota", mascota);
		model.put("titulo", "Formulario Registro de Mascota");
		return "mascota/form";
	}
	
	@RequestMapping(value = "/form", method=RequestMethod.POST)
	public String guardarMascota(Mascota mascota) {
		usuarioService.saveMascota(mascota);
		return "redirect:/listar";
	}
	
	@GetMapping("/form/{idUsuario}")
	public String asignarMascota(@PathVariable(value = "idUsuario") Long idUsuario, Map<String, Object> model) {
		Usuario usuario = usuarioService.findOne(idUsuario);
		if (usuario == null) {
			return "redirect:/listar";
		}
		
		Mascota mascota = new Mascota();
		mascota.setUsuario(usuario);
		model.put("mascota", mascota);
		model.put("titulo", "Adoptar Mascota");
		return "mascota/adoptar";
	}
	
	
}
