package dto;

import java.io.Serializable;

public class TransporteDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7034927210909770904L;
	private int idTransporte;
	private String descripcion;
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
