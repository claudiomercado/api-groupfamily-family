package com.ar.apigroupfamily.family.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ar.apigroupfamily.family.app.model.GrupoFamiliar;
import com.ar.apigroupfamily.family.app.model.Persona;
import com.ar.apigroupfamily.family.app.service.ServicePersona;


@RestController
@RequestMapping("/groupfamily/persona")
public class ControllerPersona {

	@Autowired
	private ServicePersona service;
	
	@GetMapping("/getById/{id}")
	public Persona getById(@PathVariable Long id) {
		return this.service.findById(id);
	}
	
	@GetMapping("/getAll")
	public List<Persona> getAll() {
		return this.service.findAll();
	}
	
	@PostMapping("/createPersona")
	public void create(@RequestBody Persona persona) {
		this.service.create(persona);
	}
	
	@PutMapping("/update/{id}")
	public void updateById(@PathVariable Long id, @RequestBody Persona persona) {
		this.service.update(id, persona);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Long id) {
		this.service.delete(id);
	}
	
	
	@PutMapping("/addFamily/{idPersona}/{idFamilia}")
	public Persona addFamily(@PathVariable(name = "idPersona") Long id_persona, @PathVariable (name = "idFamilia")Long id_familia) {
		return this.service.addFamily(id_persona, id_familia);
	}
	
	@GetMapping("/mensaje")
	public String mensaje() {
		return "this.service.findById(id);";
	}
	
}
