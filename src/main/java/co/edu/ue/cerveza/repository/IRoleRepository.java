package co.edu.ue.cerveza.repository;

import java.util.List;

import co.edu.ue.cerveza.model.Role;

public interface IRoleRepository {

	Role addRole(Role role);
	List<Role> listRole();
	Role searchRoleId(int id);
	Role upRole(Role role);
	Role deleteRole(int id);
}
