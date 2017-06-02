package dto;

import java.io.Serializable;
import java.util.ArrayList;

public class ClienteDTO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -470766594240729993L;
	private int numeroCliente;
	private String direccion;
	private String cuit;
	private CuentaCorrienteDTO cuentaCorriente;
	private String nombre;
	private SucursalDTO sucursal;
	private ArrayList<PedidoClienteDTO> pedidosCliente;
	private String encargado;
	private String telefono;
	private String telEncargado;
	private String mailEncargado;
	private String generoEncargado;
	
	
	@Override
	public String toString() {
		return "ClienteDTO [numeroCliente=" + numeroCliente + ", direccion=" + direccion + ", cuit=" + cuit
				+ ", cuentaCorriente=" + cuentaCorriente + ", nombre=" + nombre + ", sucursal=" + sucursal
				+ ", pedidosCliente=" + pedidosCliente + ", encargado=" + encargado + ", telefono=" + telefono
				+ ", telEncargado=" + telEncargado + ", mailEncargado=" + mailEncargado + ", generoEncargado="
				+ generoEncargado + ", estado=" + estado + "]";
	}

	public String getTelEncargado() {
		return telEncargado;
	}

	public void setTelEncargado(String telEncargado) {
		this.telEncargado = telEncargado;
	}

	public String getMailEncargado() {
		return mailEncargado;
	}

	public void setMailEncargado(String mailEncargado) {
		this.mailEncargado = mailEncargado;
	}

	public String getGeneroEncargado() {
		return generoEncargado;
	}

	public void setGeneroEncargado(String generoEncargado) {
		this.generoEncargado = generoEncargado;
	}

	private String estado;

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	public void setEstado(String estado) {
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

	public String getEstado() {
		return estado;
	}

	public String getTelefono() {
		// TODO Auto-generated method stub
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
