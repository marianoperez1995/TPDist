package views;

import java.util.ArrayList;

import dto.SucursalDTO;

public class ClienteView {
	private int numeroCliente;
	private String direccion;
	private String cuit;
	private CuentaCorrienteView cuentaCorriente;
	private String nombre;
	private SucursalDTO sucursal;
	private ArrayList<PedidoClienteView> pedidosCliente;
	private String encargado;
	private int estado;
	public int getNumeroCliente() {
		return numeroCliente;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getCuit() {
		return cuit;
	}
	public CuentaCorrienteView getCuentaCorriente() {
		return cuentaCorriente;
	}
	public String getNombre() {
		return nombre;
	}
	public SucursalDTO getSucursal() {
		return sucursal;
	}
	public ArrayList<PedidoClienteView> getPedidosCliente() {
		return pedidosCliente;
	}
	public String getEncargado() {
		return encargado;
	}
	public int getEstado() {
		return estado;
	}
}
