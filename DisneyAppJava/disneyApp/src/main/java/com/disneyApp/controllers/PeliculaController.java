package com.disneyApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.disneyApp.entities.Pelicula;
import com.disneyApp.service.IPeliculasService;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {
	
	
	@Autowired
	private IPeliculasService peliculaService;
	
	@GetMapping("/ver-comentarios/{id}")
	public String peli(@PathVariable Long id , Model model) {
		
		Pelicula pelicula = peliculaService.peliculaPorId(id); 
		model.addAttribute("pelicula", pelicula);
		
		return "comentarios/verComentarios";
	}
	
	
}
