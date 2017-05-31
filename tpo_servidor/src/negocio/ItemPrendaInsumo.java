package negocio;

import dto.ItemPrendaInsumoDTO;
import entities.ItemPrendaInsumoEntity;
import persistencia.ItemPrendaInsumoDAO;

public class ItemPrendaInsumo {
	private int idItemPrendaInsumo;
	private Insumo insumo;
	private float cantidad;
	private float desperdicio;
	
	public ItemPrendaInsumo(ItemPrendaInsumoDTO ipiDTO) {
		this.insumo = new Insumo(ipiDTO.getInsumo());
		this.cantidad = ipiDTO.getCantidad();
		this.desperdicio = ipiDTO.getDesperdicio();
	}

	public ItemPrendaInsumo(ItemPrendaInsumoEntity ipie) {
		this.insumo = new Insumo(ipie.getInsumo());
		this.cantidad = ipie.getCantidad();
		this.desperdicio = ipie.getDesperdicio();
	}

/*	public void insertar() {
		ItemPrendaInsumoDAO.getInstancia().insert(this);		
	}

	public void borrar() {
		ItemPrendaInsumoDAO.getInstancia().eliminar(this.idItemPrendaInsumo);
	}
*/	
	
	//NO EXISTEN INSERT NI DELETE EN ESTE DAO

	
	
	public int getIdItemPrendaInsumo() {
		return idItemPrendaInsumo;
	}

	public void setIdItemPrendaInsumo(int idItemPrendaInsumo) {
		this.idItemPrendaInsumo = idItemPrendaInsumo;
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

	public float getDesperdicio() {
		return desperdicio;
	}

	public void setDesperdicio(float desperdicio) {
		this.desperdicio = desperdicio;
	}
	
	
}
