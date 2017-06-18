package negocio;

import dto.MovimientoStockDTO;

public class MovimientoStockInsumo extends Movimientos {
	private int idMovimientoStockInsumo;
	private LoteInsumo loteInsumo;
	private float cantidad;

	public LoteInsumo getLoteInsumo() {
		return loteInsumo;
	}
	public void setLoteInsumo(LoteInsumo loteInsumo) {
		this.loteInsumo = loteInsumo;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	

}
