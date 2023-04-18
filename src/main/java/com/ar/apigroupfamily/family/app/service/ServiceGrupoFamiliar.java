package com.ar.apigroupfamily.family.app.service;

import java.util.List;

import com.ar.apigroupfamily.family.app.model.GrupoFamiliar;

public interface ServiceGrupoFamiliar {

	GrupoFamiliar findById(Long id);
	List<GrupoFamiliar> findAll();
	GrupoFamiliar create(GrupoFamiliar grupoFamiliar);
	GrupoFamiliar update(Long id,GrupoFamiliar grupoFamiliar);
	void delete(Long id);
	//void addPersona(Long idPersona, Long idFamilia);
}
