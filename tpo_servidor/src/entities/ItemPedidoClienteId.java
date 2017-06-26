package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemPedidoClienteId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -997416914983250952L;
	@ManyToOne
	@JoinColumn(name="idPedidoCliente")	
	private PedidoClienteEntity pedido;
	@ManyToOne
	/*@JoinColumns(value = {
		@JoinColumn(name = "idPrenda", referencedColumnName = "idPrenda"),
		@JoinColumn(name = "idColor", referencedColumnName = "idColor"),
		@JoinColumn(name = "idTalle", referencedColumnName = "idTalle") })*/
	@JoinColumn(name = "idPrenda")
	private PrendaEntity prenda;
	
	
	public PedidoClienteEntity getPedido() {
		return pedido;
	}
	public void setPedido(PedidoClienteEntity pedido) {
		this.pedido = pedido;
	}
	public PrendaEntity getPrenda() {
		return prenda;
	}
	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}
	public ItemPedidoClienteId(PedidoClienteEntity pedido, PrendaEntity prenda) {
		super();
		this.pedido = pedido;
		this.prenda = prenda;
	}
	public ItemPedidoClienteId() {
	}	
}