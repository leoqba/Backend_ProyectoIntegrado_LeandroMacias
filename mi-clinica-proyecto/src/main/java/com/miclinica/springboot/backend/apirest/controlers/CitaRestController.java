package com.miclinica.springboot.backend.apirest.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.miclinica.springboot.backend.apirest.models.entity.Cita;
import com.miclinica.springboot.backend.apirest.models.services.ICitaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class CitaRestController {
	
	@Autowired
	private ICitaService citaService;

	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/citas")
	public List<Cita> index(){
		return citaService.findAll();
	}
	
	@GetMapping("/citas/{id}")
	public Cita show(@PathVariable Long id) {
		return citaService.findById(id);
	}
	
	@PostMapping("/citas")
	@ResponseStatus(HttpStatus.CREATED)
	public Cita create(@RequestBody Cita cita) {
		return citaService.save(cita);
	}
	
	@DeleteMapping("/citas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete (@PathVariable Long id) {
		citaService.delete(id);
	}
}
