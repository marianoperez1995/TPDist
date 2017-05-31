package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="prenda_insumos")
public class ItemPedidoInsumoEntity  implements Serializable {

	private static final long serialVersionUID = -7316836328454494865L;

	public ItemPedidoInsumoEntity() {
	}
	
	@EmbeddedId
	private ItemPedidoInsumoID id;
	private int cantidad;
	
	public ItemPedidoInsumoID getId() {
		return id;
	}
	public void setId(ItemPedidoInsumoID id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
