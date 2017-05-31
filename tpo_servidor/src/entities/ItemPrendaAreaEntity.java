package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Prenda_Areas")
public class ItemPrendaAreaEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7586234559367005579L;

	public ItemPrendaAreaEntity(ItemPrendaAreaID id, int minutosEnArea) {
		super();
		this.id = id;
		this.minutosEnArea = minutosEnArea;
	}

	@EmbeddedId
	private ItemPrendaAreaID id;
	
	private int minutosEnArea;
	@Transient
	private AreaProduccionEntity area;
	public ItemPrendaAreaID getId() {
		return id;
	}

	public void setId(ItemPrendaAreaID id) {
		this.id = id;
	}

	public int getMinutosEnArea() {
		return minutosEnArea;
	}

	public void setMinutosEnArea(int minutosEnArea) {
		this.minutosEnArea = minutosEnArea;
	}

	public AreaProduccionEntity getArea() {
		return area;
	}

	public void setArea(AreaProduccionEntity area) {
		this.area = area;
	}




	
}
