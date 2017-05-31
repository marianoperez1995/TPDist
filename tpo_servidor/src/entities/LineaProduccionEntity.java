package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LineasProduccion")
public class LineaProduccionEntity  implements Serializable {
	public LineaProduccionEntity(){
		
	}
	
	
	public LineaProduccionEntity(int idLinea, int capacidad, String estado, Date horaInicio, Date tiempoDeUso) {
		super();
		this.idLinea = idLinea;
		this.capacidad = capacidad;
		this.estado = estado;
		this.horaInicio = horaInicio;
		this.tiempoDeUso = tiempoDeUso;
	}
	private static final long serialVersionUID = 2799091425324777583L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idLineaP")
	private int idLinea;
	
	private int capacidad;
	private String estado;
	
	@Column(name="horaInicio")
	private Date horaInicio;
	
	@Column(name="tiempoUso")
	private Date tiempoDeUso;
	
	
	
	
	
	
	
	public void lineaProduccion(int idL,int capa, String estado, Date horaI, Date tiempo){
		this.idLinea= idL;
		this.capacidad= capa;
		this.estado= estado;
		this.horaInicio= horaI;
		this.tiempoDeUso= tiempo;

		
	}
	
	
	
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
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
