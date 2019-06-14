/*package com.miclinica.springboot.backend.apirest.controlers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.miclinica.springboot.backend.apirest.models.entity.Animal;
import com.miclinica.springboot.backend.apirest.models.services.IAnimalService;
import com.miclinica.springboot.backend.apirest.models.services.IUploadFileService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class AnimalRestController {
	
	@Autowired
	private IAnimalService animalService;
	
	@Autowired
	private IUploadFileService uploadService;
	
	@GetMapping("/animales")
	public List<Animal> index(){
		return animalService.findAll();
	}
	
	@GetMapping("/animales/{id}")
	public Animal show(@PathVariable Long id) {
		return animalService.findById(id);
	}
	
	@PostMapping("/animales")
	@ResponseStatus(HttpStatus.CREATED)
	public Animal create(@RequestBody Animal animal) {
		return animalService.save(animal);
	}
	
	@PutMapping("/animales/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Animal update(@RequestBody Animal animal, @PathVariable Long id) {
		Animal animalActual = animalService.findById(id);
		animalActual.setRaza(animal.getRaza());
		animalActual.setTipo(animal.getTipo());
		return animalService.save(animalActual);
	}
	
	@DeleteMapping("/animales/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete (@PathVariable Long id) {
		animalService.delete(id);
	}
	
	@PostMapping("/animales/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id){
		Map<String, Object> response = new HashMap<>();
		
		Animal animal = animalService.findById(id);
		
		if(!archivo.isEmpty()) {

			String nombreArchivo = null;
			try {
				nombreArchivo = uploadService.copiar(archivo);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen del animal");
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);	
			}
			
			String nombreFotoAnterior = animal.getFoto();
			
			uploadService.eliminar(nombreFotoAnterior);
			
			animal.setFoto(nombreArchivo);
			
			animalService.save(animal);
			
			response.put("animal", animal);
			response.put("mensaje", "Has subido correctamente la imagen: " + nombreArchivo);
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/uploads/imgbicho/{nombreFoto:.+}")
	public ResponseEntity<Resource> verFotoAnimal(@PathVariable String nombreFoto){
	
		Resource recurso = null;
		
		try {
			recurso = uploadService.cargar(nombreFoto);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");
		
		return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
	}
}
*/