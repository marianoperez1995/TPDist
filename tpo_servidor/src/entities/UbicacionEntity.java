package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ubicaciones")
public class UbicacionEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2058784068435106745L;
	@Id	
	private String codigo;
	private String estado;
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
