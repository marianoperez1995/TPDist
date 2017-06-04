package negocio;

import java.util.ArrayList;

import dto.DespachoDTO;
import dto.PedidoClienteDTO;
import dto.TransporteDTO;
import entities.DespachoEntity;
import entities.PedidoClienteEntity;
import entities.TransporteEntity;

public class Despacho {

	private int idDespacho;
	private String descripcion;
	private ArrayList<PedidoCliente> pedidosCliente;
	private ArrayList<Transporte> transportes;
	public Despacho(DespachoDTO d) {
		this.idDespacho = d.getIdDespacho();
		this.descripcion = d.getDescripcion();
		for (PedidoClienteDTO p : d.getPedidosCliente()){
			this.pedidosCliente.add(new PedidoCliente(p));
		}
		for (TransporteDTO t : d.getTransportes()){
			this.transportes.add(new Transporte(t));
		}
	}
	public Despacho(DespachoEntity d) {
		this.idDespacho = d.getIdDespacho();
		this.descripcion = d.getDescripcion();
		for (PedidoClienteEntity p : d.getPedidosCliente()){
			this.pedidosCliente.add(new PedidoCliente(p));
		}
		for (TransporteEntity t : d.getTransportes()){
			this.transportes.add(new Transporte(t));
		}
	}
	public Despacho() {
		
	}
	public int getIdDespacho() {
		return idDespacho;
	}
	public void setIdDespacho(int idDespacho) {
		this.idDespacho = idDespacho;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public ArrayList<PedidoCliente> getPedidosCliente() {
		return pedidosCliente;
	}
	public void setPedidosCliente(ArrayList<PedidoCliente> pedidosCliente) {
		this.pedidosCliente = pedidosCliente;
	}
	public ArrayList<Transporte> getTransportes() {
		return transportes;
	}
	public void setTransportes(ArrayList<Transporte> transportes) {
		this.transportes = transportes;
	}
	
	
}
