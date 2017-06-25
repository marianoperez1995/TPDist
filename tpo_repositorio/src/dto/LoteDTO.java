package dto;

import java.io.Serializable;
import java.util.ArrayList;

public class LoteDTO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 489962179061807939L;
	private ArrayList<BultoDTO> bultos;
	private int codigo;
	private int cantidadTotal;
	private OrdenProduccionDTO orden;

	public ArrayList<BultoDTO> getBultos() {
		return bultos;
	}

	public void setBultos(ArrayList<BultoDTO> bultos) {
		this.bultos = bultos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCantidadTotal() {
		return cantidadTotal;
	}

	public void setCantidadTotal(int cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}

	public OrdenProduccionDTO getOrden() {
		return orden;
	}

	public void setOrden(OrdenProduccionDTO orden) {
		this.orden = orden;
	}
}
