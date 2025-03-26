package co.edu.ue.cerveza.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.cerveza.model.Role;

@Repository
public class RoleRepository implements IRoleRepository{

	@Autowired
	RoleJPA jpa;
	@Override
	public Role addRole(Role role) {
		return jpa.save(role);
	}

	@Override
	public List<Role> listRole() {
		return jpa.findAll();
	}

	@Override
	public Role searchRoleId(int id) {
		return jpa.findById(id).orElse(null);
	}
	
	@Override
	public Role upRole(Role role) {
		return jpa.save(role);
	}

	@Override
	public Role deleteRole(int id) {
		Role rol = jpa.findById(id).orElse(null);
		if(rol != null) {
			jpa.deleteById(id);
		}
		jpa.deleteById(id);
		return null;
	}


}
