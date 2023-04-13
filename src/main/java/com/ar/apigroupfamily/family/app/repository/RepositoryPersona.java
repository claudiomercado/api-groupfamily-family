package com.ar.apigroupfamily.family.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ar.apigroupfamily.family.app.model.Persona;


@Repository
public interface RepositoryPersona extends JpaRepository<Persona, Long> {

	
}
