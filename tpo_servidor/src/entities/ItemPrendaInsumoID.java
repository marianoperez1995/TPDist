package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemPrendaInsumoID implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1915632825516278930L;
	public ItemPrendaInsumoID() {
		// TODO Auto-generated constructor stub
	}
	public PrendaEntity getPrenda() {
		return prenda;
	}
	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}
	public InsumoEntity getInsumo() {
		return insumo;
	}
	public void setInsumo(InsumoEntity insumo) {
		this.insumo = insumo;
	}
	@ManyToOne
	@JoinColumn(name="idPrenda")
	private PrendaEntity prenda;
	@ManyToOne
	@JoinColumn(name="idInsumo")
	private InsumoEntity insumo;

}
