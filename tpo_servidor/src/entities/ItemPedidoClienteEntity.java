package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="ItemPedidoCliente")
public class ItemPedidoClienteEntity  implements Serializable {

	private static final long serialVersionUID = -1772382243581354090L;


	public ItemPedidoClienteEntity() {
		// TODO Auto-generated constructor stub
	}

	@EmbeddedId
	private ItemPedidoClienteId id;
	public ItemPedidoClienteId getId() {
		return id;
	}

	public void setId(ItemPedidoClienteId id) {
		this.id = id;
	}

	private int cantidad;
	@Column(name="subtotal")
	private float precio;


	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	
}
