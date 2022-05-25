package com.saam.springboot.app.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.saam.springboot.app.models.entity.Mascota;
import com.saam.springboot.app.models.entity.Usuario;

@Service
public interface IUsuarioService {

	//Listar todos los usuario con el finAll()
	public List<Usuario>findAll();
	
	//Guarda los usuario con save()
	public void save(Usuario usuario);
	
	//Busca el usuario por el id
	public Usuario findOne(Long id);
	
	//Eliminar usuario por el id
	public void delete(Long id);
	
	public void saveMascota(Mascota mascota);
	
	public void deleteMascota(Long id);
	
	public Mascota finMascotaById(Long id);
	
	public List<Mascota>findAllMascota();
}
