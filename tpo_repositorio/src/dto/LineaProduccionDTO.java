package dto;

import java.io.Serializable;
import java.util.Date;

public class LineaProduccionDTO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8256966268586588895L;
	
	private int idLineaProduccion;
	private int capacidad;
	private boolean estado;
	private Date horaInicio;
	private Date tiempoDeUso;

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getIdLineaProduccion() {
		return idLineaProduccion;
	}

	public void setIdLineaProduccion(int idLineaProduccion) {
		this.idLineaProduccion = idLineaProduccion;
	}
}
