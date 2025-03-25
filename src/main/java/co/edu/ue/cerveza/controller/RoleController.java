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

import co.edu.ue.cerveza.model.Role;
import co.edu.ue.cerveza.repository.RoleJPA;

@RestController
@RequestMapping(value="role")
public class RoleController {
	
	@Autowired
	RoleJPA jpa;
	
	@GetMapping(value="getRole", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Role> getAllRole(){
		return jpa.findAll();
	}
	
	@GetMapping(value="getRoleById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Role getRoleById(@PathVariable("id")int id) {
		return jpa.findById(id).orElse(null);
	}
	
	@PostMapping(value="addRole", produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes =  MediaType.APPLICATION_JSON_VALUE )
	public List<Role> addRole(@RequestBody Role role){
		Role rol = jpa.save(role);
		if(rol != null)
			return this.getAllRole();
		else
			return null;
	}
	
	@PutMapping(value="updateRole", produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes =  MediaType.APPLICATION_JSON_VALUE )	
	public Role updateRole(@RequestBody Role role) {
		if(role.getId() == null) {
			return null;
		}
		if(jpa.existsById(role.getId())) {
			return jpa.save(role);
		}else
			return role;
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
