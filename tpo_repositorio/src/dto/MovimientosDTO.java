package dto;

import java.io.Serializable;

public class MovimientosDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1943863001578044950L;
	private int idMovimiento;
	private PrendaDTO prenda;	
	private String detalle;
	private int cantidad;
	
	
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public int getIdMovimiento() {
		return idMovimiento;
	}
	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	public PrendaDTO getPrenda() {
		return prenda;
	}
	public void setPrenda(PrendaDTO prenda) {
		this.prenda = prenda;
	}
	
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	

	
}
