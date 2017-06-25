package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Embeddable
public class PedidoTransporteId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8657171778525511751L;
	@ManyToOne
	@JoinColumn(name="idPedido")
	private PedidoClienteEntity pedido;
	@ManyToOne
	@JoinColumn(name="idTransporte")
	private TransporteEntity transporte;
	
	
	public PedidoClienteEntity getPedido() {
		return pedido;
	}
	public void setPedido(PedidoClienteEntity pedido) {
		this.pedido = pedido;
	}
	public TransporteEntity getTransporte() {
		return transporte;
	}
	public void setTransporte(TransporteEntity transporte) {
		this.transporte = transporte;
	}
	
	
}
