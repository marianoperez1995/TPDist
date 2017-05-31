package views;

import java.util.Date;

public class LineaProduccionView {
	private int capacidad;
	private String estado;
	private Date horaInicio;
	private Date tiempoDeUso;
	
	public int getCapacidad() {
		return capacidad;
	}
	public String getEstado() {
		return estado;
	}
	public Date getHoraInicio() {
		return horaInicio;
	}
	public Date getTiempoDeUso() {
		return tiempoDeUso;
	}
	
}
