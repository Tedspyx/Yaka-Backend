package co.edu.ue.cerveza.service;

import java.util.List;

import co.edu.ue.cerveza.model.Role;

public interface IRoleService {

	Role addRoles(Role role);
	List<Role> listRoles();
	Role searchRolesId(int id);
	Role upRoles(Role role);
	Role delRoles(int id);
}
