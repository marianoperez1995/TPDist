package dto;

import java.io.Serializable;

public class MovimientoStockDTO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1537635857269333451L;
	protected int codigo;
	protected UbicacionDTO origen;
	protected String origenDetalle;
	protected UbicacionDTO destino;
	protected String destinoDetalle;
	protected String encargado;
	protected String autorizante;
	protected int cantidad;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public UbicacionDTO getOrigen() {
		return origen;
	}

	public void setOrigen(UbicacionDTO origen) {
		this.origen = origen;
	}

	public String getOrigenDetalle() {
		return origenDetalle;
	}

	public void setOrigenDetalle(String origenDetalle) {
		this.origenDetalle = origenDetalle;
	}

	public UbicacionDTO getDestino() {
		return destino;
	}

	public void setDestino(UbicacionDTO destino) {
		this.destino = destino;
	}

	public String getDestinoDetalle() {
		return destinoDetalle;
	}

	public void setDestinoDetalle(String destinoDetalle) {
		this.destinoDetalle = destinoDetalle;
	}

	public String getEncargado() {
		return encargado;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	public String getAutorizante() {
		return autorizante;
	}

	public void setAutorizante(String autorizante) {
		this.autorizante = autorizante;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
