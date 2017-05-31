package negocio;

import dto.TransporteDTO;
import entities.TransporteEntity;

public class Transporte {
	private int idTransporte;
	private String descripcion;

	
	public Transporte(TransporteDTO trans){
		this.idTransporte = trans.getIdTransporte();
		this.descripcion = trans.getDescripcion();
	}
	
	public Transporte(TransporteEntity trans){
		this.idTransporte = trans.getIdTransporte();
		this.descripcion = trans.getDescripcion();
	}
	public boolean sosElTranporte(int codigo) {
		return this.idTransporte == codigo;
	}

	public int getIdTransporte() {
		return idTransporte;
	}

	public void setIdTransporte(int idTransporte) {
		this.idTransporte = idTransporte;
	}


	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
