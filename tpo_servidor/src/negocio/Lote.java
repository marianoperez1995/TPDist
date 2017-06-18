package negocio;

import java.util.ArrayList;

import dto.BultoDTO;
import dto.LoteDTO;
import entities.LoteEntity;
import persistencia.LoteDAO;

public class Lote {
	
	private int idLote;
	private ArrayList<Bulto> bultos;
	private String color;
	private String talle;
	private int cantidadTotal;
	private OrdenProduccion orden;

	public boolean sosElLote(int codigo) {
		return this.idLote == codigo;
	}

	public Lote(LoteDTO lote ) {
		
		this.idLote = lote.getCodigo();
		this.bultos = new ArrayList<Bulto>();
		this.color = lote.getColor();
		this.talle = lote.getTalle();
		this.cantidadTotal = lote.getCantidadTotal();
		if (lote.getOrden().esParcial())
			this.orden = new Opp (lote.getOrden());
		else
			this.orden = new Opc(lote.getOrden());		
		
	}
	public Lote(LoteEntity lote ) {
		this.idLote = lote.getCodigo();
		this.bultos = new ArrayList<Bulto>();
		this.cantidadTotal = lote.getCantidadTotal();
		if (lote.getOrden().esParcial())
			this.orden = new Opp (lote.getOrden());
		else
			this.orden = new Opc(lote.getOrden());		
	}
	public void insertar() {
		LoteDAO.getInstancia().insert(this);		
	}

	public void borrar() {
		LoteDAO.getInstancia().eliminar(this.idLote);
	}

	public int getIdLote() {
		return idLote;
	}

	public void setIdLote(int idLote) {
		this.idLote = idLote;
	}

	public ArrayList<Bulto> getBultos() {
		return bultos;
	}

	public void setBultos(ArrayList<Bulto> bultos) {
		this.bultos = bultos;
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

	public int getCantidadTotal() {
		return cantidadTotal;
	}

	public void setCantidadTotal(int cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}

	public OrdenProduccion getOrden() {
		return orden;
	}

	public void setOrden(OrdenProduccion orden) {
		this.orden = orden;
	}

	public LoteDTO toDTO() {
		LoteDTO lote = new LoteDTO();
		ArrayList<BultoDTO> bultos = new ArrayList<>();
		for (Bulto b : this.bultos){
			bultos.add(b.toDTO());
		}
		lote.setBultos(bultos);
		lote.setCantidadTotal(cantidadTotal);
		lote.setCodigo(this.idLote);
		lote.setColor(color);
	
		//FALTA MANEJAR ORDEN PARCIAL Y COMPLETA ACA ... 
		lote.setOrden(orden.toDTO());
		lote.setTalle(talle);
		return null;
	}

	
	
	
}
