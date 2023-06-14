package com.ar.apigroupfamily.family.app.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ar.apigroupfamily.family.app.model.GrupoFamiliar;

@Component
public interface ServiceGrupoFamiliar {

	GrupoFamiliar findById(Long id);

	List<GrupoFamiliar> findAll();

	GrupoFamiliar create(GrupoFamiliar grupoFamiliar);

	GrupoFamiliar update(Long id, GrupoFamiliar grupoFamiliar);

	void delete(Long id);

}
