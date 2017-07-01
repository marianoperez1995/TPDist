package negocio;

import dto.ItemOrdenProduccionDTO;
import entities.ItemOrdenProduccionEntity;

public class ItemOrdenProduccion {
	
	private OrdenProduccion orden;
	private Prenda prenda;
	private int cantidadPedida;
	private int cantidadRealizada;
	
	public ItemOrdenProduccion(ItemOrdenProduccionDTO item) {
		this.orden = new OrdenProduccion(item.getOrden());
		this.prenda = new Prenda(item.getPrenda());
		this.cantidadPedida = item.getCantidadPedida();
		this.cantidadRealizada = item.getCantidadRealizada();
	}
	
	public ItemOrdenProduccion(){
		
	}

	public ItemOrdenProduccion(ItemOrdenProduccionEntity item) {
		this.orden = new OrdenProduccion(item.getId().getOrden());
		this.prenda = new Prenda(item.getId().getPrenda());
		this.cantidadPedida = item.getCantidadPedida();
		this.cantidadRealizada = item.getCantidadRealizada();
	}
	
	public OrdenProduccion getOrden() {
		return orden;
	}
	public void setOrden(OrdenProduccion orden) {
		this.orden = orden;
	}
	public Prenda getPrenda() {
		return prenda;
	}
	public void setPrenda(Prenda prenda) {
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
	
	public ItemOrdenProduccionDTO toDTO(){
		ItemOrdenProduccionDTO item = new ItemOrdenProduccionDTO();
		item.setCantidadPedida(cantidadPedida);
		item.setCantidadRealizada(cantidadRealizada);
		item.setOrden(orden.toDTO());
		item.setPrenda(prenda.toDTO());
		return item;
	}
	
	
	
	
	
	
	
	
}
