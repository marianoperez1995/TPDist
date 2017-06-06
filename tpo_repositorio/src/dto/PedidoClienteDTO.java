package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class PedidoClienteDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1972886678300862606L;
	private int idPedidoCliente;
	private ClienteDTO cliente;
	private String estado;
	private Date fechaGeneracion;
	private Date fechaProbableDespacho;
	private Date fechaDespacho;
	private Date fechaEntregaCliente;
	public void setFechaEntregaCliente(Date fechaEntregaCliente) {
		this.fechaEntregaCliente = fechaEntregaCliente;
	}

	private ArrayList<ItemPedidoClienteDTO> itemsPedidoCliente;
	private float precioTotal;

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	public Date getFechaProbableDespacho() {
		return fechaProbableDespacho;
	}

	public void setFechaProbableDespacho(Date fechaProbableDespacho) {
		this.fechaProbableDespacho = fechaProbableDespacho;
	}

	public Date getFechaDespacho() {
		return fechaDespacho;
	}

	public void setFechaDespacho(Date fechaDespacho) {
		this.fechaDespacho = fechaDespacho;
	}

	public ArrayList<ItemPedidoClienteDTO> getItemsPedidoCliente() {
		return itemsPedidoCliente;
	}

	public void setItemsPedidoCliente(ArrayList<ItemPedidoClienteDTO> itemsPedidoCliente) {
		this.itemsPedidoCliente = itemsPedidoCliente;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

	public int getIdPedidoCliente() {
		return idPedidoCliente;
	}

	public void setIdPedidoCliente(int idPedidoCliente) {
		this.idPedidoCliente = idPedidoCliente;
	}

	public Date getFechaEntregaCliente() {
		return fechaEntregaCliente;
	}

	@Override
	public String toString() {
		return "PedidoClienteDTO [idPedidoCliente=" + idPedidoCliente + ", cliente=" + cliente + ", estado=" + estado
				+ ", fechaGeneracion=" + fechaGeneracion + ", fechaProbableDespacho=" + fechaProbableDespacho
				+ ", fechaDespacho=" + fechaDespacho + ", fechaEntregaCliente=" + fechaEntregaCliente
				+ ", itemsPedidoCliente=" + itemsPedidoCliente + ", precioTotal=" + precioTotal + "]";
	}
	
	



}
