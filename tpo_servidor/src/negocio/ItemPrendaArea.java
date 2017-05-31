package negocio;

import dto.ItemPrendaAreaDTO;
import entities.ItemPrendaAreaEntity;
import persistencia.ItemPrendaAreaDAO;

public class ItemPrendaArea {
	private int idItemPrendaArea;
	private int minutoEnArea;
	private AreaProduccion area;
	private Prenda prenda;
	
	public ItemPrendaArea(ItemPrendaAreaDTO ipaDTO) {
		this.minutoEnArea = ipaDTO.getMinutoEnArea();
		this.area = new AreaProduccion (ipaDTO.getArea());
	}

	public ItemPrendaArea(ItemPrendaAreaEntity ipae) {
		this.minutoEnArea = ipae.getMinutosEnArea();
		this.area = new AreaProduccion (ipae.getId().getArea());
	}

	public void insertar() {
		ItemPrendaAreaDAO.getInstancia().insert(this);		
	}

	public void borrar() {
		ItemPrendaAreaDAO.getInstancia().eliminar(this.idItemPrendaArea);
	}

	public int getIdItemPrendaArea() {
		return idItemPrendaArea;
	}

	public void setIdItemPrendaArea(int idItemPrendaArea) {
		this.idItemPrendaArea = idItemPrendaArea;
	}

	public int getMinutoEnArea() {
		return minutoEnArea;
	}

	public void setMinutoEnArea(int minutoEnArea) {
		this.minutoEnArea = minutoEnArea;
	}

	public AreaProduccion getArea() {
		return area;
	}

	public void setArea(AreaProduccion area) {
		this.area = area;
	}

	public Prenda getPrenda() {
		return prenda;
	}

	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}
	
	
}
