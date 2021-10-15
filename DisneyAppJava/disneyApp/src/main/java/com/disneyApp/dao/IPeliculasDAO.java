package com.disneyApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disneyApp.entities.Pelicula;
@Repository
public interface IPeliculasDAO extends JpaRepository<Pelicula, Long> {
	
	
	
}
