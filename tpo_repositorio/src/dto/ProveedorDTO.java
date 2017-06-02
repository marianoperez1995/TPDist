package dto;

import java.io.Serializable;
import java.util.ArrayList;

public class ProveedorDTO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4982890337462866332L;
	private String nombre;
	private String cuit;
	private int idProveedor;

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


	public int getidProveedor() {
		return idProveedor;
	}

	public void setidProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

}
