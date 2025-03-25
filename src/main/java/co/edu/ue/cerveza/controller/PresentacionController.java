package co.edu.ue.cerveza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.cerveza.model.Presentacion;
import co.edu.ue.cerveza.repository.PresentacionJPA;

@RestController
@RequestMapping(value="presentacion")
public class PresentacionController {

	@Autowired
	PresentacionJPA jpa;
	
	@GetMapping(value="getPresentacion", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Presentacion> getAllPresentacion(){
		return jpa.findAll();
	}
	
	@GetMapping(value="getPresentacionById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Presentacion getPresentacionById(@PathVariable("id")int id) {
		return jpa.findById(id).orElse(null);
	}
	
	@PostMapping(value="addPresentacion", produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes =  MediaType.APPLICATION_JSON_VALUE )
	public List<Presentacion> addPresentacion(@RequestBody Presentacion presentacion){
		Presentacion rol = jpa.save(presentacion);
		if(rol != null)
			return this.getAllPresentacion();
		else
			return null;
	}
	
	@PutMapping(value="updatePresentacion", produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes =  MediaType.APPLICATION_JSON_VALUE )	
	public Presentacion updatePresentacion(@RequestBody Presentacion presentacion) {
		if(presentacion.getId() == null) {
			return null;
		}
		if(jpa.existsById(presentacion.getId())) {
			return jpa.save(presentacion);
		}else
			return presentacion;
	}
	
	@DeleteMapping(value="deletePresentacion/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deletePresentacion(@PathVariable("id")int id) {
		if(jpa.existsById(id)) {
			jpa.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
