package negocio;

import dto.ClienteDTO;
import dto.CuentaCorrienteDTO;
import entities.CuentaCorrienteEntity;
import persistencia.CuentaCorrienteDAO;

public class CuentaCorriente {
	private int idCuentaCorriente;
	private String condiciones;
	private float limite;
	private float balanceActual;
	
	public CuentaCorriente (CuentaCorrienteDTO ctaDTO){
		this.condiciones = ctaDTO.getCondiciones();
		this.limite = ctaDTO.getLimite();
		this.balanceActual = ctaDTO.getBalanceActual();
	}

	public CuentaCorriente(CuentaCorrienteEntity cuentaCorriente) {
		this.condiciones = cuentaCorriente.getCondiciones();
		this.limite = cuentaCorriente.getLimite();
		this.balanceActual = cuentaCorriente.getBalanceActual();
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

	public int getIdCuentaCorriente() {
		return idCuentaCorriente;
	}

	public void setIdCuentaCorriente(int idCuentaCorriente) {
		this.idCuentaCorriente = idCuentaCorriente;
	}
	public void insertar() {
		CuentaCorrienteDAO.getInstancia().insert(this);		
	}

	public void borrar() {
		CuentaCorrienteDAO.getInstancia().eliminar(this.idCuentaCorriente);
	}

	public CuentaCorrienteDTO toDTO() {
		CuentaCorrienteDTO cu= new CuentaCorrienteDTO();
		cu.setBalanceActual(balanceActual);
		cu.setCondiciones(condiciones);
		cu.setLimite(limite);
		return cu;
	}

}
