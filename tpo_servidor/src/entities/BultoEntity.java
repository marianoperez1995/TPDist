package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="Bultos")
public class BultoEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4086862321958841435L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private int idBulto;
	private Date fechaGeneracion;
	private int cantidad;	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo")
	private UbicacionEntity ubicacion;
	@ManyToOne
	@JoinColumn(name = "idPrenda")
	private PrendaEntity prenda;	
	public int getIdBulto() {
		return idBulto;
	}
	public void setIdBulto(int idBulto) {
		this.idBulto = idBulto;
	}
	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}
	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public UbicacionEntity getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(UbicacionEntity ubicacion) {
		this.ubicacion = ubicacion;
	}
	public PrendaEntity getPrenda() {
		return prenda;
	}
	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}
	
	
}
