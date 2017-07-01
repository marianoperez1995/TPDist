package negocio;

import java.util.ArrayList;
import java.util.Date;

import entities.PedidoInsumoEntity;

public class PedidoInsumo {
	
	private int idPedidoInsumo;
	private Proveedor proveedor;
	private Date fechaPedido;
	private Date fechaEntrega;
	private ArrayList<ItemPedidoInsumo> itemsPedidoInsumo;
	private OrdenProduccion ordenProduccion;
	
	public PedidoInsumo(PedidoInsumoEntity pedE) {
		this.idPedidoInsumo= pedE.getIdPedidoInsumo();
		this.proveedor=new Proveedor(pedE.getProveedor());
		// TODO Auto-generated constructor stub
	}
	public PedidoInsumo() {
		// TODO Auto-generated constructor stub
	}
	public int getIdPedidoInsumo() {
		return idPedidoInsumo;
	}
	public void setIdPedidoInsumo(int idPedidoInsumo) {
		this.idPedidoInsumo = idPedidoInsumo;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	
	public Date getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public ArrayList<ItemPedidoInsumo> getItemsPedidoInsumo() {
		return itemsPedidoInsumo;
	}
	public void setItemsPedidoInsumo(ArrayList<ItemPedidoInsumo> itemsPedidoInsumo) {
		this.itemsPedidoInsumo = itemsPedidoInsumo;
	}
	public OrdenProduccion getOrdenProduccion() {
		return ordenProduccion;
	}
	public void setOrdenProduccion(OrdenProduccion ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}
	public boolean sosElPedido(int codigo) {
		// TODO Auto-generated method stub
		return codigo == this.idPedidoInsumo;
	}
	 

}
