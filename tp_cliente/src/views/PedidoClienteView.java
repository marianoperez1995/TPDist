package views;

import java.util.ArrayList;
import java.util.Date;

public class PedidoClienteView {
	private int idPedidoCliente;
	private ClienteView cliente;
	private String estado;
	private Date fechaGeneracion;
	private Date fechaProbableDespacho;
	private Date fechaDespacho;
	private ArrayList<ItemPedidoClienteView> itemsPedidoCliente;
	private float precioTotal;
	
	public int getIdPedidoCliente() {
		return idPedidoCliente;
	}
	public ClienteView getCliente() {
		return cliente;
	}
	public String getEstado() {
		return estado;
	}
	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}
	public Date getFechaProbableDespacho() {
		return fechaProbableDespacho;
	}
	public Date getFechaDespacho() {
		return fechaDespacho;
	}
	public ArrayList<ItemPedidoClienteView> getItemsPedidoCliente() {
		return itemsPedidoCliente;
	}
	public float getPrecioTotal() {
		return precioTotal;
	}
}
