package negocio;

import dto.MovimientosDTO;
import entities.MovimientosEntity;

public class Movimientos {	
	
	
	public Movimientos(MovimientosEntity mov) {
		this.idMovimiento = mov.getIdMovimiento();
		this.prenda = new Prenda(mov.getPrenda());
		this.setDetalle(mov.getDetalle());
		this.cantidad = mov.getCantidad();
		
	}
	
	public Movimientos (MovimientosDTO mov){
		this.idMovimiento = mov.getIdMovimiento();
		this.prenda = new Prenda(mov.getPrenda());
		this.setDetalle(mov.getDetalle());
		this.cantidad = mov.getCantidad();
	}
	private int idMovimiento;
	private Prenda prenda;	
	private String detalle;
	private int cantidad;
	
	
	public int getIdMovimiento() {
		return idMovimiento;
	}
	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	public Prenda getPrenda() {
		return prenda;
	}
	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}

	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	
	
	
}
