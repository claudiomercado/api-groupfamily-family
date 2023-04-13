package com.ar.apigroupfamily.family.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ar.apigroupfamily.family.app.model.GrupoFamiliar;
import com.ar.apigroupfamily.family.app.model.Persona;
import com.ar.apigroupfamily.family.app.repository.RepositoryGrupoFamiliar;
import com.ar.apigroupfamily.family.app.repository.RepositoryPersona;


@Service
public class ServicePersonaImpl implements ServicePersona{

	@Autowired
	private RepositoryPersona repository;
	
	@Autowired
	private RepositoryGrupoFamiliar repositoryGF;
	
	@Override
	public Persona findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Persona> findAll() {
		return repository.findAll();
	}

	@Override
	public void create(Persona persona) {
		repository.save(persona);
	}

	@Override
	public void update(Long id, Persona persona) {
		Persona p = repository.findById(id).get();
		
		p.setNombre(persona.getNombre() != null ?persona.getNombre() : p.getNombre());
		p.setApellido(persona.getApellido() != null ?persona.getApellido() : p.getApellido());
		p.setDni(persona.getDni() != null ?persona.getDni() : p.getDni());
		p.setSexo(persona.getSexo() != null ?persona.getSexo() : p.getSexo());
		p.setFechaNacimiento(persona.getFechaNacimiento() != null ?persona.getFechaNacimiento() : p.getFechaNacimiento());
		p.setEdad(persona.getEdad() != null ?persona.getEdad() : p.getEdad());
		//p.setGrupoFamiliar(persona.getGrupoFamiliar()!= null ? persona.getGrupoFamiliar(): p.getGrupoFamiliar());
		
		repository.save(p);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);		
	}

	public Persona addFamily(Long idPersona, Long idFamilia) {
		Persona p1 = repository.findById(idPersona).get();
		GrupoFamiliar gf = repositoryGF.findById(idFamilia).get();
		
		p1.setGrupoFamiliar(gf);
		repository.save(p1);
		return this.findById(idPersona);
	}

}