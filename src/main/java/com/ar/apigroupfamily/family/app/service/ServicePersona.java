package com.ar.apigroupfamily.family.app.service;

import java.util.List;

import com.ar.apigroupfamily.family.app.model.GrupoFamiliar;
import com.ar.apigroupfamily.family.app.model.Persona;


public interface ServicePersona {
	
	Persona findById(Long id);
	List<Persona> findAll();
	Persona create(Persona persona);
	Persona update(Long id,Persona persona);
	void delete(Long id);
	Persona addFamilia(Long idFamilia, Long idPersona);
	Persona updateFamilia(Long idFamilia, Long idPersona);
}
