package com.disneyApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.disneyApp.dao.IPeliculasDAO;
import com.disneyApp.entities.Pelicula;
import com.disneyApp.service.IPeliculasService;

@Service
public class PeliculasServiceImpl implements IPeliculasService {

	@Autowired
	private IPeliculasDAO peliculaDao;
	@Override
	public void save(Pelicula pelicula) {
		peliculaDao.save(pelicula);
	}
	@Override
	public List<Pelicula> listadoDePeliculas() {
		
		return peliculaDao.findAll();
	}
	@Override
	public Pelicula peliculaPorId(Long id) {
		// TODO Auto-generated method stub
		return peliculaDao.findById(id).orElse(null);
	}

}
