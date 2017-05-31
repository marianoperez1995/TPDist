package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="ItemPedidoCliente")
public class ItemPedidoClienteEntity  implements Serializable {

	private static final long serialVersionUID = -1772382243581354090L;
	
	public ItemPedidoClienteEntity(ItemPedidoClienteId id, ColorEntity color, TalleEntity talle, int cantidad,
			float precio) {
		super();
		this.id = id;
		this.color = color;
		this.talle = talle;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	@EmbeddedId
	private ItemPedidoClienteId id;
	@ManyToOne
	@JoinColumn(name="idColor")
	private ColorEntity color;
	@ManyToOne
	@JoinColumn(name="idTalle")
	private TalleEntity talle;
	private int cantidad;
	@Column(name="subtotal")
	private float precio;
	@Transient
	private PrendaEntity prenda;
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
	public ItemPedidoClienteId getId() {
		return id;
	}

	public void setId(ItemPedidoClienteId id) {
		this.id = id;
	}

	public ColorEntity getColor() {
		return color;
	}

	public void setColor(ColorEntity color) {
		this.color = color;
	}

	public TalleEntity getTalle() {
		return talle;
	}

	public void setTalle(TalleEntity talle) {
		this.talle = talle;
	}

	public PrendaEntity getPrenda() {
	
		return prenda;
	}
	public void setPrenda(PrendaEntity prenda){
		this.prenda = prenda;
	}

	
}
