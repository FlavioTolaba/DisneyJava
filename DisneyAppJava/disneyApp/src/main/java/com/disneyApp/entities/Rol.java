package com.disneyApp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.springframework.lang.NonNull;

import com.disneyApp.enums.RolNombre;

@Entity

public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull
	@Enumerated(EnumType.STRING)
	@Column(unique = true)
	private RolNombre rolNombre;
	
	
	public Rol(int id, RolNombre rolnombre) {		
		this.id = id;
		this.rolNombre = rolnombre;
	}
	
	public Rol() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RolNombre getRolnombre() {
		return rolNombre;
	}

	public void setRolnombre(RolNombre rolnombre) {
		this.rolNombre = rolnombre;
	}
	
	

}
