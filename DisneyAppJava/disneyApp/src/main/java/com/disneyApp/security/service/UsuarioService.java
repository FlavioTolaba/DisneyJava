package com.disneyApp.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disneyApp.dao.IUsuarioDAO;
import com.disneyApp.entities.Usuario;

@Service
public class UsuarioService  {
	
	@Autowired
	private IUsuarioDAO usuarioDao;
	
	public List<Usuario> listadoUsuarios(){
		return usuarioDao.findAll();
	}
	
	public Optional<Usuario> getUsuario(Long id){
		return usuarioDao.findById(id);
	}
	
	public Optional<Usuario> getByUsername(String username){
		return usuarioDao.findByUsername(username);
	}
	
	public void guardarUsuario(Usuario usuario) {
		usuarioDao.save(usuario);
	}
	public boolean existsById(Long id) {
		return usuarioDao.existsById(id);
	}
	public boolean existsByUsername(String username) {
		return usuarioDao.existsByUsername(username);
	}
	
}
