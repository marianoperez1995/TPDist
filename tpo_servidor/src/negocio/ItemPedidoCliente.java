package negocio;

import dto.ItemPedidoClienteDTO;
import dto.PedidoClienteDTO;
import entities.ItemPedidoClienteEntity;
import persistencia.ItemPedidoClienteDAO;

public class ItemPedidoCliente {
	private int idItemPedidoCliente;
	private Prenda prenda;
	private int cantidad;
	private float precio;
	
	public ItemPedidoCliente(ItemPedidoClienteDTO p) {
		this.prenda = new Prenda(p.getPrenda());
		this.idItemPedidoCliente = p.getIdItemPedidoCliente();
		this.cantidad = p.getCantidad();
		this.precio = p.getPrecio();
	}

	public ItemPedidoCliente(ItemPedidoClienteEntity p) {
		this.prenda = new Prenda(p.getId().getPrenda());
		this.cantidad = p.getCantidad();
		this.precio = p.getPrecio();
		this.idItemPedidoCliente = p.getId().getPedido().getNumPedidoCliente();
	}

	public ItemPedidoCliente() {
		// TODO Auto-generated constructor stub
	}

	public void insertar(int idPed) {
		ItemPedidoClienteDAO.getInstancia().insert(this, idPed);		
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
		item.setPrecio(precio);
		item.setPrenda(prenda.toDTO());
		return item;		
	}
	
}
