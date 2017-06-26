package entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
	private String nombre;
	private String estado;
	private String telefono;
	private String encargado;
	private String telencargado;
	private String mailencargado;
	private String generoencargado;
	private Date fechaRegistro;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idSucursal", referencedColumnName = "idSucursal")
	private SucursalEntity sucursal;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)


	public String getMailencargado() {
		return mailencargado;
	}
	public void setMailencargado(String mailencargado) {
		this.mailencargado = mailencargado;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
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
	public String getMailEncargado() {
		return mailencargado;
	}
	public void setMailEncargado(String mailencargado) {
		this.mailencargado = mailencargado;
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
		if (pedidosCliente == null){
			pedidosCliente = new ArrayList<>();
			return pedidosCliente;
		}
		return pedidosCliente;
	}

	public void setPedidosCliente(List<PedidoClienteEntity> pedidosCliente) {
		this.pedidosCliente = pedidosCliente;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	
}