package com.ar.apigroupfamily.family.app.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ar.apigroupfamily.family.app.model.Persona;

@Component
public interface ServicePersona {

	Persona findById(Long id);

	List<Persona> findAll();

	Persona create(Persona persona);

	Persona update(Long id, Persona persona);

	void delete(Long id);
}
