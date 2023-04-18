package com.ar.apigroupfamily.family.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity(name = "grupo_familiar")
public class GrupoFamiliar{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "nro_familia")
	private String nro_familia;
	
	@Column(name = "mascotas")
	private boolean mascotas;
	
	@JsonBackReference
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "grupoFamiliar", cascade = CascadeType.ALL)
	private List<Persona> personas = new ArrayList<>();
	
	public GrupoFamiliar(String nombre, String nro_familia, boolean mascotas, List<Persona> personas) {
		this.nombre = nombre;
		this.nro_familia = nro_familia;
		this.mascotas = mascotas;
		this.personas = personas;
	}
	
	public GrupoFamiliar() {
	}

	@Override
	public String toString() {
		return "GrupoFamiliar [id=" + id + ", nombre=" + nombre + ", nro_familia=" + nro_familia + ", mascotas="
				+ mascotas + ", personas=" + personas + "]";
	}
	
}
