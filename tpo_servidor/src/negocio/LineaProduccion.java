package negocio;

import java.util.Date;

import dto.LineaProduccionDTO;
import entities.LineaProduccionEntity;
import persistencia.LineaProduccionDAO;

public class LineaProduccion {
	private int idLineaProduccion;
	private int capacidad;
	private boolean estado;
	private Date horaInicio;
	private float tiempoDeUso;
	
	public LineaProduccion(LineaProduccionDTO lp) {
		this.capacidad = lp.getCapacidad();
		this.estado = lp.isEstado();
		this.horaInicio = lp.getHoraInicio();
		this.tiempoDeUso = lp.getTiempoDeUso();
		this.idLineaProduccion = lp.getIdLineaProduccion();
	}

	public LineaProduccion(LineaProduccionEntity lp) {
		this.capacidad = lp.getCapacidad();
		this.estado = lp.isEstado();
		this.horaInicio = lp.getHoraInicio();
		this.tiempoDeUso = lp.getTiempoDeUso();
		this.idLineaProduccion = lp.getIdLinea();
	}
	

	public LineaProduccion() {
		// TODO Auto-generated constructor stub
	}

	public void insertar() {
		LineaProduccionDAO.getInstancia().insert(this);		
	}

	public void borrar() {
		LineaProduccionDAO.getInstancia().eliminar(this.idLineaProduccion);
	}

	@Override
	public String toString() {
		return "LineaProduccion [idLineaProduccion=" + idLineaProduccion + ", capacidad=" + capacidad + ", estado="
				+ estado + ", horaInicio=" + horaInicio + ", tiempoDeUso=" + tiempoDeUso + "]";
	}

	public int getIdLineaProduccion() {
		return idLineaProduccion;
	}

	public void setIdLineaProduccion(int idLineaProduccion) {
		this.idLineaProduccion = idLineaProduccion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public float getTiempoDeUso() {
		return tiempoDeUso;
	}

	public void setTiempoDeUso(float tiempoDeUso) {
		this.tiempoDeUso = tiempoDeUso;
	}

	public LineaProduccionDTO toDTO() {
		LineaProduccionDTO linea = new LineaProduccionDTO();
		linea.setCapacidad(this.capacidad);
		linea.setEstado(this.estado);
		linea.setHoraInicio(this.horaInicio);
		linea.setTiempoDeUso(this.tiempoDeUso);
		return linea;
	}
	
	
}
