package co.edu.ue.cerveza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.cerveza.model.Usuario;
import co.edu.ue.cerveza.repository.UsuarioJPA;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioJPA jpa;
	
	public Usuario addUsuario(Usuario usuario) {
		return jpa.save(usuario);
	}
	
	public List<Usuario> allUsuario(){
		return jpa.findAll();					
	}
	
	public Usuario findUsuarioById(int id) {
		return jpa.findById(id).orElse(null);
	}
	
	public Usuario updateUsuario(Usuario usuario) {
		return jpa.save(usuario);
	}
	
	public Usuario deleteUsuario(int id) {
		Usuario rol = jpa.findById(id).orElse(null);
		if(rol != null) {
			jpa.deleteById(id);
		}
		jpa.deleteById(id);
		return null;
	}
	
}
