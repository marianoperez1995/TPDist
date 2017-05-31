package negocio;

import java.util.Date;

import dto.LoteInsumoDTO;
import entities.LoteInsumoEntity;
import persistencia.LoteInsumoDAO;

public class LoteInsumo {
	private int idLoteInsumo;
	private Date fechaRecepcion;
	private Proveedor proveedor;
	private float cantidad;
	private Insumo insumo;
	

	public LoteInsumo(LoteInsumoDTO liDTO) {
		this.fechaRecepcion = liDTO.getFechaRecepcion();
		this.proveedor = new Proveedor(liDTO.getProveedor());
		this.cantidad = liDTO.getCantidad();
		this.insumo = new Insumo (liDTO.getInsumo());
		this.idLoteInsumo = liDTO.getCodigoLoteInsumo();
	}
	public LoteInsumo(LoteInsumoEntity lote) {
		this.fechaRecepcion = lote.getFechaRecepcion();
		this.proveedor = new Proveedor(lote.getProveedor());
		this.cantidad = lote.getCantidad();
		this.insumo = new Insumo (lote.getInsumo());
		this.idLoteInsumo = lote.getCodigoLoteInsumo();
	}

	public void insertar() {
		LoteInsumoDAO.getInstancia().insert(this);		
	}

	public void borrar() {
		LoteInsumoDAO.getInstancia().eliminar(this.idLoteInsumo);
	}

	
	public boolean sosElLote(int codigo) {
		return codigo == this.idLoteInsumo;// ---

	}

	public boolean tenesElLote(int codigo) {
		return false;// falta hacer, no se que pide
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public int getIdLoteInsumo() {
		return idLoteInsumo;
	}

	public void setIdLoteInsumo(int idLoteInsumo) {
		this.idLoteInsumo = idLoteInsumo;
	}

	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}
	
	
}
