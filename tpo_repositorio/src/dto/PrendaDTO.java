package dto;

import java.io.Serializable;
import java.util.ArrayList;

public class PrendaDTO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7691776848734044289L;
	private int idPrenda;
	private String descripcion;
	private boolean estadoProduccion;
	private float costoProduccionReal;
	private float costoProduccionActual;
	private float porcentajeGanancia;
	private float precio;
	private int cantidadAConfeccionar;
	private String color;
	private String talle;
	private int stockMinimo;
	private int stockActual;
	private ArrayList<ItemPrendaInsumoDTO> insumos;
	public ArrayList<ItemPrendaInsumoDTO> getInsumos() {
		return insumos;
	}
	public void setInsumos(ArrayList<ItemPrendaInsumoDTO> insumos) {
		this.insumos = insumos;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getIdPrenda() {
		return idPrenda;
	}
	public void setIdPrenda(int idPrenda) {
		this.idPrenda = idPrenda;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isEstadoProduccion() {
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
	@Override
	public String toString() {
		return "PrendaDTO [idPrenda=" + idPrenda + ", descripcion=" + descripcion + ", stockMinimo=" + stockMinimo + ", stockActual=" + stockActual+ ", costoProduccionReal=" + costoProduccionReal + ", costoProduccionActual="
				+ costoProduccionActual + ", porcentajeGanancia=" + porcentajeGanancia + ", precio=" + precio
				+ ", cantidadAConfeccionar=" + cantidadAConfeccionar + ", color=" + color + ", talle=" + talle
				+ ", estadoProduccion="	+ estadoProduccion  + "]";
	}
	
	
}