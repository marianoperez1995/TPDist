package dto;

import java.io.Serializable;
import java.util.Date;

public class BultoDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6289361445190499341L;
	private int codigoBulto;
	private PrendaDTO prenda;
	private int cantidad;
	private Date fechaGen;
	private String ubicacion;
	
	public int getCodigoBulto() {
		return codigoBulto;
	}

	public void setCodigoBulto(int codigoBulto) {
		this.codigoBulto = codigoBulto;
	}

	public PrendaDTO getPrenda() {
		return prenda;
	}

	public void setPrenda(PrendaDTO prenda) {
		this.prenda = prenda;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechagen() {
		return fechaGen;
	}
	
	public String getUbicacion(){
		return ubicacion;
	}

}
