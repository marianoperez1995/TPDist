package dto;

import java.io.Serializable;

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
}
