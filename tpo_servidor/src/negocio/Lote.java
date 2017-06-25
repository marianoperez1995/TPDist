package negocio;

import java.util.ArrayList;

import dto.BultoDTO;
import dto.LoteDTO;
import entities.LoteEntity;
import persistencia.LoteDAO;

public class Lote {
	
	private int idLote;
	private ArrayList<Bulto> bultos;
	private int cantidadTotal;
	private OrdenProduccion orden;

	public boolean sosElLote(int codigo) {
		return this.idLote == codigo;
	}

	public Lote(LoteDTO lote ) {
		
		this.idLote = lote.getCodigo();
		this.bultos = new ArrayList<Bulto>();
		this.orden = new OrdenProduccion(lote.getOrden());
		this.cantidadTotal = lote.getCantidadTotal();
	
	}
	public Lote(LoteEntity lote ) {
		this.idLote = lote.getCodigo();
		this.bultos = new ArrayList<Bulto>();
		this.cantidadTotal = lote.getCantidadTotal();
		this.orden = new OrdenProduccion(lote.getOrden());	
	}
	public Lote() {
		// TODO Auto-generated constructor stub
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
		lote.setOrden(orden.toDTO());
		return lote;
	}

	
	
	
}
