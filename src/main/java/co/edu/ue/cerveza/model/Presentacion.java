package co.edu.ue.cerveza.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the presentaciones database table.
 * 
 */
@Entity
@Table(name="presentaciones")
@NamedQuery(name="Presentacion.findAll", query="SELECT p FROM Presentacion p")
public class Presentacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="nombre")
	private String nombre;

	@Column(name="precio")
	private BigDecimal precio;


	public Presentacion() {
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

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	

}