package co.edu.ue.cerveza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.cerveza.model.Role;
import co.edu.ue.cerveza.repository.IRoleRepository;

@Service
public class RoleService {

	@Autowired
	IRoleRepository repository;
	
	public Role addRol(Role role) {
		return repository.addRole(role);
	}
	
	public List<Role> allRoles(){
		return repository.listRole();					
	}
	
	public Role findRoleById(int id) {
		return repository.searchRoleId(id);
	}
	
	public Role updateRole(Role role) {
		return repository.upRole(role);
	}
	
	public Role deleteRole(int id) {
		Role rol = repository.searchRoleId(id);
		if(rol != null) {
			repository.deleteRole(id);
		}
		repository.deleteRole(id);
		return null;
	}
}
