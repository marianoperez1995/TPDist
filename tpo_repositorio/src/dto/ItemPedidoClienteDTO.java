package dto;

import java.io.Serializable;

public class ItemPedidoClienteDTO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1482380232710090312L;
	private PrendaDTO prenda;
	private String color;
	private String talle;
	private int cantidad;
	private float precio;

	public PrendaDTO getPrenda() {
		return prenda;
	}

	public void setPrenda(PrendaDTO prenda) {
		this.prenda = prenda;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
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
}
