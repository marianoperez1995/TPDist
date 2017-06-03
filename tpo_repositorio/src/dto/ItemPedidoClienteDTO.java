package dto;

import java.io.Serializable;

public class ItemPedidoClienteDTO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1482380232710090312L;
	private int idItemPedidoCliente;
	private PrendaDTO prenda;
	private int cantidad;
	private float precio;

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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getIdItemPedidoCliente() {
		return idItemPedidoCliente;
	}

	public void setIdItemPedidoCliente(int idItemPedidoCliente) {
		this.idItemPedidoCliente = idItemPedidoCliente;
	}
}
