package com.inserta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inserta.entities.Usuario;
import com.inserta.repos.UsuarioRepo;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepo usuarioRepo;
	
	
	public List<Usuario>  getUsuarios() {
		return usuarioRepo.findAll();
	}
	
	public void eliminarUsuario(Integer idusuario) {
		Usuario usuario = usuarioRepo.findById(idusuario).get();
		usuarioRepo.delete(usuario);
	}
	public Usuario obtenerUnUsuario(Integer id) {
		return  usuarioRepo.findById(id).get();
	}
	
	public void editarUsuario( String nombre, String nick,
			String email, String clave, Integer puntuacion, Integer id) {
		
		Usuario usuario = usuarioRepo.findById(id).get();
		usuario.setNombre(nombre);
		usuario.setNick(nick);
		usuario.setEmail(email);
		usuario.setClave(clave);
		usuario.setPuntuacion(puntuacion);
		
		usuarioRepo.save(usuario);
		
	}
	


	
	

}
