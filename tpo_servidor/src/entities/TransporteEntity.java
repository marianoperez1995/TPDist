package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Transportes")
public class TransporteEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 161990821611078476L;
	public TransporteEntity(int idTransporte, String descripcion) {
		super();
		this.idTransporte = idTransporte;
		this.descripcion = descripcion;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
