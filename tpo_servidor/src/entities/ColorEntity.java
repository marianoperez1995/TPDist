package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Colores")
public class ColorEntity implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 52014772077496691L;
	public ColorEntity(int idColor, String nombre) {
		super();
		this.idColor = idColor;
		this.nombre = nombre;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idColor;
	private String nombre;
	
	public ColorEntity(){
		
	}

	public int getIdColor() {
		return idColor;
	}

	public void setIdColor(int idColor) {
		this.idColor = idColor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}

