package dto;

import java.io.Serializable;

public class CuentaCorrienteDTO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2429280232160790602L;
	private String condiciones;
	private float limite;
	private float balanceActual;
	private String fecha;
	private String estado;
	

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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
