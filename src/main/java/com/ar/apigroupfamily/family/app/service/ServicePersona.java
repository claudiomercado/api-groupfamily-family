package com.ar.apigroupfamily.family.app.service;

import java.util.List;

import com.ar.apigroupfamily.family.app.model.GrupoFamiliar;
import com.ar.apigroupfamily.family.app.model.Persona;


public interface ServicePersona {
	
	Persona findById(Long id);
	List<Persona> findAll();
	void create(Persona persona);
	void update(Long id,Persona persona);
	void delete(Long id);
	Persona addFamily(Long id_persona, Long id_familiar);
}
