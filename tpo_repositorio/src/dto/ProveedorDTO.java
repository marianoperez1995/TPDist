package dto;

import java.io.Serializable;
import java.util.ArrayList;

public class ProveedorDTO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4982890337462866332L;
	private String nombre;
	private String cuit;
	private ArrayList<ItemListaPrecioDTO> listaPrecios;
	private int codigo;

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

	public ArrayList<ItemListaPrecioDTO> getListaPrecios() {
		return listaPrecios;
	}

	public void setListaPrecios(ArrayList<ItemListaPrecioDTO> listaPrecios) {
		this.listaPrecios = listaPrecios;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
