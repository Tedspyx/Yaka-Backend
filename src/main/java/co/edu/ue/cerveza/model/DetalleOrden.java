package co.edu.ue.cerveza.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the detalle_orden database table.
 * 
 */
@Entity
@Table(name="detalle_orden")
@NamedQuery(name="DetalleOrden.findAll", query="SELECT d FROM DetalleOrden d")
public class DetalleOrden implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int cantidad;

	@Column(name="precio_unitario")
	private BigDecimal precioUnitario;

	//bi-directional many-to-one association to Cerveza
	@ManyToOne
	private Cerveza cerveza;

	//bi-directional many-to-one association to Ordene
	@ManyToOne
	@JoinColumn(name="orden_id")
	private Ordenes ordene;

	//bi-directional many-to-one association to Presentacione
	@ManyToOne
	@JoinColumn(name="presentacion_id")
	private Presentacion presentacione;

	public DetalleOrden() {
	}

	public int getId() {
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

	public BigDecimal getPrecioUnitario() {
		return this.precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Cerveza getCerveza() {
		return this.cerveza;
	}

	public void setCerveza(Cerveza cerveza) {
		this.cerveza = cerveza;
	}

	public Ordenes getOrdene() {
		return this.ordene;
	}

	public void setOrdene(Ordenes ordene) {
		this.ordene = ordene;
	}

	public Presentacion getPresentacione() {
		return this.presentacione;
	}

	public void setPresentacione(Presentacion presentacione) {
		this.presentacione = presentacione;
	}

}