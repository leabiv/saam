package com.saam.springboot.app.models.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saam.springboot.app.models.dao.IMascotaDao;
import com.saam.springboot.app.models.dao.IUsuarioDao;
import com.saam.springboot.app.models.entity.Mascota;
import com.saam.springboot.app.models.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Autowired
	private IMascotaDao mascotaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return usuarioDao.findAll();
	}

	@Override
	@Transactional
	public void save(Usuario usuario) {
		usuarioDao.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findOne(Long id) {
		return usuarioDao.findOne(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		usuarioDao.delete(id);
	}
//----------------Metodos de Mascotas--------------//
	@Override
	@Transactional
	public void saveMascota(Mascota mascota) {
		mascotaDao.save(mascota);
	}

	@Override
	@Transactional
	public void deleteMascota(Long id) {
		mascotaDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Mascota finMascotaById(Long id) {
		return mascotaDao.findById(id).orElse(null);
	}

}
