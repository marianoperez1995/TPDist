package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class InsumoDTO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 298479185881036647L;
	private int codigo;
	private String nombre;
	private float stockActual;
	private float precioFinal;
	private float stockMinimo;
	private String unidad;
	private float cantAComprar;
	private Date fechaRecepcion;
	private ArrayList<LoteDTO> lotes; 
	
	public int getCodigo() {
		return codigo;
	}

	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public ArrayList<LoteDTO> getLotes() {
		return lotes;
	}

	public void setLotes(ArrayList<LoteDTO> lotes) {
		this.lotes = lotes;
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
}
