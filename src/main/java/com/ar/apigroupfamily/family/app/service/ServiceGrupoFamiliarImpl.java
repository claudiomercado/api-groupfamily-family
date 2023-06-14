package com.ar.apigroupfamily.family.app.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ar.apigroupfamily.family.app.exceptions.NotFoundException;
import com.ar.apigroupfamily.family.app.model.GrupoFamiliar;
import com.ar.apigroupfamily.family.app.model.Persona;
import com.ar.apigroupfamily.family.app.repository.RepositoryGrupoFamiliar;

@Service
public class ServiceGrupoFamiliarImpl implements ServiceGrupoFamiliar {

	@Autowired
	private RepositoryGrupoFamiliar repository;

	@Override
	public GrupoFamiliar findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new NotFoundException("GrupoFamiliar not found with id: " + id));
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
		GrupoFamiliar gf = repository.findById(id)
				.orElseThrow(() -> new NotFoundException("GrupoFamiliar not found with id: " + id));
		List<Persona> integrantes = gf.getPersonas();

		gf.setNombre(grupoFamiliar.getNombre() != null ? grupoFamiliar.getNombre() : gf.getNombre());
		gf.setNro_familia(
				grupoFamiliar.getNro_familia() != null ? grupoFamiliar.getNro_familia() : gf.getNro_familia());
		gf.setMascotas(grupoFamiliar.isMascotas());
		gf.setPersonas(integrantes);

		return repository.save(gf);
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);

	}

}
