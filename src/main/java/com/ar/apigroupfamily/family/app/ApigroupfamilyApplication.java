package com.ar.apigroupfamily.family.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.ar.apigroupfamily.family.app.model.GrupoFamiliar;
import com.ar.apigroupfamily.family.app.model.Persona;
import com.ar.apigroupfamily.family.app.service.ServiceGrupoFamiliar;
import com.ar.apigroupfamily.family.app.service.ServicePersona;

@SpringBootApplication
@ComponentScan
public class ApigroupfamilyApplication implements CommandLineRunner{

	
	public static void main(String[] args) {
		SpringApplication.run(ApigroupfamilyApplication.class, args);
	}

	@Autowired
	private ServiceGrupoFamiliar serviceGF;
	
	@Autowired
	private ServicePersona servicePersona;	
	
	@Override
	public void run(String... args) throws Exception {
		
//		GrupoFamiliar gf1 = serviceGF.findById(1L);
//		List<Persona> personas = gf1.getPersonas();
//		
//		for (Persona persona : personas) {
//			System.out.println(persona.getNombre());
//		}
		Persona p = servicePersona.findById(2L);
		System.out.println(p);
		
		
	}

}
