package dto;

import java.io.Serializable;

public class ItemPrendaInsumoDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2126535003076159548L;
	private InsumoDTO insumo;
	private float cantidad;
	private float desperdicio;

	public InsumoDTO getInsumo() {
		return insumo;
	}

	public void setInsumo(InsumoDTO insumo) {
		this.insumo = insumo;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public float getDesperdicio() {
		return desperdicio;
	}

	public void setDesperdicio(float desperdicio) {
		this.desperdicio = desperdicio;
	}
}
