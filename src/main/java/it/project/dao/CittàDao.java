package it.project.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.project.model.Città;

public interface CittàDao extends CrudRepository<Città, Integer> {	
	Optional<Città> findByNome(String name);
	Optional <Città> findById(int id);
}
