package dto;

public class PrendasEliminadasDTO {
	private int idPrendaEliminada;
	private PrendaDTO prenda;
	private EmpleadoDTO empBaja;
	private String descripcion;
	private EmpleadoDTO gerente;	
	public int getIdPrendaEliminada() {
		return idPrendaEliminada;
	}
	public void setIdPrendaEliminada(int idPrendaEliminada) {
		this.idPrendaEliminada = idPrendaEliminada;
	}
	public PrendaDTO getPrenda() {
		return prenda;
	}
	public void setPrenda(PrendaDTO prenda) {
		this.prenda = prenda;
	}
	public EmpleadoDTO getEmpBaja() {
		return empBaja;
	}
	public void setEmpBaja(EmpleadoDTO empBaja) {
		this.empBaja = empBaja;
	}
	public EmpleadoDTO getGerente() {
		return gerente;
	}
	public void setGerente(EmpleadoDTO gerente) {
		this.gerente = gerente;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
