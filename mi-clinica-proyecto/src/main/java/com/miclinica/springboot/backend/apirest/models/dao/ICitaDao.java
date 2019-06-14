package com.miclinica.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.miclinica.springboot.backend.apirest.models.entity.Cita;

public interface ICitaDao extends CrudRepository<Cita, Long> {

}
