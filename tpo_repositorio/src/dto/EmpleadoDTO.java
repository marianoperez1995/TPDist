package dto;

import java.io.Serializable;

public class EmpleadoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4927843098777661103L;
	private int idTrabajador;
	private String nombre;
	private String tipo;
	private String usuario;
	private String pass;
	private int permisos;
	private SucursalDTO sucursal;
	
	public String getNombre() {
		return nombre;
	}

	public int getIdTrabajador() {
		return idTrabajador;
	}

	public void setIdTrabajador(int idTrabajador) {
		this.idTrabajador = idTrabajador;
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

	public String getUsuario() {
		return usuario;
	}

	public String getPass() {
		// TODO Auto-generated method stub
		return pass;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setSucursal(SucursalDTO sucursal) {
		this.sucursal = sucursal;
	}

	public SucursalDTO getSucursal() {
		// TODO Auto-generated method stub
		return sucursal;
	}

	public void setPermisos(int permisos) {
		// TODO Auto-generated method stub
		this.permisos = permisos;
	}

	public int getPermisos() {
		return permisos;
	}
}
