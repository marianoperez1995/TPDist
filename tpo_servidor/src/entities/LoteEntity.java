package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="Lotes")
public class LoteEntity implements Serializable  {

	private static final long serialVersionUID = -7201609710700996847L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idLote")
	private int codigo;
	@ManyToOne
	@JoinColumn(name="idPrenda")
	private PrendaEntity prenda;
	@ManyToOne
	@JoinColumn(name="idColor")
	private ColorEntity color;
	@ManyToOne
	@JoinColumn(name="idTalle")
	private TalleEntity talle;
	@Column(name="cantidad")
	private int cantidadTotal;
	@OneToOne
	@JoinColumn(name="idOrden")
	private OrdenProduccionEntity orden;

	public PrendaEntity getPrenda() {
		return prenda;
	}

	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public int getCantidadTotal() {
		return cantidadTotal;
	}

	public void setCantidadTotal(int cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}

	public OrdenProduccionEntity getOrden() {
		return orden;
	}

	public void setOrden(OrdenProduccionEntity orden) {
		this.orden = orden;
	}
}
