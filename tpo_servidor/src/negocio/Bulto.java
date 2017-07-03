package negocio;

import dto.BultoDTO;
import persistencia.BultoDAO;

public class Bulto {
	private int idBulto;
	private Prenda prenda;
	private int cantidad;
	private Ubicacion ubicacion;
	
	
	public int getIdBulto() {
		return idBulto;
	}

	public void setIdBulto(int idBulto) {
		this.idBulto = idBulto;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public void descontarStock(int cantidad) {
		this.cantidad = this.cantidad - cantidad;
		if (this.cantidad < 0){//q no sea negativo...
			cantidad = 0;
			System.out.println("Estas restando mas stock de lo que hay");
		}
		update();
	}

	public boolean sosElBulto(int codigo) {
		return this.idBulto == codigo;
	}

	public int getCodigoBulto() {
		return idBulto;
	}

	public void setCodigoBulto(int codigoBulto) {
		this.idBulto = codigoBulto;
	}

	public Prenda getPrenda() {
		return prenda;
	}

	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	
	public BultoDTO toDTO(){
		BultoDTO bul=  new BultoDTO();
		bul.setCantidad(this.cantidad);
		bul.setCodigoBulto(idBulto);
		bul.setPrenda(prenda.toDTO());
		bul.setUbicacion(ubicacion.toDTO());
		return bul;
	}

	public void insertar() {
		BultoDAO.getInstancia().insert(this);
	}
	public void update(){
		BultoDAO.getInstancia().update(this);
	}

	
}
