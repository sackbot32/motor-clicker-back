package com.inserta.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


import com.inserta.entities.UsuarioPremio;


@Repository
@RepositoryRestResource(path="usuariospremios")
public interface UsuariopremioRepo extends CrudRepository<UsuarioPremio, Integer> {
	
	List<UsuarioPremio> findAll();
	
	
}

