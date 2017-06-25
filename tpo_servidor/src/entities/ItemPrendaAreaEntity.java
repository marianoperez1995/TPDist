package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Prenda_Areas")
public class ItemPrendaAreaEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7586234559367005579L;

	public ItemPrendaAreaEntity() {
		// TODO Auto-generated constructor stub
	}

	@EmbeddedId
	private ItemPrendaAreaID id;	
	private int minutoEnArea;
	

	public ItemPrendaAreaID getId() {
		return id;
	}

	public void setId(ItemPrendaAreaID id) {
		this.id = id;
	}

	public int getMinutosEnArea() {
		return minutoEnArea;
	}

	public void setMinutosEnArea(int minutosEnArea) {
		this.minutoEnArea = minutosEnArea;
	}


	
}
