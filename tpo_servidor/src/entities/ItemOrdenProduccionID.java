package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemOrdenProduccionID implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name="idOrdenProduccion")
	private OrdenProduccionEntity orden;
	@ManyToOne
	@JoinColumn(name="idPrenda")
	private PrendaEntity prenda;
	public OrdenProduccionEntity getOrden() {
		return orden;
	}
	public void setOrden(OrdenProduccionEntity orden) {
		this.orden = orden;
	}
	public PrendaEntity getPrenda() {
		return prenda;
	}
	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}
}
