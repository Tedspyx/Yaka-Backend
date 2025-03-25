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

import co.edu.ue.cerveza.model.Cerveza;
import co.edu.ue.cerveza.repository.CervezaJPA;

@RestController
@RequestMapping(value="cerveza")
public class CervezaController {

	@Autowired
	CervezaJPA jpa;
	
	@GetMapping(value="getCerveza", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cerveza> getAllCerveza(){
		return jpa.findAll();
	}
	
	@GetMapping(value="getCervezaById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Cerveza getCervezaById(@PathVariable("id")int id) {
		return jpa.findById(id).orElse(null);
	}
	
	@PostMapping(value="addCerveza", produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes =  MediaType.APPLICATION_JSON_VALUE )
	public List<Cerveza> addCerveza(@RequestBody Cerveza cerveza){
		Cerveza beer = jpa.save(cerveza);
		if(beer != null)
			return this.getAllCerveza();
		else
			return null;
	}
	
	@PutMapping(value="updateCerveza", produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes =  MediaType.APPLICATION_JSON_VALUE )	
	public Cerveza updateRole(@RequestBody Cerveza cerveza) {
		if(cerveza.getId() == null) {
			return null;
		}
		if(jpa.existsById(cerveza.getId())) {
			return jpa.save(cerveza);
		}else
			return cerveza;
	}
	
	@DeleteMapping(value="deleteCerveza/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteCerveza(@PathVariable("id")int id) {
		if(jpa.existsById(id)) {
			jpa.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
