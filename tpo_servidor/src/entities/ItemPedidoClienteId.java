package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Embeddable
public class ItemPedidoClienteId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -997416914983250952L;
	@OneToOne
	@JoinColumn(name="idPedidoCliente")	
	private PedidoClienteEntity pedido;
	@ManyToOne
	@JoinColumn(name="idPrenda")
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
	
	//Asi o con columns?
	//tipo: 
	/*
	 * @Column(name="idPedidoCliente")
	 * private PedidoClienteEntity pedido;
	 * 
	 * seria en todas las ID que vengo haciendo...
	 */
	
	
	
}
