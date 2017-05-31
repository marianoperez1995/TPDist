package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table (name="prenda_insumos")
public class ItemPrendaInsumoEntity  implements Serializable {

	private static final long serialVersionUID = -1050267689881274786L;

	@EmbeddedId
	private ItemPrendaInsumoID id;	
	private float cantidad;
	private float desperdicio;
	@Transient
	private InsumoEntity insumo; //esta en el id

	public ItemPrendaInsumoID getId() {
		return id;
	}

	public void setId(ItemPrendaInsumoID id) {
		this.id = id;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public float getDesperdicio() {
		return desperdicio;
	}

	public void setDesperdicio(float desperdicio) {
		this.desperdicio = desperdicio;
	}

	public InsumoEntity getInsumo() {
		// TODO Auto-generated method stub
		return insumo;
	}

	public void setInsumo(InsumoEntity insumo) {
		this.insumo = insumo;
	}

	
}
