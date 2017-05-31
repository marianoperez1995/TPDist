package dto;

import java.io.Serializable;

public class UbicacionBultoDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5662170106722998565L;
	private BultoDTO bulto;

	public BultoDTO getBulto() {
		return bulto;
	}

	public void setBulto(BultoDTO bulto) {
		this.bulto = bulto;
	}
}
