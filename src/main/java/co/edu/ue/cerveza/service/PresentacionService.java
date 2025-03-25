package co.edu.ue.cerveza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.cerveza.model.Presentacion;
import co.edu.ue.cerveza.repository.PresentacionJPA;

@Service
public class PresentacionService {

	@Autowired
	PresentacionJPA jpa;
	
	public Presentacion addPresentacion(Presentacion presentacion) {
		return jpa.save(presentacion);
	}
	
	public List<Presentacion> allPresentacion(){
		return jpa.findAll();					
	}
	
	public Presentacion findPresentacionById(int id) {
		return jpa.findById(id).orElse(null);
	}
	
	public Presentacion updatePresentacion(Presentacion presentacion) {
		return jpa.save(presentacion);
	}
	
	public Presentacion deletePresentacion(int id) {
		Presentacion presentacion = jpa.findById(id).orElse(null);
		if(presentacion != null) {
			jpa.deleteById(id);
		}
		jpa.deleteById(id);
		return null;
	}
}
