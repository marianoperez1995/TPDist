package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemPrendaInsumoID implements Serializable{
	
	private static final long serialVersionUID = -5487732854071960069L;
	public ItemPrendaInsumoID(PrendaEntity prenda, InsumoEntity insumo) {
		super();
		this.prenda = prenda;
		this.insumo = insumo;
	}
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
	@JoinColumns({
		@JoinColumn(name = "idPrenda", referencedColumnName = "idPrenda"),
		@JoinColumn(name = "idColor", referencedColumnName = "idColor"),
		@JoinColumn(name = "idTalle", referencedColumnName = "idTalle") })
	private PrendaEntity prenda;
	@ManyToOne
	@JoinColumn(name="idInsumo")
	private InsumoEntity insumo;
	/*@ManyToOne
	@JoinColumn(name="idColor")
	private ColorEntity color;
	@ManyToOne
	@JoinColumn(name="idTalle")
	private TalleEntity talle;
	
	Si esta bien lo de PrendaEntity aca arriba, estas 2 no hacen falta
	*/
}
