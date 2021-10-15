package com.disneyApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disneyApp.entities.Personaje;

@Repository
public interface IPersonajeDAO extends JpaRepository<Personaje, Long> {

}
