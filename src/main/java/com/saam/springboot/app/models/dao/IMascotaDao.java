package com.saam.springboot.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.saam.springboot.app.models.entity.Mascota;

public interface IMascotaDao extends CrudRepository<Mascota, Long>{
	
}
