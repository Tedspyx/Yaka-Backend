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

import co.edu.ue.cerveza.model.Carrito;
import co.edu.ue.cerveza.repository.CarritoJPA;

@RestController
@RequestMapping(value="carrito")
public class CarritoController {

	@Autowired
	CarritoJPA jpa;
	
	@GetMapping(value="getCarrito", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Carrito> getAllCarrito(){
		return jpa.findAll();
	}
	
	@GetMapping(value="getCarritoById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Carrito getCarritoById(@PathVariable("id")int id) {
		return jpa.findById(id).orElse(null);
	}
	
	@PostMapping(value="addCarrito", produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes =  MediaType.APPLICATION_JSON_VALUE )
	public List<Carrito> addCarrito(@RequestBody Carrito carrito){
		Carrito carro = jpa.save(carrito);
		if(carro != null)
			return this.getAllCarrito();
		else
			return null;
	}
	
	@PutMapping(value="updateCarrito", produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes =  MediaType.APPLICATION_JSON_VALUE )	
	public Carrito updateCarrito(@RequestBody Carrito carrito) {
		if(carrito.getId() == null) {
			return null;
		}
		if(jpa.existsById(carrito.getId())) {
			return jpa.save(carrito);
		}else
			return carrito;
	}
	
	@DeleteMapping(value="deleteRole/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteRole(@PathVariable("id")int id) {
		if(jpa.existsById(id)) {
			jpa.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
