package negocio;

import java.util.Date;

import dto.OrdenProduccionDTO;
import entities.OrdenProduccionEntity;
import persistencia.OrdenProduccionDAO;

public  class OrdenProduccion {
	protected int idOrdenProduccion;
	protected Date fecha; 
	protected Prenda prenda;
	protected PedidoCliente pedidoCliente;
	protected int cantidad;
	protected String tipo; 

	public OrdenProduccion() {
		
	}
	

	public OrdenProduccion(OrdenProduccionEntity ordenEntity) {
		super();
		this.idOrdenProduccion = ordenEntity.getCodigo();
		this.fecha = ordenEntity.getFecha();
		this.prenda = new Prenda (ordenEntity.getPrenda());
		this.pedidoCliente = new PedidoCliente(ordenEntity.getPedidoCliente());
		this.cantidad = ordenEntity.getCantidad();
		this.tipo = ordenEntity.getTipo();
	}


	public OrdenProduccion(OrdenProduccionDTO orden) {
		this.idOrdenProduccion = orden.getCodigo();
		this.fecha = orden.getFecha();
		this.prenda = new Prenda (orden.getPrenda());
		this.pedidoCliente = new PedidoCliente(orden.getPedidoCliente());
		this.cantidad = orden.getCantidad();
		this.tipo = orden.getTipo();
	}


	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void insertar() {
		OrdenProduccionDAO.getInstancia().insert(this);		
	}

	public void borrar() {
		OrdenProduccionDAO.getInstancia().eliminar(this.idOrdenProduccion);
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

	public int getIdOrdenProduccion() {
		return idOrdenProduccion;
	}

	public void setIdOrdenProduccion(int idOrdenProduccion) {
		this.idOrdenProduccion = idOrdenProduccion;
	}

	public OrdenProduccionDTO toDTO() {
		//falta
		return null;
	}
	
}
