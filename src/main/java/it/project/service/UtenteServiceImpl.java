package it.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.project.dao.UtenteDao;
import it.project.dto.UtenteDto;
import it.project.dto.UtenteLoginRequestDto;
import it.project.dto.UtenteSignupDto;
import it.project.model.Utente;

@Service
public class UtenteServiceImpl implements UtenteService{
	@Autowired
	public UtenteDao utenteDao;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public boolean login(UtenteLoginRequestDto utenteLoginRequest) {
		Optional<Utente> optional = utenteDao.findByEmail(utenteLoginRequest.getEmail());
		
		String encrypted = DigestUtils.sha256Hex(utenteLoginRequest.getPassword());
		
		boolean pres = optional.isPresent();
		String s1 = optional.get().getPassword();
		String s2 = encrypted;
		boolean isEqual = s1.equals(s2);
		
		if(pres && isEqual) {
			return true;
		}
			
		else {
			return false;
		}
	}

	@Override
	public void userSignup(UtenteSignupDto utenteSignupDto) {
		Utente user = new Utente();

		user.setFirstname(utenteSignupDto.getFirstname());
		user.setLastname(utenteSignupDto.getLastname());
		user.setEmail(utenteSignupDto.getEmail());		
		user.setPassword(DigestUtils.sha256Hex(utenteSignupDto.getPassword()));
		
		utenteDao.save(user);
		
	}

	@Override
	public Utente getUserByEmail(String email) {
		Optional<Utente> opt = utenteDao.findByEmail(email);
		return opt.get();
	}

	@Override
	public boolean existsUtenteByEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UtenteDto> getAllUser() {
		try {
			List<Utente> utente = (List<Utente>) utenteDao.findAll();
			List<UtenteDto> utentiDto = new ArrayList<>();
			
			utente.forEach(u -> utentiDto.add(modelMapper.map(u, UtenteDto.class)));
			return utentiDto;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public void userDelete(String email) {
		Optional<Utente> optional = utenteDao.findByEmail(email);
		
		if(optional.isPresent()) {
			utenteDao.delete(optional.get());
			
		}
			
		
	}
}
