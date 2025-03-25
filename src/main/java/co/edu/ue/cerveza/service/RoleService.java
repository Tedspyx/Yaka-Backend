package co.edu.ue.cerveza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.cerveza.model.Role;
import co.edu.ue.cerveza.repository.RoleJPA;

@Service
public class RoleService {

	@Autowired
	RoleJPA jpa;
	
	public Role addRol(Role role) {
		return jpa.save(role);
	}
	
	public List<Role> allRoles(){
		return jpa.findAll();					
	}
	
	public Role findRoleById(int id) {
		return jpa.findById(id).orElse(null);
	}
	
	public Role updateRole(Role role) {
		return jpa.save(role);
	}
	
	public Role deleteRole(int id) {
		Role rol = jpa.findById(id).orElse(null);
		if(rol != null) {
			jpa.deleteById(id);
		}
		jpa.deleteById(id);
		return null;
	}
}
