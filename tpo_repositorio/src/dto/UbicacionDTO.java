package dto;

import java.io.Serializable;

public class UbicacionDTO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9131810978389884362L;
	protected String codigo;
	protected String estado;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}



}
