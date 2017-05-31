package negocio;

import java.util.ArrayList;
import java.util.Date;

import entities.PedidoInsumoEntity;

public class PedidoInsumo {
	
	private int idPedidoInsumo;
	private Proveedor proveedor;
	private Date fechaGeneracion;
	private Date fechaProbableDespacho;
	private Date fechaDespacho;
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
