package dto;

import java.io.Serializable;
import java.util.Date;

public class LoteInsumoDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2899635732975661512L;
	private Date fechaRecepcion;
	private ProveedorDTO proveedor;
	private float cantidad;
	private InsumoDTO insumo;
	private int codigoLoteInsumo;

	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public ProveedorDTO getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorDTO proveedor) {
		this.proveedor = proveedor;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public InsumoDTO getInsumo() {
		return insumo;
	}

	public void setInsumo(InsumoDTO insumo) {
		this.insumo = insumo;
	}

	public int getCodigoLoteInsumo() {
		return codigoLoteInsumo;
	}

	public void setCodigoLoteInsumo(int codigoLoteInsumo) {
		this.codigoLoteInsumo = codigoLoteInsumo;
	}
}
