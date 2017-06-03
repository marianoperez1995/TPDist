package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PrendaID  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8442301552396900624L;

	private int idPrenda;
	@ManyToOne
	@JoinColumn(name="idColor")
	private ColorEntity color;
	@ManyToOne
	@JoinColumn(name="idTalle")
	private TalleEntity talle;
	
	public int getIdPrenda() {
		return idPrenda;
	}
	public void setIdPrenda(int idPrenda) {
		this.idPrenda = idPrenda;
	}
	public ColorEntity getColor() {
		return color;
	}
	public void setColor(ColorEntity color) {
		this.color = color;
	}
	public TalleEntity getTalle() {
		return talle;
	}
	public void setTalle(TalleEntity talle) {
		this.talle = talle;
	}
	
	
	
}
