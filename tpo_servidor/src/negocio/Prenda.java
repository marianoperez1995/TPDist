package negocio;

import java.util.ArrayList;

import persistencia.PrendaDAO;
import dto.ItemPrendaAreaDTO;
import dto.ItemPrendaInsumoDTO;
import dto.OpcDTO;
import dto.OppDTO;
import dto.PrendaDTO;
import entities.ItemPrendaAreaEntity;
import entities.ItemPrendaInsumoEntity;
import entities.PrendaEntity;

public class Prenda {
	private int idPrenda;
	private String descripcion;
	private ArrayList<String> coloresPosibles;
	private ArrayList<String> tallesPosibles;
	private OrdenProduccion ordenProduccion;
	private boolean estadoProduccion;
	private float costoProduccionReal;
	private float costoProduccionActual;
	private float porcentajeGanancia;
	private float precio;
	private ArrayList<ItemPrendaInsumo> itemsPrendaInsumo;
	public int cantidadAConfeccionar;
	private String color;
	private String talle;

	public String getTalle() {
		return talle;
	}


	public void setTalle(String talle) {
		this.talle = talle;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public Prenda(PrendaDTO preDTO) {
		this.idPrenda = preDTO.getCodigo();
		this.descripcion = preDTO.getDescripcion();
		this.tallesPosibles = new ArrayList<String>();
		for (String t : preDTO.getTallesPosibles()){
			this.tallesPosibles.add(t);
		}		
		this.coloresPosibles = new ArrayList<String>();
		for (String c : preDTO.getColoresPosibles()){
			this.coloresPosibles.add(c);
		}

		//REVISAR Q ESTE BIEN
		if (preDTO.getOrdenProduccion().esParcial())
			this.ordenProduccion = new Opp (preDTO.getOrdenProduccion());
		else
			this.ordenProduccion = new Opc(preDTO.getOrdenProduccion());		
		
		this.estadoProduccion = preDTO.getEstadoProduccion();
		this.costoProduccionReal = preDTO.getCostoProduccionReal();
		this.costoProduccionActual = preDTO.getCostoProduccionActual();
		this.porcentajeGanancia = preDTO.getPorcentajeGanancia();
		this.precio = preDTO.getPrecio();
		this.itemsPrendaArea = new ArrayList<ItemPrendaArea>();
		this.itemsPrendaInsumo = new ArrayList<ItemPrendaInsumo>();
		for (ItemPrendaInsumoDTO ipiDTO : preDTO.getItemsPrendaInsumo()){
			this.itemsPrendaInsumo.add(new ItemPrendaInsumo(ipiDTO));	
		}
		for (ItemPrendaAreaDTO ipaDTO : preDTO.getItemsPrendaArea()){
			this.itemsPrendaArea.add(new ItemPrendaArea(ipaDTO));	
		}
		this.cantidadAConfeccionar = preDTO.getCantidadAConfeccionar();
	}


	public Prenda(PrendaEntity p) {
		this.idPrenda = p.getId().getIdPrenda();
		this.descripcion = p.getDescripcion();
		this.tallesPosibles = new ArrayList<String>();
		for (String t : p.getTallesPosibles()){
			this.tallesPosibles.add(t);
		}		
		this.coloresPosibles = new ArrayList<String>();
		for (String c : p.getColoresPosibles()){
			this.coloresPosibles.add(c);
		}

		//REVISAR Q ESTE BIEN
		if (p.getOrdenProduccion().esParcial())
			this.ordenProduccion = new Opp (p.getOrdenProduccion());
		else
			this.ordenProduccion = new Opc(p.getOrdenProduccion());		
		
		this.estadoProduccion = p.getEstadoProduccion();
		this.costoProduccionReal = p.getCostoProduccionReal();
		this.costoProduccionActual = p.getCostoProduccionActual();
		this.porcentajeGanancia = p.getPorcentajeGanancia();
		this.precio = p.getPrecio();
		this.itemsPrendaArea = new ArrayList<ItemPrendaArea>();
		this.itemsPrendaInsumo = new ArrayList<ItemPrendaInsumo>();
		for (ItemPrendaInsumoEntity ipie : p.getItemsPrendaInsumo()){
			this.itemsPrendaInsumo.add(new ItemPrendaInsumo(ipie));	
		}
		for (ItemPrendaAreaEntity ipae : p.getItemsPrendaArea()){
			this.itemsPrendaArea.add(new ItemPrendaArea(ipae));	
		}
		this.cantidadAConfeccionar = p.getCantidadAConfeccionar();
	}

	
	public void insertar() {
		PrendaDAO.getInstancia().insert(this);		
	}

	public void borrar() {
		PrendaDAO.getInstancia().eliminar(this.idPrenda);
	}
	public boolean sosLaPrenda(int numero) {
		return (numero == this.idPrenda); 

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


	public OrdenProduccion getOrdenProduccion() {
		return ordenProduccion;
	}


	public void setOrdenProduccion(OrdenProduccion ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
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


	public ArrayList<ItemPrendaInsumo> getItemsPrendaInsumo() {
		return itemsPrendaInsumo;
	}


	public void setItemsPrendaInsumo(ArrayList<ItemPrendaInsumo> itemsPrendaInsumo) {
		this.itemsPrendaInsumo = itemsPrendaInsumo;
	}



	public int getCantidadAConfeccionar() {
		return cantidadAConfeccionar;
	}


	public void setCantidadAConfeccionar(int cantidadAConfeccionar) {
		this.cantidadAConfeccionar = cantidadAConfeccionar;
	}


	public void insert() {
		PrendaDAO.getInstancia().insert(this);
		
	}


	public PrendaDTO toDTO() {
		PrendaDTO prenda = new PrendaDTO();
		prenda.setCantidadAConfeccionar(cantidadAConfeccionar);
		prenda.setCodigo(idPrenda);
		prenda.setColoresPosibles(coloresPosibles);
		prenda.setColor(color);
		prenda.setTalle(talle);
		prenda.setCostoProduccionActual(costoProduccionActual);
		prenda.setCostoProduccionReal(costoProduccionReal);
		prenda.setDescripcion(descripcion);
		prenda.setEstadoProduccion(estadoProduccion);
		prenda.setPorcentajeGanancia(porcentajeGanancia);
		prenda.setPrecio(precio);
		prenda.setTallesPosibles(tallesPosibles);

		ArrayList<ItemPrendaInsumoDTO> itemsPI = new ArrayList<>();
		for (ItemPrendaInsumo i : itemsPrendaInsumo){
			itemsPI.add(i.toDTO());
		}
		prenda.setItemsPrendaInsumo(itemsPI);
		return prenda;
	}


	public String getColor() {
		return color;
	}


}
