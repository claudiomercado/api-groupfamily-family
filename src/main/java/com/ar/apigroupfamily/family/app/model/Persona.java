package com.ar.apigroupfamily.family.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name = "persona")
public class Persona{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "sexo")
	private String sexo;
	
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;
	
	@Column(name = "edad")
	private Integer edad;
	
	@ManyToOne
	@JoinColumn(name = "id_grupo_familiar")
	private GrupoFamiliar grupoFamiliar;
	
	public Persona() {
	}

	public Persona(String nombre, String apellido, String dni, String sexo, Date fechaNacimiento,Integer edad,GrupoFamiliar grupoFamiliar) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
		this.grupoFamiliar = grupoFamiliar;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", sexo=" + sexo
				+ ", fechaNacimiento=" + fechaNacimiento + ", edad=" + edad + ", grupoFamiliar=" + grupoFamiliar + "]";
	}
	
}
