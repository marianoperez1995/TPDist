package negocio;

import dto.EmpleadoDTO;
import entities.EmpleadoEntity;
import persistencia.CuentaCorrienteDAO;
import persistencia.EmpleadoDAO;

public class Empleado {
	private int idEmpleado;
	private String nombre;
	private String tipo;

	private String usuario;
	private String pass;
	private int permisos;
	

	public Empleado(){
		
	}
	public Empleado(EmpleadoDTO eDTO) {
		this.nombre = eDTO.getNombre();
		this.tipo = eDTO.getTipo();
		
		this.idEmpleado=eDTO.getIdTrabajador();
	}
	public Empleado(EmpleadoEntity emp) {
		this.nombre = emp.getNombre();
		this.tipo = emp.getTipo();
		this.pass= emp.getPass();
		this.permisos= emp.getPermisos();
		this.usuario= emp.getUsuario();
		this.idEmpleado = emp.getIdTrabajador();
	}
	public int getidEmpleado() {
		return idEmpleado;
	}
	public void setidEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
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
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

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
	public void insertar() {
		EmpleadoDAO.getInstancia().insert(this);		
	}

	public void borrar() {
		EmpleadoDAO.getInstancia().eliminar(this.idEmpleado);
	}

	
	
	
}
