package com.saam.springboot.app.models.dao;

import java.util.List;
import java.util.Optional;

import com.saam.springboot.app.models.entity.Usuario;

public interface IUsuarioDao {

	public List<Usuario>findAll();
	
	public void save(Usuario usuario);
	
	public Usuario findOne(Long id);
	
	public void delete(Long id);
}
