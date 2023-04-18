package com.ar.apigroupfamily.family.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ar.apigroupfamily.family.app.model.GrupoFamiliar;
import com.ar.apigroupfamily.family.app.service.ServiceGrupoFamiliar;

@RestController
@RequestMapping("/groupfamily/grupoFamiliar")
public class ControllerGrupoFamiliar {

	@Autowired
	ServiceGrupoFamiliar service;

	
	@GetMapping("/getById/{id}")
	public GrupoFamiliar getById(@PathVariable Long id) {
		return this.service.findById(id);
	}
	
	@GetMapping("/getAll")
	public List<GrupoFamiliar> getAll() {
		return this.service.findAll();
	}
	
	@PostMapping("/createGrupoFamiliar")
	public GrupoFamiliar create(@RequestBody GrupoFamiliar grupoFamiliar) {
		return this.service.create(grupoFamiliar);
	}
	
	@PutMapping("/update/{id}")
	public GrupoFamiliar updateById(@PathVariable Long id, @RequestBody GrupoFamiliar grupoFamiliar) {
		return this.service.update(id, grupoFamiliar);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Long id) {
		this.service.delete(id);
	}
	
	@GetMapping("/mensaje")
	public String mensaje() {
		return "this.service.findById(id);";
	}
}
