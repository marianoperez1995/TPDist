package negocio;

import dto.CuentaCorrienteDTO;
import entities.CuentaCorrienteEntity;
import persistencia.CuentaCorrienteDAO;

public class CuentaCorriente {
	private int idCuentaCorriente;
	private String condiciones;
	private float limite;
	private float balanceActual;
	private String fecha;
	private String estado;
	
	@Override
	public String toString() {
		return "CuentaCorriente [idCuentaCorriente=" + idCuentaCorriente + ", condiciones=" + condiciones + ", limite="
				+ limite + ", balanceActual=" + balanceActual + ", fecha=" + fecha + ", estado=" + estado + "]";
	}

	public CuentaCorriente (CuentaCorrienteDTO ctaDTO){
		this.idCuentaCorriente = ctaDTO.getIdCuentaCorriente();
		this.condiciones = ctaDTO.getCondiciones();
		this.limite = ctaDTO.getLimite();
		this.balanceActual = ctaDTO.getBalanceActual();
		this.fecha = ctaDTO.getFecha();
		this.estado= ctaDTO.getEstado();
	}

	public CuentaCorriente(CuentaCorrienteEntity cuentaCorriente) {
		this.condiciones = cuentaCorriente.getCondiciones();
		this.limite = cuentaCorriente.getLimite();
		this.balanceActual = cuentaCorriente.getBalanceActual();
		this.fecha = cuentaCorriente.getFecha();
		this.estado = cuentaCorriente.getEstado();
		this.idCuentaCorriente = cuentaCorriente.getNroCC();
	}

	public CuentaCorriente() {
		// TODO Auto-generated constructor stub
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

	public String getFechaPago() {
		return fecha;
	}

	public void setFechaPago(String fechaPago) {
		this.fecha = fechaPago;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getEstado() {
		// TODO Auto-generated method stub
		return estado;
	}

	public CuentaCorrienteDTO toDTO() {
		CuentaCorrienteDTO c = new CuentaCorrienteDTO();
		c.setIdCuentaCorriente(idCuentaCorriente);
		c.setBalanceActual(balanceActual);
		c.setCondiciones(condiciones);
		c.setEstado(estado);
		c.setFecha(fecha);
		c.setLimite(limite);
		return c;
	}

}
