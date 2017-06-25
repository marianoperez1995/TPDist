package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Pedido_Transporte")
public class PedidoTransporteEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7823918334504373309L;

	@EmbeddedId
	private PedidoTransporteId id;

	public PedidoTransporteId getId() {
		return id;
	}
	/*Esta clase la hago como una entity aparte
	 * y no como un ManyToMany del lado de PedidoEntity o de TransporteEntity
	 * porque la tabla se completa DESPUES de que el pedido ya exista, cuando se le marca como enviado 
	 * 
	 * Por eso llevan OneToOne (el mismo pedido no puede tener mas de un transporte en este caso),
	 * y por eso no va como idtransporte en pedidocliente
	 */

	public void setId(PedidoTransporteId id) {
		this.id = id;
	}
	
}
	