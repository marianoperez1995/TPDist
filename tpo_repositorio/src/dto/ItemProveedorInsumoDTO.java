package dto;
public class ItemProveedorInsumoDTO {

	private InsumoDTO insumo;
	private float precio;
	private ProveedorDTO prov;

	public InsumoDTO getInsumo() {
		return insumo;
	}
	public void setInsumo(InsumoDTO insumo) {
		this.insumo = insumo;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public ProveedorDTO getProv() {
		return prov;
	}
	public void setProv(ProveedorDTO prov) {
		this.prov = prov;
	}	
	
	

}
