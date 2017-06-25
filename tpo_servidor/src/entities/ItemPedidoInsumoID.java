package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemPedidoInsumoID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3958971668144894302L;
	@ManyToOne
	@JoinColumn(name="idInsumo")
	private InsumoEntity insumo;
	@ManyToOne
	@JoinColumn(name="idPedidoInsumos")
	private PedidoInsumoEntity pedido;
	public InsumoEntity getInsumo() {
		return insumo;
	}
	public void setInsumo(InsumoEntity insumo) {
		this.insumo = insumo;
	}
	public PedidoInsumoEntity getPedido() {
		return pedido;
	}
	public void setPedido(PedidoInsumoEntity pedido) {
		this.pedido = pedido;
	}
	
	
}
