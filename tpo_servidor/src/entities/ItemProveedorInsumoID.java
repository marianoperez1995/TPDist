package entities;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ItemProveedorInsumoID implements Serializable{


	private static final long serialVersionUID = -4617893078779176557L;
	@ManyToOne
	@JoinColumn(name="idproveedor")
	private ProveedorEntity proveedor;
	@ManyToOne
	@JoinColumn(name="idinsumo")
	private InsumoEntity insumo;
	public ProveedorEntity getProveedor() {
		return proveedor;
	}
	public void setProveedor(ProveedorEntity proveedor) {
		this.proveedor = proveedor;
	}
	public InsumoEntity getInsumo() {
		return insumo;
	}
	public void setInsumo(InsumoEntity insumo) {
		this.insumo = insumo;
	}
	public ItemProveedorInsumoID(ProveedorEntity proveedor, InsumoEntity insumo) {
		super();
		this.proveedor = proveedor;
		this.insumo = insumo;
	}
	public ItemProveedorInsumoID() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
