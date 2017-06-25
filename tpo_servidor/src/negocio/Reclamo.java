package negocio;

import java.util.Date;

import dto.ReclamoDTO;
import entities.ReclamosEntity;
import persistencia.ClienteDAO;
import persistencia.ReclamoDAO;

public class Reclamo {

	private int idReclamo;	
	private Cliente cliente;	
	private Date fechaReclamo;
	private String reclamo;
		
	public Reclamo(ReclamosEntity rec) {
		super();
		this.idReclamo = rec.getIdReclamo();
		this.cliente = new Cliente(rec.getCliente());
		this.fechaReclamo = rec.getFechaReclamo();
		this.reclamo = rec.getReclamo();
	}
	
	
	public Reclamo(ReclamoDTO rec) {
		super();
		this.idReclamo = rec.getIdReclamo();
		this.cliente = new Cliente(rec.getCliente());
		this.fechaReclamo = rec.getFechaReclamo();
		this.reclamo = rec.getReclamo();
	}

	
	public int getIdReclamo() {
		return idReclamo;
	}
	public void setIdReclamo(int idReclamo) {
		this.idReclamo = idReclamo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getFechaReclamo() {
		return fechaReclamo;
	}
	public void setFechaReclamo(Date fechaReclamo) {
		this.fechaReclamo = fechaReclamo;
	}
	public String getReclamo() {
		return reclamo;
	}
	public void setReclamo(String reclamo) {
		this.reclamo = reclamo;
	}


	public void insertar() {
		ReclamoDAO.getInstancia().insert(this);
	}	
	
}
