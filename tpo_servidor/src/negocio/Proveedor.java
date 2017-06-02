package negocio;

import dto.ProveedorDTO;
import entities.ProveedorEntity;
import persistencia.ProveedorDAO;

public class Proveedor {
	private int idProveedor;
	private String nombre;
	private String cuit;

		
	public Proveedor(ProveedorDTO proveedor) {
		this.nombre = proveedor.getNombre();
		this.cuit = proveedor.getCuit();
		this.idProveedor = proveedor.getidProveedor();
	
	}

	public Proveedor(ProveedorEntity proveedor) {
		this.nombre = proveedor.getNombre();
		this.cuit = proveedor.getCuit();
		this.idProveedor = proveedor.getIdProveedor();
	
	}
	public Proveedor() {
		// TODO Auto-generated constructor stub
	}

	public void insertar() {
		ProveedorDAO.getInstancia().insert(this);		
	}

	public void borrar() {
		ProveedorDAO.getInstancia().eliminar(this.idProveedor);
	}
	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	
}
