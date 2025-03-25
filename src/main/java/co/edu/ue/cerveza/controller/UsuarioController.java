package co.edu.ue.cerveza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.cerveza.model.Usuario;
import co.edu.ue.cerveza.repository.UsuarioJPA;

@RestController
@RequestMapping(value="usuario")
@CrossOrigin(origins="*")
public class UsuarioController {

	@Autowired
	UsuarioJPA jpa;
	
	@GetMapping(value="getUsuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> getAllUsuario(){
		return jpa.findAll();
	}
	
	@GetMapping(value="getUsuarioById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario getUsuarioById(@PathVariable("id")int id) {
		return jpa.findById(id).orElse(null);
	}
	
	@GetMapping(value="getUsuarioByEmail/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario getUsuarioByEmail(@PathVariable("email") String email) {
		return jpa.findUsuarioByEmail(email);
	}
	
	
	@PostMapping(value="addUsuario", produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes =  MediaType.APPLICATION_JSON_VALUE )
	public List<Usuario> addUsuario(@RequestBody Usuario usuario){
		Usuario rol = jpa.save(usuario);
		if(rol != null)
			return this.getAllUsuario();
		else
			return null;
	}
	
	@PutMapping(value="updateUsuario", produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes =  MediaType.APPLICATION_JSON_VALUE )	
	public Usuario updateUsuario(@RequestBody Usuario usuario) {
		if(usuario.getId() == null) {
			return null;
		}
		if(jpa.existsById(usuario.getId())) {
			return jpa.save(usuario);
		}else
			return usuario;
	}
	
	@DeleteMapping(value="deleteUsuario/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteRole(@PathVariable("id")int id) {
		if(jpa.existsById(id)) {
			jpa.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
