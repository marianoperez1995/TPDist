package dto;

import java.io.Serializable;

public class ItemListaPrecioDTO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1968984687163455286L;
	private InsumoDTO insumo;
	private float precio;

	public InsumoDTO getInsumo() {
		return insumo;
	}

	public void setInsumo(InsumoDTO insumo) {
		this.insumo = insumo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
}
