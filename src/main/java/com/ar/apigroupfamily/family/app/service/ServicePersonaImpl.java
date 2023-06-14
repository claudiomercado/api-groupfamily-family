package com.ar.apigroupfamily.family.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ar.apigroupfamily.family.app.exceptions.NotFoundException;
import com.ar.apigroupfamily.family.app.model.Persona;
import com.ar.apigroupfamily.family.app.repository.RepositoryPersona;

@Service
public class ServicePersonaImpl implements ServicePersona {

	@Autowired
	private RepositoryPersona repository;

	@Override
	public Persona findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("Persona not found with id: " + id));
	}

	@Override
	public List<Persona> findAll() {
		return repository.findAll();
	}

	@Override
	public Persona create(Persona persona) {
		return repository.save(persona);
	}

	@Override
	public Persona update(Long id, Persona persona) {
		Persona p = repository.findById(id)
				.orElseThrow(() -> new NotFoundException("Persona not found with id: " + id));

		p.setNombre(persona.getNombre() != null ? persona.getNombre() : p.getNombre());
		p.setApellido(persona.getApellido() != null ? persona.getApellido() : p.getApellido());
		p.setDni(persona.getDni() != null ? persona.getDni() : p.getDni());
		p.setSexo(persona.getSexo() != null ? persona.getSexo() : p.getSexo());
		p.setFechaNacimiento(
				persona.getFechaNacimiento() != null ? persona.getFechaNacimiento() : p.getFechaNacimiento());
		p.setEdad(persona.getEdad() != null ? persona.getEdad() : p.getEdad());

		return repository.save(p);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

}