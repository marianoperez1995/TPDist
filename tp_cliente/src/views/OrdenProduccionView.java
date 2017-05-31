package views;

import java.util.Date;

public class OrdenProduccionView {
	protected Date fecha;
	protected PrendaView prenda;
	protected PedidoClienteView pedidoCliente;
	protected int codigo;
	protected String tipo;
	
	public Date getFecha() {
		return fecha;
	}
	public PrendaView getPrenda() {
		return prenda;
	}
	public PedidoClienteView getPedidoCliente() {
		return pedidoCliente;
	}
	public int getCodigo() {
		return codigo;
	}
	public String getTipo() {
		return tipo;
	}
	
	
}
