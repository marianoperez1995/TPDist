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
	
	private static final long serialVersionUID = -5673640771964535118L;
	public ItemProveedorInsumoEntity(ItemProveedorInsumoID id, float precio) {
		super();
		this.id = id;
		this.precio = precio;
	}
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
