package com.inserta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inserta.entities.UsuarioPremio;
import com.inserta.repos.UsuariopremioRepo;



@Service
public class UsuariopremioService {
	@Autowired
	UsuariopremioRepo usuarioPremioRepo;
	
	
	public List<UsuarioPremio>  getPremios() {
		return usuarioPremioRepo.findAll();
	}
	
	public void eliminarPremio(Integer idusuariopremio) {
		UsuarioPremio usuarioPremio = usuarioPremioRepo.findById(idusuariopremio).get();
		usuarioPremioRepo.delete(usuarioPremio);
	}
	public UsuarioPremio obtenerUnPremio(Integer id) {
		return  usuarioPremioRepo.findById(id).get();
	}
	
	public void editarUsuarioPremio(Integer cantidad, Integer id) {
		
		UsuarioPremio usuarioPremio = usuarioPremioRepo.findById(id).get();
		usuarioPremio.setCantidad(cantidad);
	
		
		usuarioPremioRepo.save(usuarioPremio);
		
	}
	
}