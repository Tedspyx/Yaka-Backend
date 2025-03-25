package co.edu.ue.cerveza.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the carrito database table.
 * 
 */
@Entity
@NamedQuery(name="Carrito.findAll", query="SELECT c FROM Carrito c")
public class Carrito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int cantidad;

	//bi-directional many-to-one association to Cerveza
	@ManyToOne
	@JoinColumn(name="cerveza_id")
	private Cerveza cerveza;

	//bi-directional many-to-one association to Presentacione
	@ManyToOne
	@JoinColumn(name="presentacion_id")
	private Presentacion presentaciones;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	public Carrito() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Cerveza getCerveza() {
		return this.cerveza;
	}

	public void setCerveza(Cerveza cerveza) {
		this.cerveza = cerveza;
	}

	public Presentacion getPresentacione() {
		return this.presentaciones;
	}

	public void setPresentaciones(Presentacion presentaciones) {
		this.presentaciones = presentaciones;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}