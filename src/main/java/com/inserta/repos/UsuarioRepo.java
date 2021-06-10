package com.inserta.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.inserta.entities.Usuario;
@Repository
@RepositoryRestResource(path="usuarios")
public interface UsuarioRepo extends CrudRepository<Usuario, Integer> {
	List<Usuario> findAll();
	
	Usuario findByEmail(String email);
	
}
