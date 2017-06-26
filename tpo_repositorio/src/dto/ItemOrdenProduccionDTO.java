package dto;
import java.io.Serializable;

public class ItemOrdenProduccionDTO implements Serializable{
	
	private OrdenProduccionDTO orden;
	private PrendaDTO prenda;
	private int cantidadPedida;
	private int cantidadRealizada;
	public OrdenProduccionDTO getOrden() {
		return orden;
	}
	public void setOrden(OrdenProduccionDTO orden) {
		this.orden = orden;
	}
	public PrendaDTO getPrenda() {
		return prenda;
	}
	public void setPrenda(PrendaDTO prenda) {
		this.prenda = prenda;
	}
	public int getCantidadPedida() {
		return cantidadPedida;
	}
	public void setCantidadPedida(int cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
	}
	public int getCantidadRealizada() {
		return cantidadRealizada;
	}
	public void setCantidadRealizada(int cantidadRealizada) {
		this.cantidadRealizada = cantidadRealizada;
	}
	
}
