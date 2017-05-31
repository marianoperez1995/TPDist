package views;

public class ItemPedidoClienteView {
	private PrendaView prenda;
	private String color;
	private String talle;
	private int cantidad;
	
	public PrendaView getPrenda() {
		return prenda;
	}
	public String getColor() {
		return color;
	}
	public String getTalle() {
		return talle;
	}
	public int getCantidad() {
		return cantidad;
	}
	public float getPrecio() {
		return precio;
	}
	private float precio;
}
