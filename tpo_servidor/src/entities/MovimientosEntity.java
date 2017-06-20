package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Movimientos")
public class MovimientosEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2146241905306386039L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMovimiento;
	
	@JoinColumns({
		@JoinColumn(name = "idPrenda", referencedColumnName = "idPrenda") })
	@ManyToOne
	private PrendaEntity prenda;
	
	private String detalle;
	private int cantidad;

	
	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public PrendaEntity getPrenda() {
		return prenda;
	}

	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}

	public int getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}



	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	


	
	
	
	
}
