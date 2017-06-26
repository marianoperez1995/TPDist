package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Insumos")
public class InsumoEntity implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3454179299445920384L;

	public InsumoEntity(){
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idInsumo")
	private int codigo;
	private String nombre;
	@Column(name="stock")
	private float stockActual;
	@Column(name="precio")
	private float precioFinal;
	@Column(name="stockMin")
	private float stockMinimo;
	private String unidad;
	private float cantAComprar;	
	private Date fechaRecepcion;	

	/*
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinTable(name = "Lote_Insumo", joinColumns = {
	@JoinColumn(name = "idInsumo") }, inverseJoinColumns = { @JoinColumn(name = "idLote") })
	private List<LoteEntity> lotes;
*/

	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public float getStockActual() {
		return stockActual;
	}


	public void setStockActual(float stockActual) {
		this.stockActual = stockActual;
	}


	public float getPrecioFinal() {
		return precioFinal;
	}


	public void setPrecioFinal(float precioFinal) {
		this.precioFinal = precioFinal;
	}


	public float getStockMinimo() {
		return stockMinimo;
	}


	public void setStockMinimo(float stockMinimo) {
		this.stockMinimo = stockMinimo;
	}


	public String getUnidad() {
		return unidad;
	}


	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}


	public float getCantAComprar() {
		return cantAComprar;
	}


	public void setCantAComprar(float cantAComprar) {
		this.cantAComprar = cantAComprar;
	}


	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}


	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}
	
}
