package negocio;

import java.util.Date;

import dto.LineaProduccionDTO;
import entities.LineaProduccionEntity;
import persistencia.LineaProduccionDAO;

public class LineaProduccion {
	private int idLineaProduccion;
	private int capacidad;
	private String estado;
	private Date horaInicio;
	private Date tiempoDeUso;
	
	public LineaProduccion(LineaProduccionDTO lp) {
		this.capacidad = lp.getCapacidad();
		this.estado = lp.getEstado();
		this.horaInicio = lp.getHoraInicio();
		this.tiempoDeUso = lp.getTiempoDeUso();
	}

	public LineaProduccion(LineaProduccionEntity lp) {
		this.capacidad = lp.getCapacidad();
		this.estado = lp.getEstado();
		this.horaInicio = lp.getHoraInicio();
		this.tiempoDeUso = lp.getTiempoDeUso();
	}

	public void insertar() {
		LineaProduccionDAO.getInstancia().insert(this);		
	}

	public void borrar() {
		LineaProduccionDAO.getInstancia().eliminar(this.idLineaProduccion);
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getTiempoDeUso() {
		return tiempoDeUso;
	}

	public void setTiempoDeUso(Date tiempoDeUso) {
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
