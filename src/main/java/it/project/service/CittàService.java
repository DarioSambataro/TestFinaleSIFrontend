package it.project.service;

import java.util.List;

import it.project.dto.CittàDto;
import it.project.model.Città;

public interface CittàService {
	Città getCittàByName(String name);
	
	List<Città> getAllCities();
	
	void insertCittà(CittàDto città);
}
