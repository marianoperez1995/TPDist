package negocio;

public class UbicacionBulto extends Ubicacion {
	private int idUbicacionBulto;
	private Bulto bulto;

	public Bulto getBulto() {
		return bulto;
	}

	public void setBulto(Bulto bulto) {
		this.bulto = bulto;
	}

	public int getIdUbicacionBulto() {
		return idUbicacionBulto;
	}

	public void setIdUbicacionBulto(int idUbicacionBulto) {
		this.idUbicacionBulto = idUbicacionBulto;
	}
}
