package entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import dto.FacturaDTO;
import negocio.CuentaCorriente;
import negocio.Factura;
import negocio.PedidoCliente;
import negocio.Sucursal;

@Entity
@Table(name = "Clientes")
public class ClienteEntity implements Serializable {

	/**
	 * 
	 */
	public ClienteEntity(){
		
	}

	private static final long serialVersionUID = -9014763503484345495L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCliente")
	private int numeroCliente;
	private String direccion;
	private String cuit;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idCCorriente", referencedColumnName = "idCuentaCorriente")
	private CuentaCorrienteEntity cuentaCorriente;
	//En Clientes esta como idCCorriente, en CuentasCorriente esta como idCuentaCorriente
	//revisar q sea asi
	private String nombre;
	private int estado;
	private String encargado;
	private String telencargado;
	private String mailenarcagado;
	private String generoencargado;
/*	private String categoria;
	@Column(name = "informacion")
	private String informacionAdicional;*/

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idSucursal", referencedColumnName = "idSucursal")
	private SucursalEntity sucursal;

	@OneToMany
	@JoinColumn(name = "idCliente")	
	private List<PedidoClienteEntity> pedidosCliente;


	
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getEncargado() {
		return encargado;
	}
	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}
	public String getTelencargado() {
		return telencargado;
	}
	public void setTelencargado(String telencargado) {
		this.telencargado = telencargado;
	}
	public String getMailenarcagado() {
		return mailenarcagado;
	}
	public void setMailenarcagado(String mailenarcagado) {
		this.mailenarcagado = mailenarcagado;
	}
	public String getGeneroencargado() {
		return generoencargado;
	}
	public void setGeneroencargado(String generoencargado) {
		this.generoencargado = generoencargado;
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

	public CuentaCorrienteEntity getCuentaCorriente() {
		return cuentaCorriente;
	}

	public void setCuentaCorriente(CuentaCorrienteEntity cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public SucursalEntity getSucursal() {
		return sucursal;
	}

	public void setSucursal(SucursalEntity sucursal) {
		this.sucursal = sucursal;
	}

	public List<PedidoClienteEntity> getPedidosCliente() {
		return pedidosCliente;
	}

	public void setPedidosCliente(List<PedidoClienteEntity> pedidosCliente) {
		this.pedidosCliente = pedidosCliente;
	}


	
	
}