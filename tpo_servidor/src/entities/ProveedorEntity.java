package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Proveedores")
public class ProveedorEntity  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2632246882637819460L;

	public ProveedorEntity(int codigo, String nombre, String cuit) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cuit = cuit;
	}
	public ProveedorEntity() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@Column(name="idproveedor")
	private int codigo;
	private String nombre;
	private String cuit;
	
	@OneToMany
	@JoinColumn(name="idproveedor")	
	private List<ItemProveedorInsumoEntity> itemsProveedorInsumo;

	
	
	public List<ItemProveedorInsumoEntity> getItemsProveedorInsumo() {
		return itemsProveedorInsumo;
	}
	public void setItemsProveedorInsumo(List<ItemProveedorInsumoEntity> itemsProveedorInsumo) {
		this.itemsProveedorInsumo = itemsProveedorInsumo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
