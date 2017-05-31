package negocio;

import java.util.ArrayList;

import dto.AreaProduccionDTO;
import dto.LineaProduccionDTO;
import entities.AreaProduccionEntity;
import entities.LineaProduccionEntity;
import persistencia.AreaProduccionDAO;

public class AreaProduccion {
	private int idAreaProduccion;
	private String nombre;
	private ArrayList<LineaProduccion> lineasProduccion;
	
	public AreaProduccion(AreaProduccionDTO area) {
		this.nombre = area.getNombre();
		for (LineaProduccionDTO lp : area.getLineasProduccion()){
			this.lineasProduccion.add(new LineaProduccion(lp));
		}
	}
	
	public AreaProduccion(){
		
	}

	public AreaProduccion(AreaProduccionEntity area) {
		this.nombre = area.getNombre();
		for (LineaProduccionEntity lp : area.getLineas()){
			this.lineasProduccion.add(new LineaProduccion(lp));
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<LineaProduccion> getLineasProduccion() {
		return lineasProduccion;
	}

	public void setLineasProduccion(ArrayList<LineaProduccion> lineasProduccion) {
		this.lineasProduccion = lineasProduccion;
	}

	public int getIdAreaProduccion() {
		return idAreaProduccion;
	}

	public void setIdAreaProduccion(int idAreaProduccion) {
		this.idAreaProduccion = idAreaProduccion;
	}
	
	public void insertar() {
		AreaProduccionDAO.getInstancia().insert(this);		
	}

	public void borrar() {
		AreaProduccionDAO.getInstancia().eliminar(this.idAreaProduccion);
	}
	public AreaProduccionDTO toDTO(){
		AreaProduccionDTO area= new AreaProduccionDTO();
		area.setIdAreaProduccion(idAreaProduccion);
		area.setNombre(nombre);
		ArrayList <LineaProduccionDTO> lineasProduccion= new ArrayList<LineaProduccionDTO>();
		for (LineaProduccion li: this.lineasProduccion)
			lineasProduccion.add(li.toDTO());
		area.setLineasProduccion(lineasProduccion);
		return area;
	}

	public String toString() {
		return "AreaProduccion [idAreaProduccion=" + idAreaProduccion + ", nombre=" + nombre + ", lineasProduccion="
				+ lineasProduccion + "]";
	}
	
}
