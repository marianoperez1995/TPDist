package dto;

import java.io.Serializable;
import java.util.Date;

public class ReclamoDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2637465945419969292L;
	private int idReclamo;	
	private ClienteDTO cliente;	
	private Date fechaReclamo;
	private String reclamo;
	
	public int getIdReclamo() {
		return idReclamo;
	}
	public void setIdReclamo(int idReclamo) {
		this.idReclamo = idReclamo;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public Date getFechaReclamo() {
		return fechaReclamo;
	}
	public void setFechaReclamo(Date fechaReclamo) {
		this.fechaReclamo = fechaReclamo;
	}
	public String getReclamo() {
		return reclamo;
	}
	public void setReclamo(String reclamo) {
		this.reclamo = reclamo;
	}
}
