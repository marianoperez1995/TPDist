package dto;

import java.io.Serializable;
import java.util.ArrayList;

//SFSDFDSFSDFS
public class AreaProduccionDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8380609790616961622L;
	private int idAreaProduccion;
	private String nombre;
	private ArrayList<LineaProduccionDTO> lineasProduccion;
	public int getIdAreaProduccion() {
		return idAreaProduccion;
	}
	public void setIdAreaProduccion(int idAreaProduccion) {
		this.idAreaProduccion = idAreaProduccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<LineaProduccionDTO> getLineasProduccion() {
		return lineasProduccion;
	}
	public void setLineasProduccion(ArrayList<LineaProduccionDTO> lineasProduccion) {
		this.lineasProduccion = lineasProduccion;
	}
	
}
