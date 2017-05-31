package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CuentaCorriente")
public class CuentaCorrienteEntity implements Serializable {
	
	/**
	 * 
	 */
	public CuentaCorrienteEntity(){		
	}
	

	private static final long serialVersionUID = -6914846228491569530L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCuentaCorriente")
	private int nroCC;
	
	@Column(name="condicionesPago")
	private String condiciones;
	
	@Column(name="limite")
	private float limite;
	
	@Column(name="balanceActual")
	private float balanceActual;
	
	private String fecha;
	
	
	public int getNroCC() {
		return nroCC;
	}


	public void setNroCC(int nroCC) {
		this.nroCC = nroCC;
	}


	public String getCondiciones() {
		return condiciones;
	}


	public void setCondiciones(String condiciones) {
		this.condiciones = condiciones;
	}


	public float getLimite() {
		return limite;
	}


	public void setLimite(float limite) {
		this.limite = limite;
	}


	public float getBalanceActual() {
		return balanceActual;
	}


	public void setBalanceActual(float balanceActual) {
		this.balanceActual = balanceActual;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}
