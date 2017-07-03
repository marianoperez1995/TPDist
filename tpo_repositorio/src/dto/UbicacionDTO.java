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

	public boolean isOcupado() {
		return estado.equalsIgnoreCase("Ocupado");
	}

	public void setOcupado() {
		this.estado = "Ocupado";
	}

	public void setEstado(String estado2) {
		this.estado = estado2;		
	}

}
