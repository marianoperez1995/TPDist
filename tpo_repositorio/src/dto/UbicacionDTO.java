package dto;

import java.io.Serializable;

public class UbicacionDTO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9131810978389884362L;
	protected String codigo;
	protected boolean ocupado;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

}
