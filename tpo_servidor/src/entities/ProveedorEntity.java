package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Proveedores")
public class ProveedorEntity  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2632246882637819460L;

	public ProveedorEntity(int idProveedor, String nombre, String cuit) {
		super();
		this.idProveedor = idProveedor;
		this.nombre = nombre;
		this.cuit = cuit;
	}
	public ProveedorEntity() {
		// TODO Auto-generated constructor stub
	}
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProveedor;
	private String nombre;
	private String cuit;
	


	public int getIdProveedor() {
		return idProveedor;
	}
	public void setidProveedor(int idProveedor) {
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
