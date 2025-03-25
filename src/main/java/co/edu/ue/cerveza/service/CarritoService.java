package co.edu.ue.cerveza.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.ue.cerveza.model.Carrito;
import co.edu.ue.cerveza.repository.CarritoJPA;

@Service
public class CarritoService {

	CarritoJPA jpa;
	
	public Carrito addCarrito(Carrito carrito) {
		return jpa.save(carrito);
	}
	
	public List<Carrito> allCarrito(){
		return jpa.findAll();
	}
	
	public Carrito findCarritoById(int id) {
		return jpa.findById(id).orElse(null);
	}
	
	public Carrito updateCarrito(Carrito carrito) {
		return jpa.save(carrito);
	}
	
	public Carrito deleteCarrito(int id) {
		Carrito carro = jpa.findById(id).orElse(null);
		if(carro != null) {
			jpa.deleteById(id);
		}
		jpa.deleteById(id);
		return null;
	}
}
