package entities;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Embeddable
public class PedidoTransporteId {
	
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
