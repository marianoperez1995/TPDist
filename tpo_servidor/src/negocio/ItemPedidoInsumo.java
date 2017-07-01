package negocio;

import dto.ItemPedidoInsumoDTO;
import entities.ItemPedidoInsumoEntity;

public class ItemPedidoInsumo {

	private Insumo insumo;
	private int cantidad;
	public ItemPedidoInsumo(ItemPedidoInsumoEntity i) {
		this.insumo = new Insumo(i.getId().getInsumo());
		this.cantidad = i.getCantidad();
	}

	public ItemPedidoInsumo(ItemPedidoInsumoDTO i) {
		this.insumo = new Insumo(i.getInsumo());
		this.cantidad = i.getCantidad();
	}

	public ItemPedidoInsumo() {
	
	}

	public Insumo getInsumo() {
		return insumo;
	}
	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
