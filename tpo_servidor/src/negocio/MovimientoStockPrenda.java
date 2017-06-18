package negocio;

import dto.MovimientoStockDTO;

public class MovimientoStockPrenda extends Movimientos {
	private int idMovimientoStock;
	private Prenda prenda;
	private int cantidad;
	

	public Prenda getPrenda() {
		return prenda;
	}
	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
