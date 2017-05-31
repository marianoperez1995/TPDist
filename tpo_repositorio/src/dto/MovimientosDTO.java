package dto;

import java.io.Serializable;

public class MovimientosDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1943863001578044950L;
	private int idMovimiento;
	private PrendaDTO prenda;	
	private String tipo;
	private int cantidad;
	private ClienteDTO cliente;
	private PedidoClienteDTO pedido;
	private OrdenProduccionDTO orden;
	
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	public PedidoClienteDTO getPedido() {
		return pedido;
	}
	public void setPedido(PedidoClienteDTO pedido) {
		this.pedido = pedido;
	}
	public OrdenProduccionDTO getOrden() {
		return orden;
	}
	public void setOrden(OrdenProduccionDTO orden) {
		this.orden = orden;
	}	
	

	
}
