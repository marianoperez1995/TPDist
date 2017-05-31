package negocio;

import java.util.Date;

import persistencia.OrdenProduccionDAO;

public abstract class OrdenProduccion {
	protected int idOrdenProduccion;
	protected Date fecha; 
	protected Prenda prenda;
	protected PedidoCliente pedidoCliente;
	protected String tipo;

	public void insertar() {
		OrdenProduccionDAO.getInstancia().insert(this);		
	}

	public void borrar() {
		OrdenProduccionDAO.getInstancia().eliminar(this.idOrdenProduccion);
	}
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean sosLaOrden(int codigo) {
		return (codigo == this.idOrdenProduccion);
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Prenda getPrenda() {
		return prenda;
	}

	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}

	public PedidoCliente getPedidoCliente() {
		return pedidoCliente;
	}

	public void setPedidoCliente(PedidoCliente pedidoCliente) {
		this.pedidoCliente = pedidoCliente;
	}

	public void setId (int codigo) {
		this.idOrdenProduccion = codigo;
	}

	public int getIdOrdenProduccion() {
		return idOrdenProduccion;
	}

	public void setIdOrdenProduccion(int idOrdenProduccion) {
		this.idOrdenProduccion = idOrdenProduccion;
	}
	
	
}
