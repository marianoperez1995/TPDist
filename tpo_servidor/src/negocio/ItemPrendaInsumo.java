package negocio;

import dto.ItemPrendaInsumoDTO;
import entities.ItemPrendaInsumoEntity;
import persistencia.ItemPrendaInsumoDAO;

public class ItemPrendaInsumo {
	private Insumo insumo;
	private float cantidad;
	private float desperdicio;
	private Prenda prenda;
	
	
	public ItemPrendaInsumo(ItemPrendaInsumoDTO ipiDTO) {
		this.insumo = new Insumo(ipiDTO.getInsumo());
		this.cantidad = ipiDTO.getCantidad();
		this.desperdicio = ipiDTO.getDesperdicio();
		this.prenda = new Prenda(ipiDTO.getPrenda());
	}

	public ItemPrendaInsumo(ItemPrendaInsumoEntity ipie) {
		this.insumo = new Insumo(ipie.getId().getInsumo());
		this.cantidad = ipie.getCantidad();
		this.desperdicio = ipie.getDesperdicio();
		this.prenda = new Prenda(ipie.getId().getPrenda());
	}
	
	
	public ItemPrendaInsumo() {
		// TODO Auto-generated constructor stub
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

	public Prenda getPrenda() {
		return prenda;
	}

	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}

	public ItemPrendaInsumoDTO toDTO() {
		ItemPrendaInsumoDTO item = new ItemPrendaInsumoDTO();
		item.setCantidad(cantidad);
		item.setDesperdicio(desperdicio);
		item.setInsumo(insumo.toDTO());
		item.setPrenda(prenda.toDTO());
		return item;
	}

	public void insertar() {
		ItemPrendaInsumoDAO.getInstancia().insert(this);		
	}

	@Override
	public String toString() {
		return "ItemPrendaInsumo [insumo=" + insumo + ", cantidad=" + cantidad + ", desperdicio=" + desperdicio
				+ ", prenda=" + prenda + "]";
	}
	
	
}
