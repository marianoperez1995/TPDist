package dto;

import java.io.Serializable;
import java.util.ArrayList;

public class PrendaDTO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7691776848734044289L;
	private int codigo;
	private String descripcion;
	private ArrayList<String> coloresPosibles;
	private ArrayList<String> tallesPosibles;
	private OrdenProduccionDTO ordenProduccion;
	private boolean estadoProduccion;
	private float costoProduccionReal;
	private float costoProduccionActual;
	private float porcentajeGanancia;
	private float precio;
	private ArrayList<ItemPrendaInsumoDTO> itemsPrendaInsumo;
	private ArrayList<ItemPrendaAreaDTO> itemsPrendaArea;
	public int cantidadAConfeccionar;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ArrayList<String> getColoresPosibles() {
		return coloresPosibles;
	}

	public void setColoresPosibles(ArrayList<String> coloresPosibles) {
		this.coloresPosibles = coloresPosibles;
	}

	public ArrayList<String> getTallesPosibles() {
		return tallesPosibles;
	}

	public void setTallesPosibles(ArrayList<String> tallesPosibles) {
		this.tallesPosibles = tallesPosibles;
	}

	public OrdenProduccionDTO getOrdenProduccion() {
		return ordenProduccion;
	}

	public void setOrdenProduccion(OrdenProduccionDTO ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
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

	public ArrayList<ItemPrendaInsumoDTO> getItemsPrendaInsumo() {
		return itemsPrendaInsumo;
	}

	public void setItemsPrendaInsumo(ArrayList<ItemPrendaInsumoDTO> itemsPrendaInsumo) {
		this.itemsPrendaInsumo = itemsPrendaInsumo;
	}

	public ArrayList<ItemPrendaAreaDTO> getItemsPrendaArea() {
		return itemsPrendaArea;
	}

	public void setItemsPrendaArea(ArrayList<ItemPrendaAreaDTO> itemsPrendaArea) {
		this.itemsPrendaArea = itemsPrendaArea;
	}

	public int getCantidadAConfeccionar() {
		return cantidadAConfeccionar;
	}

	public void setCantidadAConfeccionar(int cantidadAConfeccionar) {
		this.cantidadAConfeccionar = cantidadAConfeccionar;
	}
}
