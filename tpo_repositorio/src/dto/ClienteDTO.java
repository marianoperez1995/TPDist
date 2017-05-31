package dto;

import java.io.Serializable;
import java.util.ArrayList;

public class ClienteDTO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3704076832215638552L;
	private int numeroCliente;
	private String direccion;
	private String cuit;
	private CuentaCorrienteDTO cuentaCorriente;
	private String nombre;
	private SucursalDTO sucursal;
	private ArrayList<PedidoClienteDTO> pedidosCliente;
	private String encargado;
	private int estado;

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getNumeroCliente() {
		return numeroCliente;
	}

	public void setNumeroCliente(int numeroCliente) {
		this.numeroCliente = numeroCliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public CuentaCorrienteDTO getCuentaCorriente() {
		return cuentaCorriente;
	}

	public void setCuentaCorriente(CuentaCorrienteDTO cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public SucursalDTO getSucursal() {
		return sucursal;
	}

	public void setSucursal(SucursalDTO sucursal) {
		this.sucursal = sucursal;
	}

	public ArrayList<PedidoClienteDTO> getPedidosCliente() {
		return pedidosCliente;
	}

	public void setPedidosCliente(ArrayList<PedidoClienteDTO> pedidosCliente) {
		this.pedidosCliente = pedidosCliente;
	}

	public String getEncargado() {
		
		return encargado;
	}

	public int getEstado() {
		return estado;
	}
}
