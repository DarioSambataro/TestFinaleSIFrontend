package it.project.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.project.model.Utente;

public interface UtenteDao extends CrudRepository <Utente, Integer>{
	Optional<Utente> findByEmail(String email);
}
