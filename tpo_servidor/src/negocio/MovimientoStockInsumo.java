package negocio;

import dto.MovimientoStockDTO;

public class MovimientoStockInsumo extends MovimientoStock {
	private int idMovimientoStockInsumo;
	private LoteInsumo loteInsumo;
	private float cantidad;
	
	public MovimientoStockInsumo(MovimientoStockDTO movDTO) {
		//de donde saco el LoteInsumo, habria q hacer DTO para las clases que heredan tambien? o todo iria en MovimientoStockDTO (si es asi, tambien hay q hacerlo para opp,opc)
	}
	
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
