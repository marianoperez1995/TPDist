package dto;

import java.util.ArrayList;

public class DespachoDTO {
	private int idDespacho;
	private String descripcion;
	private ArrayList<PedidoClienteDTO> pedidosCliente;
	private ArrayList<TransporteDTO> transportes;
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
	public ArrayList<PedidoClienteDTO> getPedidosCliente() {
		return pedidosCliente;
	}
	public void setPedidosCliente(ArrayList<PedidoClienteDTO> pedidosCliente) {
		this.pedidosCliente = pedidosCliente;
	}
	public ArrayList<TransporteDTO> getTransportes() {
		return transportes;
	}
	public void setTransportes(ArrayList<TransporteDTO> transportes) {
		this.transportes = transportes;
	}
	
	
}
