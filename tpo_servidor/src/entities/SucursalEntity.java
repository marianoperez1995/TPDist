package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Sucursales")
public class SucursalEntity  implements Serializable {

	public SucursalEntity() {
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 7496131640808344621L;
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idSucursal")
	private int numero;
	private String nombre;
	@Column(name="direccion")
	private String ubicacion;
	private String horarios; //08:00-23:00

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getHorarios() {
		return horarios;
	}

	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}

}
