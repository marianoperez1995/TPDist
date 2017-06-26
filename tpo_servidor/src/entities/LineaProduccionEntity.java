package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="LineasProduccion")
public class LineaProduccionEntity  implements Serializable {
	public LineaProduccionEntity(){
		
	}
	

	private static final long serialVersionUID = 2799091425324777583L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idLineaProduccion")
	private int idLinea;
	
	private int capacidad;
	private boolean estado;
	
	@Column(name="horaInicio")
	private Date horaInicio;
	
	@Column(name="tiempoUso")
	private Date tiempoDeUso;
	
	@Transient
	private int idAreaProduccion;
	
	
	
	
	
	
	public int getIdAreaProduccion() {
		return idAreaProduccion;
	}
	public void setIdAreaProduccion(int idAreaProduccion) {
		this.idAreaProduccion = idAreaProduccion;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public Date getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Date getTiempoDeUso() {
		return tiempoDeUso;
	}
	public void setTiempoDeUso(Date tiempoDeUso) {
		this.tiempoDeUso = tiempoDeUso;
	}



	public int getIdLinea() {
		return idLinea;
	}



	public void setIdLinea(int idLinea) {
		this.idLinea = idLinea;
	}
	
}
