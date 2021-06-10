package com.inserta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inserta.entities.Premio;
import com.inserta.repos.PremioRepo;



@Service
public class PremioService {
	@Autowired
	PremioRepo premioRepo;
	
	
	public List<Premio>  getPremios() {
		return premioRepo.findAll();
	}
	
	public void eliminarPremio(Integer idpremio) {
		Premio premio = premioRepo.findById(idpremio).get();
		premioRepo.delete(premio);
	}
	public Premio obtenerUnPremio(Integer id) {
		return  premioRepo.findById(id).get();
	}
	
	public void editarPremio( String nombre, Integer precio,
			Integer produce, String foto,  Integer id) {
		
		Premio premio = premioRepo.findById(id).get();
		premio.setNombre(nombre);
		premio.setPrecio(precio);;
		premio.setProduce(produce);
		premio.setFoto(foto);
		
		premioRepo.save(premio);
		
	}
	
}