package negocio;

import dto.InsumoDTO;
import entities.InsumoEntity;
import persistencia.InsumoDAO;

public class Insumo {
	private int idInsumo;
	private String nombre;
	private float stockActual;
	private float precioFinal;
	private float stockMinimo;
	private String unidad;
	private float cantAComprar;

	public Insumo(InsumoDTO insumo) {
		this.idInsumo = insumo.getCodigo();
		this.nombre = insumo.getNombre();
		this.stockActual = insumo.getStockActual();
		this.precioFinal = insumo.getPrecioFinal();
		this.stockMinimo = insumo.getStockMinimo();
		this.unidad = insumo.getUnidad();
		this.cantAComprar = insumo.getCantAComprar();
	}

	public Insumo(InsumoEntity insumo) {
		this.idInsumo = insumo.getCodigo();
		this.nombre = insumo.getNombre();
		this.stockActual = insumo.getStockActual();
		this.precioFinal = insumo.getPrecioFinal();
		this.stockMinimo = insumo.getStockMinimo();
		this.unidad = insumo.getUnidad();
		this.cantAComprar = insumo.getCantAComprar();
	}
	
	public Insumo() {
		// TODO Auto-generated constructor stub
	}

	public void insertar() {
		InsumoDAO.getInstancia().insert(this);		
	}

	public void borrar() {
		InsumoDAO.getInstancia().eliminar(this.idInsumo);
	}


	public boolean sosElInsumo(int codigo) {
		return (codigo == this.idInsumo);
	}

	public int getIdInsumo() {
		return idInsumo;
	}

	public void setIdInsumo(int idInsumo) {
		this.idInsumo = idInsumo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getStockActual() {
		return stockActual;
	}

	public void setStockActual(float stockActual) {
		this.stockActual = stockActual;
	}

	public float getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(float precioFinal) {
		this.precioFinal = precioFinal;
	}

	public float getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(float stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public float getCantAComprar() {
		return cantAComprar;
	}

	public void setCantAComprar(float cantAComprar) {
		this.cantAComprar = cantAComprar;
	}

	@Override
	public String toString() {
		return "Insumo [idInsumo=" + idInsumo + ", nombre=" + nombre + ", stockActual=" + stockActual + ", precioFinal="
				+ precioFinal + ", stockMinimo=" + stockMinimo + ", unidad=" + unidad + ", cantAComprar=" + cantAComprar
				+ "]";
	}
	
	public InsumoDTO toDTO(){
		InsumoDTO in= new InsumoDTO();
		in.setCantAComprar(cantAComprar);
		in.setCodigo(idInsumo);
		in.setPrecioFinal(precioFinal);
		in.setNombre(nombre);
		in.setStockActual(stockActual);
		in.setStockMinimo(stockMinimo);
		in.setUnidad(unidad);
		return in;
	}

	
}
