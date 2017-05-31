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

}
