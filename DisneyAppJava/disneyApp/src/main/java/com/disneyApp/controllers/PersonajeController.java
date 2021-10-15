package com.disneyApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.disneyApp.entities.Pelicula;
import com.disneyApp.entities.Personaje;
import com.disneyApp.service.IPersonajeService;

@Controller
@RequestMapping("/personajes")
@SessionAttributes("peliParaPersonaje")
public class PersonajeController {
	
	@Autowired
	private IPersonajeService personajeService;
	
	@GetMapping("/personajes-form")
	public String personajesForm(Personaje personaje, Model model, @ModelAttribute("peliParaPersonaje") Pelicula pelicula) {
		model.addAttribute("personaje", new Personaje());
		model.addAttribute("film",pelicula);
		
		return "admin/personajesForm";
	}
	
	@PostMapping("/save")
	public String savePersonajes(Personaje personaje, RedirectAttributes redirect,Model model, @ModelAttribute("peliParaPersonaje") Pelicula pelicula ) {
		personajeService.savePersonaje(personaje);
		redirect.addFlashAttribute("personajeGuardado" , "personaje guardado con exito!");
		return "redirect:/personajes/personajes-form";
	}
}
