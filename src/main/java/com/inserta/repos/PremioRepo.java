package com.inserta.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.inserta.entities.Premio;


@Repository
@RepositoryRestResource(path="premios")
public interface PremioRepo extends CrudRepository<Premio, Integer> {
	List<Premio> findAll();
	
	
}

