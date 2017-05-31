package negocio;

import dto.MovimientoStockDTO;

public class MovimientoStockPrenda extends MovimientoStock {
	private int idMovimientoStock;
	private Prenda prenda;
	private int cantidad;
	
	public MovimientoStockPrenda(MovimientoStockDTO movDTO) {
		//de donde saco la Prenda, habria q hacer DTO para las clases que heredan tambien? o todo iria en MovimientoStockDTO (si es asi, tambien hay q hacerlo para opp,opc)
	}
	
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
