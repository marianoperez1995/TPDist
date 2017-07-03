package negocio;

import java.util.ArrayList;

import dto.ItemPrendaInsumoDTO;
import dto.PrendaDTO;
import entities.PrendaEntity;
import persistencia.PrendaDAO;

public class Prenda {
	private int idPrenda;
	private String descripcion;
	private boolean estadoProduccion;
	private float costoProduccionReal;
	private float costoProduccionActual;
	private float porcentajeGanancia;
	private float precio;
	public int cantidadAConfeccionar;
	private String color;
	private String talle;
	private int stockMinimo;
	private int stockActual;
	private ArrayList<ItemPrendaInsumo> insumos;

	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Prenda(PrendaDTO preDTO) {
		this.idPrenda = preDTO.getIdPrenda();
		this.descripcion = preDTO.getDescripcion();
		this.estadoProduccion = preDTO.isEstadoProduccion();
		this.costoProduccionReal = preDTO.getCostoProduccionReal();
		this.costoProduccionActual = preDTO.getCostoProduccionActual();
		this.porcentajeGanancia = preDTO.getPorcentajeGanancia();
		this.precio = preDTO.getPrecio();
		this.cantidadAConfeccionar = preDTO.getCantidadAConfeccionar();
		this.color = preDTO.getColor();
		this.talle = preDTO.getTalle();
		this.stockActual = preDTO.getStockActual();
		this.stockMinimo = preDTO.getStockMinimo();
	}

	public Prenda(PrendaEntity p) {
		this.idPrenda = p.getIdPrenda();
		this.descripcion = p.getDescripcion();
		this.estadoProduccion = p.getEstadoProduccion();
		this.costoProduccionReal = p.getCostoProduccionReal();
		this.costoProduccionActual = p.getCostoProduccionActual();
		this.porcentajeGanancia = p.getPorcentajeGanancia();
		this.precio = p.getPrecio();
		this.cantidadAConfeccionar = p.getCantidadAConfeccionar();
		this.color = p.getColor();
		this.talle = p.getTalle();
		this.stockActual = p.getStockActual();
		this.stockMinimo = p.getStockMinimo();
	}

	public Prenda() {
		// TODO Auto-generated constructor stub
	}

	public void insertar() {
		PrendaDAO.getInstancia().insert(this);
	}

	public void borrar() {
		PrendaDAO.getInstancia().eliminar(this.idPrenda);
	}

	public boolean sosLaPrenda(int numero) {
		return (numero == this.idPrenda);

	}

	public int getIdPrenda() {
		return idPrenda;
	}

	public void setIdPrenda(int idPrenda) {
		this.idPrenda = idPrenda;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEstadoProduccion() {
		return estadoProduccion;
	}

	public void setEstadoProduccion(boolean estadoProduccion) {
		this.estadoProduccion = estadoProduccion;
	}

	public float getCostoProduccionReal() {
		return costoProduccionReal;
	}

	public void setCostoProduccionReal(float costoProduccionReal) {
		this.costoProduccionReal = costoProduccionReal;
	}

	public float getCostoProduccionActual() {
		return costoProduccionActual;
	}

	public void setCostoProduccionActual(float costoProduccionActual) {
		this.costoProduccionActual = costoProduccionActual;
	}

	public float getPorcentajeGanancia() {
		return porcentajeGanancia;
	}

	public void setPorcentajeGanancia(float porcentajeGanancia) {
		this.porcentajeGanancia = porcentajeGanancia;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidadAConfeccionar() {
		return cantidadAConfeccionar;
	}

	public void setCantidadAConfeccionar(int cantidadAConfeccionar) {
		this.cantidadAConfeccionar = cantidadAConfeccionar;
	}

	public PrendaDTO toDTO() {
		PrendaDTO prenda = new PrendaDTO();
		prenda.setCantidadAConfeccionar(cantidadAConfeccionar);
		prenda.setIdPrenda(idPrenda);
		prenda.setColor(color);
		prenda.setTalle(talle);
		prenda.setCostoProduccionActual(costoProduccionActual);
		prenda.setCostoProduccionReal(costoProduccionReal);
		prenda.setDescripcion(descripcion);
		prenda.setEstadoProduccion(estadoProduccion);
		prenda.setPorcentajeGanancia(porcentajeGanancia);
		prenda.setPrecio(precio);
		prenda.setStockActual(stockActual);
		prenda.setStockMinimo(stockMinimo);
		ArrayList<ItemPrendaInsumoDTO> items = new ArrayList<ItemPrendaInsumoDTO>();
		if (insumos != null) {
			for (int i = 0; i < insumos.size(); i++) {
				ItemPrendaInsumoDTO dto = new ItemPrendaInsumoDTO();
				dto = insumos.get(i).toDTO();
				items.add(dto);
			}
		}
		prenda.setInsumos(items);
		return prenda;
	}

	public String getColor() {
		return color;
	}

	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public int getStockActual() {
		return stockActual;
	}

	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}

	@Override
	public String toString() {
		return "Prenda [idPrenda=" + idPrenda + ", descripcion=" + descripcion + ", estadoProduccion="
				+ estadoProduccion + ", costoProduccionReal=" + costoProduccionReal + ", costoProduccionActual="
				+ costoProduccionActual + ", porcentajeGanancia=" + porcentajeGanancia + ", precio=" + precio
				+ ", cantidadAConfeccionar=" + cantidadAConfeccionar + ", color=" + color + ", talle=" + talle
				+ ", stockMinimo=" + stockMinimo + ", stockActual=" + stockActual + ", insumos=" + insumos + "]";
	}

	public ArrayList<ItemPrendaInsumo> getInsumos() {
		return insumos;
	}

	public void setInsumos(ArrayList<ItemPrendaInsumo> insumos) {
		this.insumos = insumos;
	}

	public boolean verificarCantidad(int cantidad) {
		if (this.stockActual >= cantidad) {
			return true;
		} else {
			return false;
		}
	}

	public void disminuirStock(int cantidad) {
		this.stockActual = this.stockActual - cantidad;
	}

	public void aumentarStock(int cantidad) {
		this.stockActual = this.stockActual + cantidad;
		PrendaDAO.getInstancia().update(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prenda other = (Prenda) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		return true;
	}

	public void update() {		
		PrendaDAO.getInstancia().update(this);		
	}

}
