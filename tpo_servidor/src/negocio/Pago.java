package negocio;

import java.util.Date;

import dto.PagoDTO;
import entities.PagoEntity;

public class Pago {
	private int idPago;
	private float monto;
	private Cliente cliente;
	private Date fechaPago;
	private float montoAnterior;
	
	public Pago(PagoEntity p) {
		this.idPago = p.getIdPago();
		this.monto = p.getMonto();
		this.cliente = new Cliente (p.getCliente());
		this.fechaPago = p.getFechaPago();
		this.montoAnterior = p.getMontoAnterior();
	}	
	public Pago() {
	
	}	
	public Pago(PagoDTO p) {
		this.idPago = p.getIdPago();
		this.monto = p.getMonto();
		this.montoAnterior = p.getMontoAnterior();
		this.cliente = new Cliente (p.getCliente());
		this.fechaPago = p.getFechaPago();
	}
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
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
	public PagoDTO toDTO() {
		PagoDTO p = new PagoDTO();
		p.setIdPago(this.idPago);
		p.setFechaPago(this.fechaPago);
		p.setMonto(this.monto);
		p.setMontoAnterior(this.montoAnterior);
		
		return p;
	}
	
}
