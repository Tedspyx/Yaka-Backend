package co.edu.ue.cerveza.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.cerveza.model.Role;

public interface RoleJPA extends JpaRepository<Role, Integer>{

}
