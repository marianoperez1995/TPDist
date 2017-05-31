package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Talles")
public class TalleEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4806591763394778605L;
	public TalleEntity(int idTalle, String nombre) {
		super();
		this.idTalle = idTalle;
		this.nombre = nombre;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTalle;
	private String nombre;
	
	public int getIdTalle() {
		return idTalle;
	}
	public void setIdTalle(int idTalle) {
		this.idTalle = idTalle;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
