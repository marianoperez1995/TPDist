package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Prendas")
public class PrendaEntity  implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 400630920252981500L;

	public PrendaEntity() {		
	}


	@Id
	private int idPrenda;	
	private String color;
	private String talle;
	private String descripcion;
	private boolean estadoProduccion;
	@Column(name="costoProduccion")
	private float costoProduccionReal;
	private float costoProduccionActual;
	private float porcentajeGanancia;
	private float precio;
	private int cantidadAConfeccionar;
	private int stockMinimo;
	private int stockActual;
	
	
	public int getIdPrenda() {
		return idPrenda;
	}

	public void setIdPrenda(int idPrenda) {
		this.idPrenda = idPrenda;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	}

	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public int getStockActual() {
		return stockActual;
	}

	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}




	/*	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinTable(name = "Prenda_Areas", joinColumns = {
	@JoinColumn(name = "idPrenda") }, inverseJoinColumns = { @JoinColumn(name = "idAreaProduccion") })
	private List<AreaProduccionEntity> areas;
	//Falta manejar los minutoEnArea de prenda_areas
*/
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean getEstadoProduccion() {
		return estadoProduccion;
	}

	public void setEstadoProduccion(boolean estadoProduccion) {
		this.estadoProduccion = estadoProduccion;
	}

	public float getCostoProduccionReal() {
		return costoProduccionReal;
	}

	public void setCostoProduccionReal(float costoProduccionReal) {
		this.costoProduccionReal = costoProduccionReal;
	}

	public float getCostoProduccionActual() {
		return costoProduccionActual;
	}

	public void setCostoProduccionActual(float costoProduccionActual) {
		this.costoProduccionActual = costoProduccionActual;
	}

	public float getPorcentajeGanancia() {
		return porcentajeGanancia;
	}

	public void setPorcentajeGanancia(float porcentajeGanancia) {
		this.porcentajeGanancia = porcentajeGanancia;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getCantidadAConfeccionar() {
		return cantidadAConfeccionar;
	}

	public void setCantidadAConfeccionar(int cantidadAConfeccionar) {
		this.cantidadAConfeccionar = cantidadAConfeccionar;
	}

	
}
