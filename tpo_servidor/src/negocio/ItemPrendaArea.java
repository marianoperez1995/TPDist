package negocio;

import dto.ItemPrendaAreaDTO;
import dto.PrendaDTO;
import entities.ItemPrendaAreaEntity;
import persistencia.ItemPrendaAreaDAO;

public class ItemPrendaArea {
	private int minutoEnArea;
	private AreaProduccion area;
	private Prenda prenda;
	
	public ItemPrendaArea(ItemPrendaAreaDTO ipaDTO) {
		this.minutoEnArea = ipaDTO.getMinutoEnArea();
		this.area = new AreaProduccion (ipaDTO.getArea());
		this.prenda = new Prenda(ipaDTO.getPrenda());	
	}
/*
	public ItemPrendaArea(ItemPrendaAreaEntity ipae) {
		this.minutoEnArea = ipae.getMinutosEnArea();
		this.area = new AreaProduccion (ipae.getId().getArea());
	}*/

	public ItemPrendaArea(ItemPrendaAreaEntity item) {
		this.minutoEnArea = item.getMinutosEnArea();
		this.area = new AreaProduccion (item.getId().getArea());
		this.prenda = new Prenda(item.getId().getPrenda());	
	}

	@Override
	public String toString() {
		return "ItemPrendaArea [minutoEnArea=" + minutoEnArea + ", area=" + area + ", prenda=" + prenda + "]";
	}

	public void insertar() {
		ItemPrendaAreaDAO.getInstancia().insert(this);		
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

	public ItemPrendaAreaDTO toDTO(PrendaDTO p) {
		ItemPrendaAreaDTO item = new ItemPrendaAreaDTO();
		item.setArea(area.toDTO());
		item.setMinutoEnArea(minutoEnArea);
		item.setPrenda(p);
		return item;
	}
	
	
}
