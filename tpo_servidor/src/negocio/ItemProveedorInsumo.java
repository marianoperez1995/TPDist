package negocio;

import dto.ItemListaPrecioDTO;
import entities.ItemProveedorInsumoEntity;
import persistencia.CuentaCorrienteDAO;

public class ItemProveedorInsumo {
	private int idItemListaPrecio;
	private Insumo insumo;
	private float precio;
	
	public ItemProveedorInsumo (ItemListaPrecioDTO ilDTO){		
		this.insumo = new Insumo(ilDTO.getInsumo());
		this.precio = ilDTO.getPrecio();
	}
	
	public ItemProveedorInsumo(ItemProveedorInsumoEntity i) {
		this.insumo = new Insumo(i.getId().getInsumo());
		this.precio = i.getPrecio();
	}
	
	//No esta el dao aun. habria que renombrar esta clase a ItemProveedorInsumo
	public void insertar() {
		ItemProveedorInsumoDAO.getInstancia().insert(this);		
	}

	public void borrar() {
		ItemProveedorInsumoDAO.getInstancia().eliminar(this.idItemListaPrecio);
	}

	
	
	
	
	

	public Insumo getInsumo() {
		return insumo;
	}
	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getIdItemListaPrecio() {
		return idItemListaPrecio;
	}

	public void setIdItemListaPrecio(int idItemListaPrecio) {
		this.idItemListaPrecio = idItemListaPrecio;
	}

}
