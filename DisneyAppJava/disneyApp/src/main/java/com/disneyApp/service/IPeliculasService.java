package com.disneyApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.disneyApp.entities.Pelicula;

@Service
public interface IPeliculasService {
	void save(Pelicula pelicula);
	List<Pelicula> listadoDePeliculas();
	Pelicula peliculaPorId(Long id);
}
