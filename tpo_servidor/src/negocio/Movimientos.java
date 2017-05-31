package negocio;

import dto.MovimientosDTO;
import entities.MovimientosEntity;

public class Movimientos {	
	
	
	public Movimientos(MovimientosEntity mov) {
		this.idMovimiento = mov.getIdMovimiento();
		this.prenda = new Prenda(mov.getPrenda());
		this.tipo = mov.getTipo();
		this.cantidad = mov.getCantidad();
		this.cliente = new Cliente(mov.getCliente());
		this.pedido = new PedidoCliente(mov.getPedido());
		if (mov.getOrden().esParcial())
			this.orden = new Opp (mov.getOrden());
		else
			this.orden = new Opc(mov.getOrden());	
	}
	
	public Movimientos (MovimientosDTO mov){
		this.idMovimiento = mov.getIdMovimiento();
		this.prenda = new Prenda(mov.getPrenda());
		this.tipo = mov.getTipo();
		this.cantidad = mov.getCantidad();
		this.cliente = new Cliente(mov.getCliente());
		this.pedido = new PedidoCliente(mov.getPedido());
		if (mov.getOrden().esParcial())
			this.orden = new Opp (mov.getOrden());
		else
			this.orden = new Opc(mov.getOrden());	
	}
	private int idMovimiento;
	private Prenda prenda;	
	private String tipo;
	private int cantidad;
	private Cliente cliente;
	private PedidoCliente pedido;
	private OrdenProduccion orden;	
	
	public int getIdMovimiento() {
		return idMovimiento;
	}
	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	public Prenda getPrenda() {
		return prenda;
	}
	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public PedidoCliente getPedido() {
		return pedido;
	}
	public void setPedido(PedidoCliente pedido) {
		this.pedido = pedido;
	}
	public OrdenProduccion getOrden() {
		return orden;
	}
	public void setOrden(OrdenProduccion orden) {
		this.orden = orden;
	}
	
	
	
}
