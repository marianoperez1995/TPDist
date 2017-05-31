package negocio;

import dto.ItemPedidoClienteDTO;
import dto.PedidoClienteDTO;
import entities.ItemPedidoClienteEntity;
import persistencia.ItemPedidoClienteDAO;

public class ItemPedidoCliente {
	private int idItemPedidoCliente;
	private Prenda prenda;
	private String color;
	private String talle;
	private int cantidad;
	private float precio;
	
	public ItemPedidoCliente(ItemPedidoClienteDTO p) {
		this.prenda = new Prenda(p.getPrenda());
		this.color = p.getColor();
		this.talle = p.getTalle();
		this.cantidad = p.getCantidad();
		this.precio = p.getPrecio();
	}

	public ItemPedidoCliente(ItemPedidoClienteEntity p) {
		this.prenda = new Prenda(p.getPrenda());
		this.color = p.getColor().getNombre();
		this.talle = p.getTalle().getNombre();
		this.cantidad = p.getCantidad();
		this.precio = p.getPrecio();
	}

	public void insertar() {
		ItemPedidoClienteDAO.getInstancia().insert(this);		
	}

	public void borrar() {
		ItemPedidoClienteDAO.getInstancia().eliminar(this.idItemPedidoCliente);
	}

	
	
	
	public Prenda getPrenda() {
		return prenda;
	}

	public void setPrenda(Prenda prenda) {
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

	public int getIdItemPedidoCliente() {
		return idItemPedidoCliente;
	}

	public void setIdItemPedidoCliente(int idItemPedidoCliente) {
		this.idItemPedidoCliente = idItemPedidoCliente;
	}

	public ItemPedidoClienteDTO toDTO(PedidoClienteDTO p) {
		ItemPedidoClienteDTO item = new ItemPedidoClienteDTO();
		item.setCantidad(cantidad);
		item.setColor(color);
		item.setPrecio(precio);
		item.setPrenda(prenda.toDTO());
		item.setTalle(talle);
		
	}
	
}
