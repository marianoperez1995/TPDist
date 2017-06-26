package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="ItemOrdenProduccion")
public class ItemOrdenProduccionEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private ItemOrdenProduccionID id;
	private int cantidadPedida;
	private int cantidadRealizada;
	public int getCantidadPedida() {
		return cantidadPedida;
	}
	public void setCantidadPedida(int cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
	}
	public int getCantidadRealizada() {
		return cantidadRealizada;
	}
	public void setCantidadRealizada(int cantidadRealizada) {
		this.cantidadRealizada = cantidadRealizada;
	}
	public ItemOrdenProduccionID getId() {
		return id;
	}
	public void setId(ItemOrdenProduccionID id) {
		this.id = id;
	}
	
}
