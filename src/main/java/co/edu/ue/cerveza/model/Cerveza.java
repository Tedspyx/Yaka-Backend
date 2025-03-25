package co.edu.ue.cerveza.model;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The persistent class for the cervezas database table.
 * 
 */
@Entity
@Table(name="cervezas")
@NamedQuery(name="Cerveza.findAll", query="SELECT c FROM Cerveza c")
public class Cerveza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="nombre")
	private String nombre;



	public Cerveza() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

}