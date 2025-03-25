package co.edu.ue.cerveza.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ordenes database table.
 * 
 */
@Entity
@Table(name="ordenes")
@NamedQuery(name="Ordenes.findAll", query="SELECT o FROM Ordenes o")
public class Ordenes implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="direccion_envio")
	private String direccionEnvio;

	private String estado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_orden")
	private Date fechaOrden;

	private BigDecimal total;

	//bi-directional many-to-one association to DetalleOrden
	@OneToMany(mappedBy="ordene")
	private List<DetalleOrden> detalleOrdens;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	public Ordenes() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccionEnvio() {
		return this.direccionEnvio;
	}

	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaOrden() {
		return this.fechaOrden;
	}

	public void setFechaOrden(Date fechaOrden) {
		this.fechaOrden = fechaOrden;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<DetalleOrden> getDetalleOrdens() {
		return this.detalleOrdens;
	}

	public void setDetalleOrdens(List<DetalleOrden> detalleOrdens) {
		this.detalleOrdens = detalleOrdens;
	}

	public DetalleOrden addDetalleOrden(DetalleOrden detalleOrden) {
		getDetalleOrdens().add(detalleOrden);
		detalleOrden.setOrdene(this);

		return detalleOrden;
	}

	public DetalleOrden removeDetalleOrden(DetalleOrden detalleOrden) {
		getDetalleOrdens().remove(detalleOrden);
		detalleOrden.setOrdene(null);

		return detalleOrden;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}