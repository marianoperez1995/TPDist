package negocio;

import dto.ItemProveedorInsumoDTO;
import entities.ItemProveedorInsumoEntity;
import persistencia.ItemProveedorInsumoDAO;

public class ItemProveedorInsumo {

	private Insumo insumo;
	private float precio;
	private Proveedor prov;
	
	public ItemProveedorInsumo (ItemProveedorInsumoDTO ilDTO){		
		this.insumo = new Insumo(ilDTO.getInsumo());
		this.precio = ilDTO.getPrecio();
		this.prov = new Proveedor(ilDTO.getProv());
		
	}
	
	public ItemProveedorInsumo(ItemProveedorInsumoEntity i) {
		this.insumo = new Insumo(i.getId().getInsumo());
		this.precio = i.getPrecio();
		this.prov = new Proveedor(i.getId().getProveedor());
	}
	
	public ItemProveedorInsumo() {
		// TODO Auto-generated constructor stub
	}

	public void insertar() {
		ItemProveedorInsumoDAO.getInstancia().insert(this);		
	}

	public void borrar() {
		ItemProveedorInsumoDAO.getInstancia().eliminar(this.insumo,this.prov);
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

	public Proveedor getProv() {
		return prov;
	}

	public void setProv(Proveedor prov) {
		this.prov = prov;
	}

}
