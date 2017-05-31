package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="LotesInsumo")
public class LoteInsumoEntity implements Serializable  {

	
	public LoteInsumoEntity(int codigoLoteInsumo, Date fechaRecepcion, ProveedorEntity proveedor, float cantidad,
			InsumoEntity insumo) {
		super();
		this.codigoLoteInsumo = codigoLoteInsumo;
		this.fechaRecepcion = fechaRecepcion;
		this.proveedor = proveedor;
		this.cantidad = cantidad;
		this.insumo = insumo;
	}

	public LoteInsumoEntity() {
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 2090616063425479310L;
	@Id
	@Column(name="idLoteInsumo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoLoteInsumo;
	private Date fechaRecepcion;
	@ManyToOne
	@JoinColumn(name="idProveedor")
	private ProveedorEntity proveedor;
	private float cantidad;
	@ManyToOne
	@JoinColumn(name="idInsumo")
	private InsumoEntity insumo;	
	
	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public ProveedorEntity getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorEntity proveedor) {
		this.proveedor = proveedor;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public InsumoEntity getInsumo() {
		return insumo;
	}

	public void setInsumo(InsumoEntity insumo) {
		this.insumo = insumo;
	}

	public int getCodigoLoteInsumo() {
		return codigoLoteInsumo;
	}

	public void setCodigoLoteInsumo(int codigoLoteInsumo) {
		this.codigoLoteInsumo = codigoLoteInsumo;
	}
}
