package co.edu.ue.cerveza.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.cerveza.model.Cerveza;

public interface CervezaJPA extends JpaRepository<Cerveza, Integer> {

}
