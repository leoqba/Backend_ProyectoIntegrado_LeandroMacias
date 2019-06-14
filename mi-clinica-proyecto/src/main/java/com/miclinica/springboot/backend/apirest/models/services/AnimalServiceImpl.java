/*package com.miclinica.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miclinica.springboot.backend.apirest.models.dao.IAnimalDao;
import com.miclinica.springboot.backend.apirest.models.dao.ICitaDao;
import com.miclinica.springboot.backend.apirest.models.entity.Animal;
import com.miclinica.springboot.backend.apirest.models.entity.Cita;

@Service
public class AnimalServiceImpl implements IAnimalService {

	@Autowired
	private IAnimalDao animalDao;

	@Autowired
	private ICitaDao citaDao;

					// Animales
	@Override
	@Transactional(readOnly = true)
	public List<Animal> findAll() {
		return (List<Animal>) animalDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Animal findById(Long id) {
		return animalDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Animal save(Animal animal) {
		return animalDao.save(animal);
	}

	@Override
	public void delete(Long id) {
		animalDao.deleteById(id);

	}

						// CITAS
	@Override
	@Transactional(readOnly = true)
	public List<Cita> findAllCita(){
		return (List<Cita>) citaDao.findAll();
	}
	
	@Override
	public Cita findCitaById(Long id) {
		return citaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteCitaById(Long id) {
		citaDao.deleteById(id);

	}

	@Override
	@Transactional
	public Cita saveCita(Cita cita) {
		return citaDao.save(cita);
	}

}*/
