package com.miclinica.springboot.backend.apirest.models.services;

import java.util.List;

import com.miclinica.springboot.backend.apirest.models.entity.Cita;

public interface ICitaService {
	
	public List<Cita> findAll();
	
	public Cita findById(Long id);
	
	public Cita save(Cita cita);
	
	public void delete(Long id);

}
