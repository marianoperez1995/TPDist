package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Pagos")
public class PagoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5851214294313615999L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPago;
	private float monto;
	@ManyToOne
	@JoinColumn(name="idCliente")
	private ClienteEntity cliente;
	private Date fechaPago;
	private float montoAnterior;
	
	public int getIdPago() {
		return idPago;
	}
	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public ClienteEntity getCliente() {
		return cliente;
	}
	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public float getMontoAnterior() {
		return this.montoAnterior;
	}
	public void setMontoAnterior(float montoAnterior2) {
		this.montoAnterior = montoAnterior2;
	}
	
	
	
	
	

}
