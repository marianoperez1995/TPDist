package negocio;

public class ItemPedidoInsumo {
	private int idItemPedidoInsumo;
	private Insumo insumo;
	private float cantidad;
	public int getIdItemPedidoInsumo() {
		return idItemPedidoInsumo;
	}
	public void setIdItemPedidoInsumo(int idItemPedidoInsumo) {
		this.idItemPedidoInsumo = idItemPedidoInsumo;
	}
	public Insumo getInsumo() {
		return insumo;
	}
	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
