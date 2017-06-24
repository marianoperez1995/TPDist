package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="Proveedor_Insumos")
public class ItemProveedorInsumoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7699953091200226538L;
	public ItemProveedorInsumoEntity() {
		// TODO Auto-generated constructor stub
	}
	
	@EmbeddedId
	private ItemProveedorInsumoID id;
	private float precio;
	public ItemProveedorInsumoID getId() {
		return id;
	}
	public void setId(ItemProveedorInsumoID id) {
		this.id = id;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	
}
