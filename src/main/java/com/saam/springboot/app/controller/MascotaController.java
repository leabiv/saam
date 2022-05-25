package com.saam.springboot.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.saam.springboot.app.models.entity.Mascota;
import com.saam.springboot.app.models.entity.Usuario;
import com.saam.springboot.app.models.service.IUsuarioService;

@Controller
@RequestMapping("/mascota")
public class MascotaController {

	@Autowired
	private IUsuarioService usuarioService;
	
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
		return "redirect:/mascota/listarMascotas";
	}
	
	@RequestMapping(value="/listarMascotas",  method = RequestMethod.GET)
	public String listarMascota(Model model) {
		model.addAttribute("titulo", "Listado de Mascota Registradas");
		model.addAttribute("mascotas", usuarioService.findAllMascota());
		return "mascota/listarMascotas";
	}
	
	//-----------------Metodos de Asignar la Mascota al Usuario---//
	@GetMapping("/adoptar/{usuarioId}")
	public String asignarMascota(@PathVariable(value = "usuarioId") Long usuarioId, Map<String, Object> model) {
		Usuario usuario = usuarioService.findOne(usuarioId);
		if (usuario == null) {
			return "redirect:/listar";
		}
		
		Mascota mascota = new Mascota();
		mascota.setUsuario(usuario);
		model.put("mascota", mascota);
		model.put("titulo", "Adoptar Mascota");
		return "mascota/adoptar";
	}
	
	@PostMapping("/adoptar")
	public String guardarMascota(Mascota mascota, SessionStatus status) {

		usuarioService.saveMascota(mascota);
		status.setComplete();
		return "redirect:/info/" + mascota.getUsuario().getIdUsuario();
		
	}
	
}
