package com.ar.apigroupfamily.family.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ar.apigroupfamily.family.app.model.GrupoFamiliar;
import com.ar.apigroupfamily.family.app.model.Persona;
import com.ar.apigroupfamily.family.app.service.PersonaToFamiliaService;
import com.ar.apigroupfamily.family.app.service.ServicePersona;
import com.ar.apigroupfamily.family.app.utils.FileWriterUtil;

@RestController
@RequestMapping("/groupfamily/persona")
public class ControllerPersona {

	@Autowired
	private ServicePersona service;

	@Autowired
	private PersonaToFamiliaService personaToFamilia;

	@GetMapping("/getById/{id}")
	public Persona getById(@PathVariable Long id) {
		return this.service.findById(id);
	}

	@GetMapping("/getAll")
	public List<Persona> getAll() {
		return this.service.findAll();
	}

	@PostMapping("/createPersona")
	public Persona create(@RequestBody Persona persona) {
		FileWriterUtil.createFile("persona.txt", persona.toString());
		return this.service.create(persona);
	}

	@PutMapping("/update/{id}")
	public Persona updateById(@PathVariable Long id, @RequestBody Persona persona) {
		return this.service.update(id, persona);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Long id) {
		this.service.delete(id);
	}

	@PostMapping("/addFamily")
	public Persona addFamilia(@RequestParam(name = "idFamilia") Long idFamilia,
			@RequestParam(name = "idPersona") Long idPersona) {
		return this.personaToFamilia.addFamiliaToPersona(idFamilia, idPersona);
	}

	@GetMapping("/updateFamily/{id}")
	public Persona updateFamilia(@RequestParam(name = "idFamilia") Long idFamilia,
			@RequestParam(name = "idPersona") Long idPersona) {
		return this.personaToFamilia.updateFamilia(idFamilia, idPersona);
	}

	@GetMapping("/getPersonasIntoFamilia")
	public List<Persona> getPersonas(@RequestParam(name = "id_familia") Long idFamilia) {
		return this.personaToFamilia.getPersonasInFamilia(idFamilia);
	}

//	@GetMapping("/mensaje")
//	public String mensaje() {
//		return "this.service.findById(id);";
//	}
//	
}
