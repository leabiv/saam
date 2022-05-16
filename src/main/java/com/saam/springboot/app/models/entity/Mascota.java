package com.saam.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mascotas")
public class Mascota implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long registroUnico;
	@Column(name = "nombre_mascota")
	private String nombre;
	@Column(name = "edad_mascota")
	private Integer edad;
	@Column(name = "genero_mascota")
	private String genero;
	@Column(name = "tamanio_mascota")
	private String tamanio;
	@Column(name = "descripcion_mascota")
	private String descripcion;

	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;

	public Long getRegistroUnico() {
		return registroUnico;
	}

	public void setRegistroUnico(Long registroUnico) {
		this.registroUnico = registroUnico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	private static final long serialVersionUID = 1L;

}
