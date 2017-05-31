package negocio;

import java.util.Calendar;
import java.util.Date;

import dto.FacturaDTO;
import entities.FacturaEntity;
import persistencia.FacturaDAO;

public class Factura {
	private int idFactura;
	private float total;
	private float impuestos;
	private Date fechaGeneracion;
	private Cliente cliente;
	private PedidoCliente pedido;


	public Factura(FacturaDTO factDTO) {
		this.total = factDTO.getTotal();
		this.impuestos = factDTO.getImpuestos();
		this.fechaGeneracion = factDTO.getFechaGeneracion();
		this.cliente = new Cliente(factDTO.getCliente());
		this.idFactura = factDTO.getNumeroFact();
		this.pedido = new PedidoCliente(factDTO.getPedido());
	}
	public Factura(FacturaEntity fact) {
		this.total = fact.getTotal();
		this.impuestos = fact.getImpuestos();
		this.fechaGeneracion = fact.getFechaGeneracion();
		this.cliente = new Cliente(fact.getCliente());
		this.idFactura = fact.getNumeroFact();
		this.pedido = new PedidoCliente(fact.getPedido()); 
	}
	


	public Factura (PedidoCliente pedido){
		this.cliente = pedido.getCliente();
		
		Calendar cal = Calendar.getInstance();
		this.fechaGeneracion = cal.getTime();
		//falta el resto
	}
	
	public void insertar() {
		FacturaDAO.getInstancia().insert(this);		
	}

	public void borrar() {
		FacturaDAO.getInstancia().eliminar(this.idFactura);
	}

	
	public boolean sosLaFactura(int numero){
		return this.idFactura == numero;
	}
	
	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(float impuestos) {
		this.impuestos = impuestos;
	}

	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
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
	public int getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", total=" + total + ", impuestos=" + impuestos
				+ ", fechaGeneracion=" + fechaGeneracion + ", cliente=" + cliente + ", pedido=" + pedido + "]";
	}

	public FacturaDTO toDTO(){
		FacturaDTO fac= new FacturaDTO();
		fac.setCliente(cliente.toDTO());
		fac.setFechaGeneracion(fechaGeneracion);
		fac.setImpuestos(impuestos);
		fac.setNumeroFact(this.idFactura);
		fac.setPedido(pedido.toDTO(this));
		fac.setTotal(total);
		return fac;
	}
	

	

}
