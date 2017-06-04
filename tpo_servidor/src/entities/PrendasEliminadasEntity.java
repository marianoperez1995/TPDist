package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Prendas_Eliminadas")
public class PrendasEliminadasEntity implements Serializable{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 6627435556176029864L;
	
	public PrendasEliminadasEntity() {	
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPrendaEliminada;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumns({
		@JoinColumn(name = "idPrenda", referencedColumnName = "idPrenda"),
		@JoinColumn(name = "idColor", referencedColumnName = "idColor"),
		@JoinColumn(name = "idTalle", referencedColumnName = "idTalle") })
	private PrendaEntity prenda;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="idEmpleadoBaja")
	private EmpleadoEntity empBaja;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="idGerente")
	private EmpleadoEntity gerente;
	
	private String descripcion;
	
	public int getIdPrendaEliminada() {
		return idPrendaEliminada;
	}
	public void setIdPrendaEliminada(int idPrendaEliminada) {
		this.idPrendaEliminada = idPrendaEliminada;
	}
	public PrendaEntity getPrenda() {
		return prenda;
	}
	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}
	public EmpleadoEntity getEmpBaja() {
		return empBaja;
	}
	public void setEmpBaja(EmpleadoEntity empBaja) {
		this.empBaja = empBaja;
	}
	public EmpleadoEntity getGerente() {
		return gerente;
	}
	public void setGerente(EmpleadoEntity gerente) {
		this.gerente = gerente;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
