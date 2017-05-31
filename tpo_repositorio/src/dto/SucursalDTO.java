package dto;

import java.io.Serializable;

public class SucursalDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -970597370560480094L;
	private int numero;
	private String nombre;
	private String ubicacion;
	private String horarios;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getHorarios() {
		return horarios;
	}

	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}

}
