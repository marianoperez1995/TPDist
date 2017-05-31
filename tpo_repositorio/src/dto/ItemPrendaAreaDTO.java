package dto;

import java.io.Serializable;

public class ItemPrendaAreaDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4515880041735649491L;
	private int minutoEnArea;
	private AreaProduccionDTO area;
	private PrendaDTO prenda;

	public int getMinutoEnArea() {
		return minutoEnArea;
	}

	public void setMinutoEnArea(int minutoEnArea) {
		this.minutoEnArea = minutoEnArea;
	}

	public AreaProduccionDTO getArea() {
		return area;
	}

	public void setArea(AreaProduccionDTO area) {
		this.area = area;
	}

	public PrendaDTO getPrenda() {
		return prenda;
	}

	public void setPrenda(PrendaDTO prenda) {
		this.prenda = prenda;
	}
}
