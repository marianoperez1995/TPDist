package dto;

import java.io.Serializable;
import java.util.Date;

public class PagoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6781224962623996107L;
	private int idPago;
	private float montoAnterior;
	private float monto;
	private ClienteDTO cliente;
	private Date fechaPago;
	public int getIdPago() {
		return idPago;
	}
	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public float getMontoAnterior() {
		return montoAnterior;
	}
	public void setMontoAnterior(float montoAnterior) {
		this.montoAnterior = montoAnterior;
	}
	
}
