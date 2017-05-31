package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empleados")
public class EmpleadoEntity implements Serializable  {
	/**
	 * 
	 */
	public EmpleadoEntity(){
	}

	private static final long serialVersionUID = 7960002235704401682L;
	@Id
	@Column(name="idempleado")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTrabajador;
	private String nombre;
	private String tipo;
	
	//Por como esta en la BD: un empleado puede estar en muchas sucursales, y muchas sucursales mucohs empleados
	@ManyToOne
	@JoinColumn (name="idSucursal")
	private SucursalEntity sucursal;

	private String usuario;
	private String pass;
	private int permisos;
	
	
	
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getPermisos() {
		return permisos;
	}

	public void setPermisos(int permisos) {
		this.permisos = permisos;
	}

	public SucursalEntity getSucursal() {
		return sucursal;
	}

	public void setSucursales(SucursalEntity sucursales) {
		this.sucursal = sucursales;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getIdTrabajador() {
		return idTrabajador;
	}

	public void setIdTrabajador(int idTrabajador) {
		this.idTrabajador = idTrabajador;
	}

	
	
}
