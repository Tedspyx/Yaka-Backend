package co.edu.ue.cerveza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.cerveza.model.Cerveza;
import co.edu.ue.cerveza.repository.CervezaJPA;

@Service
public class CervezaService {

	@Autowired
	CervezaJPA jpa;
	
	public Cerveza addCerveza(Cerveza cerveza) {
		return jpa.save(cerveza);
	}
	
	public List<Cerveza> allCerveza(){
		return jpa.findAll();					
	}
	
	public Cerveza findCervezaById(int id) {
		return jpa.findById(id).orElse(null);
	}
	
	public Cerveza updateCerveza(Cerveza cerveza) {
		return jpa.save(cerveza);
	}
	
	public Cerveza deleteCerveza(int id) {
		Cerveza rol = jpa.findById(id).orElse(null);
		if(rol != null) {
			jpa.deleteById(id);
		}
		jpa.deleteById(id);
		return null;
	}
}
