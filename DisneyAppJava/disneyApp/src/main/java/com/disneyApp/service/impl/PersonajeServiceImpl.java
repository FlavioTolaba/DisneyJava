package com.disneyApp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disneyApp.dao.IPersonajeDAO;
import com.disneyApp.entities.Personaje;
import com.disneyApp.service.IPersonajeService;

@Service
public class PersonajeServiceImpl implements IPersonajeService {

	@Autowired
	private IPersonajeDAO personajeDao;
	
	@Override
	public void savePersonaje(Personaje personaje) {
		personajeDao.save(personaje);
		
	}

}
