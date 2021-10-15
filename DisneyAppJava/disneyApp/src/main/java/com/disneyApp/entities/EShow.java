package com.disneyApp.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name= "EShows")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//	@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "TYPE")
public class EShow {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String portada;
	@Column(name="fecha_estreno")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date fechaEstreno;
	
	//relacion
	@OneToMany(fetch = FetchType.LAZY)
	private List<Personaje> personajes;
	
	public EShow(Long id, String titulo, String portada, Date fechaEstreno, List<Personaje> personajes) {
		
		this.id = id;
		this.titulo = titulo;
		this.portada = portada;
		this.fechaEstreno = fechaEstreno;
		this.personajes = personajes;
	}
	
	
	public EShow() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getPortada() {
		return portada;
	}


	public void setPortada(String portada) {
		this.portada = portada;
	}


	public Date getFechaEstreno() {
		return fechaEstreno;
	}


	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}


	public List<Personaje> getPersonajes() {
		return personajes;
	}


	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}
	
	public void addPersonajes(Personaje personaje) {
		personajes.add(personaje);
	}
	
}
