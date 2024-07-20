package it.project.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.project.dao.CittàDao;
import it.project.dto.CittàDto;
import it.project.model.Città;

@Service
public class CittàServiceImpl implements CittàService{
	@Autowired
	public CittàDao cittàDao;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Città getCittàByName(String name) {
		Optional<Città> optionalCittà = cittàDao.findByNome(name);
		
		if(optionalCittà.isPresent()) {
			return optionalCittà.get();
		}
		else {
			return new Città();
		}
	}

	@Override
	public List<Città> getAllCities() {
		List<Città> listaCittà = (List<Città>) cittàDao.findAll();
		
		return listaCittà;
	}

	@Override
	public void insertCittà(CittàDto città) {
		Città city = new Città();
		
		city.setId(città.getId());
		city.setNome(città.getNome());
		
		cittàDao.save(city);	
	}
	
}
