package co.edu.ue.cerveza.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.cerveza.model.Role;
import co.edu.ue.cerveza.model.Usuario;

public interface UsuarioJPA extends JpaRepository<Usuario, Integer>{

	Usuario findUsuarioByEmail(String email);

	Usuario save(Role rol);
}
