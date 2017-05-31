package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemPrendaAreaID implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3299182786768493263L;
	public ItemPrendaAreaID(PrendaEntity prenda, AreaProduccionEntity area) {
		super();
		this.prenda = prenda;
		this.area = area;
	}
	public ItemPrendaAreaID() {
		// TODO Auto-generated constructor stub
	}
	@ManyToOne
	@JoinColumn(name="idPrenda")
	private PrendaEntity prenda;
	@ManyToOne
	@JoinColumn(name="idAreaProduccion")
	private AreaProduccionEntity area;
	@ManyToOne
	@JoinColumn(name="idColor")
	private ColorEntity color;
	@ManyToOne
	@JoinColumn(name="idTalle")
	private TalleEntity talle;
	
	public PrendaEntity getPrenda() {
		return prenda;
	}
	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}
	public AreaProduccionEntity getArea() {
		return area;
	}
	public void setArea(AreaProduccionEntity area) {
		this.area = area;
	}

}
