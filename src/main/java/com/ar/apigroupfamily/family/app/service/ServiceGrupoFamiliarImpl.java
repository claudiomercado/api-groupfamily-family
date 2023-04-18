package com.ar.apigroupfamily.family.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ar.apigroupfamily.family.app.model.GrupoFamiliar;
import com.ar.apigroupfamily.family.app.model.Persona;
import com.ar.apigroupfamily.family.app.repository.RepositoryGrupoFamiliar;
import com.ar.apigroupfamily.family.app.repository.RepositoryPersona;

@Service
public class ServiceGrupoFamiliarImpl implements ServiceGrupoFamiliar {

	@Autowired
	private RepositoryGrupoFamiliar repository;
	
//	@Autowired
//	private RepositoryPersona repositoryPersona;

	@Override
	public GrupoFamiliar findById(Long id) {
		return repository.findById(id).get();		
	}

	@Override
	public List<GrupoFamiliar> findAll() {
		return repository.findAll();
	}

	@Override
	public GrupoFamiliar create(GrupoFamiliar grupoFamiliar) {
	return this.repository.save(grupoFamiliar);
	}

	@Override
	public GrupoFamiliar update(Long id, GrupoFamiliar grupoFamiliar) {
		GrupoFamiliar gf = repository.findById(id).get();
		List<Persona> integrantes = gf.getPersonas();
		
		gf.setNombre(grupoFamiliar.getNombre() != null ?grupoFamiliar.getNombre() : gf.getNombre());
		gf.setNro_familia(grupoFamiliar.getNro_familia()!= null ? grupoFamiliar.getNombre() : gf.getNro_familia());
		gf.setMascotas(grupoFamiliar.isMascotas());
		gf.setPersonas(integrantes);
		
		return repository.save(gf);		
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
		
	}

//	@Override
//	public void addPersona(Long idPersona, Long idFamilia) {
//		GrupoFamiliar gf = repository.findById(idFamilia).get();
//	
//		Persona p = repositoryPersona.findById(idPersona).get();
//		p.setGrupoFamiliar(gf);
//		List<Persona> personas = gf.getPersonas();
//		personas.add(p);
//		
//		gf.setPersonas(personas);
//		repository.save(gf);
//	
//	}
	
//	@Override
//	public GrupoFamiliar findById(Long id) {
//		
//		GrupoFamiliar familia = repository.findById(id).get();
//		
//		List<Persona> integrantes = this.obtenerListado(id);
//		familia.setPersonas(integrantes);
//		
//		return familia;
//	}

//	public List<Persona> obtenerListado(Long id){
//		
////		GrupoFamiliar familia =repository.findById(id).get();	
////		Long idFamilia = familia.getId();
//		
//		List<Persona> personas = repositoryPersona.findAll(); 
//		List<Persona> integrantes = (List<Persona>) personas.stream().filter(x -> (x.getGrupoFamiliar().getId() ==id));
//		return integrantes;
//		
//	}
//	
//	

}
