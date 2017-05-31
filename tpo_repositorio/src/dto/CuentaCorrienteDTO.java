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
}
