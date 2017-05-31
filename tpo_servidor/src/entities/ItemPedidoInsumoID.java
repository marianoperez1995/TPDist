package entities;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemPedidoInsumoID {

	@ManyToOne
	@JoinColumn(name="idInsumo")
	private InsumoEntity insumo;
	@ManyToOne
	@JoinColumn(name="idPedido")
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
