package negocio;

public class UbicacionLoteInsumo extends Ubicacion {
	private int idUbicacionLoteInsumo;
	private LoteInsumo loteInsumo;

	public LoteInsumo getLoteInsumo() {
		return loteInsumo;
	}

	public void setLoteInsumo(LoteInsumo loteInsumo) {
		this.loteInsumo = loteInsumo;
	}

	public int getIdUbicacionLoteInsumo() {
		return idUbicacionLoteInsumo;
	}

	public void setIdUbicacionLoteInsumo(int idUbicacionLoteInsumo) {
		this.idUbicacionLoteInsumo = idUbicacionLoteInsumo;
	}

}
