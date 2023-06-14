package com.ar.apigroupfamily.family.app.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ar.apigroupfamily.family.app.exceptions.NotFoundException;
import com.ar.apigroupfamily.family.app.model.GrupoFamiliar;
import com.ar.apigroupfamily.family.app.model.Persona;
import com.ar.apigroupfamily.family.app.repository.RepositoryGrupoFamiliar;
import com.ar.apigroupfamily.family.app.repository.RepositoryPersona;

@Service
public class PersonaToFamiliaService {

	private static Logger logger = Logger.getLogger(PersonaToFamiliaService.class);

	@Autowired
	private RepositoryGrupoFamiliar repositoryGF;

	@Autowired
	private RepositoryPersona repositoryPersona;

	public List<Persona> getPersonasInFamilia(Long idFamilia) {
		GrupoFamiliar gf = repositoryGF.findById(idFamilia)
				.orElseThrow(() -> new NotFoundException("GrupoFamiliar not found with id: " + idFamilia));
		List<Persona> personas = gf.getPersonas();
		return personas;
	}

	public Persona addFamiliaToPersona(Long idFamilia, Long idPersona) {
		try {
			GrupoFamiliar gf = repositoryGF.findById(idFamilia)
					.orElseThrow(() -> new NotFoundException("GrupoFamiliar not found with id: " + idFamilia));
			Persona p = repositoryPersona.findById(idPersona)
					.orElseThrow(() -> new NotFoundException("Persona not found with id: " + idPersona));

			if (p.getGrupoFamiliar() == null) {
				p.setGrupoFamiliar(gf);
				return repositoryPersona.save(p);
			}
		} catch (NotFoundException e) {
			logger.info(e.getMessage());
		}
		return null;

	}

	public Persona updateFamilia(Long idFamilia, Long idPersona) {
		try {
			GrupoFamiliar gf = repositoryGF.findById(idFamilia)
					.orElseThrow(() -> new NotFoundException("GrupoFamiliar not found with id: " + idFamilia));
			Persona p = repositoryPersona.findById(idPersona)
					.orElseThrow(() -> new NotFoundException("Persona not found with id: " + idPersona));

			if (p.getGrupoFamiliar() != null) {
				p.setGrupoFamiliar(gf);
				return repositoryPersona.save(p);
			}
		} catch (NotFoundException e) {
			logger.info(e.getMessage());
		}
		return null;
	}

}
