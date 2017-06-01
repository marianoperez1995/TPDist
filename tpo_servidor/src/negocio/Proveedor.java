package negocio;

import java.util.ArrayList;

import dto.ItemProveedorInsumoDTO;
import dto.ProveedorDTO;
import entities.ItemProveedorInsumoEntity;
import entities.ProveedorEntity;
import persistencia.ProveedorDAO;

public class Proveedor {
	private int idProveedor;
	private String nombre;
	private String cuit;
	private ArrayList<ItemProveedorInsumo> listaPrecios;
		
	public Proveedor(ProveedorDTO proveedor) {
		this.nombre = proveedor.getNombre();
		this.cuit = proveedor.getCuit();
		this.idProveedor = proveedor.getCodigo();
		this.listaPrecios = new ArrayList<ItemProveedorInsumo>();
		for (ItemProveedorInsumoDTO i : proveedor.getListaPrecios()){
			this.listaPrecios.add(new ItemProveedorInsumo(i));
		}
	}

	public Proveedor(ProveedorEntity proveedor) {
		this.nombre = proveedor.getNombre();
		this.cuit = proveedor.getCuit();
		this.idProveedor = proveedor.getCodigo();
		this.listaPrecios = new ArrayList<ItemProveedorInsumo>();
		for (ItemProveedorInsumoEntity i : proveedor.getItemsProveedorInsumo()){
			this.listaPrecios.add(new ItemProveedorInsumo(i));
		}
	}
	public void insertar() {
		ProveedorDAO.getInstancia().insert(this);		
	}

	public void borrar() {
		ProveedorDAO.getInstancia().eliminar(this.idProveedor);
	}
	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public ArrayList<ItemProveedorInsumo> getListaPrecios() {
		return listaPrecios;
	}

	public void setListaPrecios(ArrayList<ItemProveedorInsumo> listaPrecios) {
		this.listaPrecios = listaPrecios;
	}
	

	
}
