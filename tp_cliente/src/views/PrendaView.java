package views;

import java.util.ArrayList;

public class PrendaView {
	private int codigo;
	private String descripcion;
	private ArrayList<String> coloresPosibles;
	private ArrayList<String> tallesPosibles;
	private OrdenProduccionView ordenProduccion;
	private boolean estadoProduccion;
	private float costoProduccionReal;
	
	public int getCodigo() {
		return codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public ArrayList<String> getColoresPosibles() {
		return coloresPosibles;
	}
	public ArrayList<String> getTallesPosibles() {
		return tallesPosibles;
	}
	public OrdenProduccionView getOrdenProduccion() {
		return ordenProduccion;
	}
	public boolean isEstadoProduccion() {
		return estadoProduccion;
	}
	public float getCostoProduccionReal() {
		return costoProduccionReal;
	}
	public float getCostoProduccionActual() {
		return costoProduccionActual;
	}
	public float getPorcentajeGanancia() {
		return porcentajeGanancia;
	}
	public float getPrecio() {
		return precio;
	}
	public ArrayList<ItemPrendaInsumoView> getItemsPrendaInsumo() {
		return itemsPrendaInsumo;
	}
	public ArrayList<ItemPrendaAreaView> getItemsPrendaArea() {
		return itemsPrendaArea;
	}
	public int getCantidadAConfeccionar() {
		return cantidadAConfeccionar;
	}
	private float costoProduccionActual;
	private float porcentajeGanancia;
	private float precio;
	private ArrayList<ItemPrendaInsumoView> itemsPrendaInsumo;
	private ArrayList<ItemPrendaAreaView> itemsPrendaArea;
	public int cantidadAConfeccionar;
}
