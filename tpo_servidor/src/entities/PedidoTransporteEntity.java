package entities;
/*Esta clase la hago como una entity aparte
 * y no como un ManyToMany del lado de PedidoEntity o de TransporteEntity
 * porque la tabla se completa DESPUES de que el pedido ya exista, cuando se le marca como enviado 
 * 
 * Por eso llevan OneToOne (el mismo pedido no puede tener mas de un transporte en este caso),
 * y por eso no va como idtransporte en pedidocliente
 */

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Pedido_Transporte")
public class PedidoTransporteEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7823918334504373309L;

	@OneToOne
	@JoinColumn(name="idPedido")
	private PedidoClienteEntity pedido;
	@OneToOne
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
