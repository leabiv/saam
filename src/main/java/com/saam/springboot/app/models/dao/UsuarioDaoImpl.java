package com.saam.springboot.app.models.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.saam.springboot.app.models.entity.Usuario;

@Repository
public class UsuarioDaoImpl implements IUsuarioDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAll() {
		return em.createQuery("from Usuario").getResultList();
	}

	@Override
	public void save(Usuario usuario) {
		if (usuario.getIdUsuario() != null && usuario.getIdUsuario() > 0) {
			em.merge(usuario);
		} else {
			em.persist(usuario);
		}
	}

	@Override
	public Usuario findOne(Long id) {
		return em.find(Usuario.class, id);
	}

	@Override
	public void delete(Long id) {
		Usuario usuario = findOne(id);
		em.remove(usuario);
		
	}

}
