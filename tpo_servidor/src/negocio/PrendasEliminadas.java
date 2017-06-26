package negocio;

import dto.PrendasEliminadasDTO;
import entities.PrendasEliminadasEntity;

public class PrendasEliminadas {
	private int idPrendaEliminada;
	private Prenda prenda;
	private Empleado empBaja;
	private Empleado gerente;	
	private String descripcion;
	
	public PrendasEliminadas(PrendasEliminadasEntity p) {
		this.idPrendaEliminada = p.getIdPrendaEliminada();
		this.prenda = new Prenda(p.getPrenda());
		this.empBaja = new Empleado(p.getEmpBaja());
		this.gerente = new Empleado(p.getGerente());
		this.descripcion = p.getDescripcion();
	}
	
	public PrendasEliminadas(PrendasEliminadasDTO p) {
		this.idPrendaEliminada = p.getIdPrendaEliminada();
		this.prenda = new Prenda(p.getPrenda());
		this.empBaja = new Empleado(p.getEmpBaja());
		this.gerente = new Empleado(p.getGerente());
		this.descripcion = p.getDescripcion();
	}
	public PrendasEliminadas() {
		// TODO Auto-generated constructor stub
	}

	public int getIdPrendaEliminada() {
		return idPrendaEliminada;
	}
	public void setIdPrendaEliminada(int idPrendaEliminada) {
		this.idPrendaEliminada = idPrendaEliminada;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Prenda getPrenda() {
		return prenda;
	}
	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}
	public Empleado getEmpBaja() {
		return empBaja;
	}
	public void setEmpBaja(Empleado empBaja) {
		this.empBaja = empBaja;
	}
	public Empleado getGerente() {
		return gerente;
	}
	public void setGerente(Empleado gerente) {
		this.gerente = gerente;
	}

	
}
