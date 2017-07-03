package dto;

import java.io.Serializable;
import java.util.Date;

public  class OrdenProduccionDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9165972967280614986L;
	protected Date fecha;
	protected PrendaDTO prenda;
	protected PedidoClienteDTO pedidoCliente;
	protected int codigo;
	protected String tipo;
	protected int cantidad;
	protected String estado;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return fecha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public PrendaDTO getPrenda() {
		return prenda;
	}

	public void setPrenda(PrendaDTO prenda) {
		this.prenda = prenda;
	}

	public PedidoClienteDTO getPedidoCliente() {
		return pedidoCliente;
	}

	public void setPedidoCliente(PedidoClienteDTO pedidoCliente) {
		this.pedidoCliente = pedidoCliente;
	}

	public int getIdOrden() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public boolean esParcial() {
		
		return (this.tipo.equals("opp"));
	}



}
