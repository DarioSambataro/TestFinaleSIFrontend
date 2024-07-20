package it.project.service;

import it.project.dto.UtenteSignupDto;
import it.project.model.Utente;

import java.util.List;

import it.project.dto.UtenteDto;
import it.project.dto.UtenteLoginRequestDto;

public interface UtenteService {
	boolean login(UtenteLoginRequestDto userLoginRequestDto);
	
	void userSignup(UtenteSignupDto userdDto);

	Utente getUserByEmail(String email);

	boolean existsUtenteByEmail(String email);

	List<UtenteDto> getAllUser();

	void userDelete(String email);
}
