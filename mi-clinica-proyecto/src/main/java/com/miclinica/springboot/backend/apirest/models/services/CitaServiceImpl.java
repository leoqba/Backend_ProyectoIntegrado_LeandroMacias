package com.miclinica.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miclinica.springboot.backend.apirest.models.dao.ICitaDao;
import com.miclinica.springboot.backend.apirest.models.entity.Cita;

@Service
public class CitaServiceImpl implements ICitaService{


	@Autowired
	private ICitaDao citaDao;
	
	@Override
	@Transactional(readOnly= true)
	public  List<Cita> findAll(){
		return (List<Cita>) citaDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Cita findById(Long id) {
		return citaDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Cita save(Cita cita) {
		return citaDao.save(cita);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		citaDao.deleteById(id);
	}
}
