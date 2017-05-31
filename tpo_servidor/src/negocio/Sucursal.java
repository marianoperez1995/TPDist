package negocio;

import java.util.ArrayList;

import dto.EmpleadoDTO;
import dto.SucursalDTO;
import entities.EmpleadoEntity;
import entities.SucursalEntity;
import persistencia.OrdenProduccionDAO;
import persistencia.SucursalDAO;

public class Sucursal {
	private int idSucursal;
	private String nombre;
	private String ubicacion;
	private String horarios;

	public Sucursal(){
		
	}
	public Sucursal(SucursalDTO sucursal) {
		this.idSucursal = sucursal.getNumero();
		this.ubicacion = sucursal.getUbicacion();
		this.nombre = sucursal.getNombre();
		this.horarios = sucursal.getHorarios();
	}
	public Sucursal(SucursalEntity sucursal){
		this.idSucursal = sucursal.getNumero();
		this.ubicacion = sucursal.getUbicacion();
		this.nombre = sucursal.getNombre();
		this.horarios = sucursal.getHorarios();
	}
	public void insertar() {
		SucursalDAO.getInstancia().insert(this);		
	}

	public void borrar() {
		SucursalDAO.getInstancia().eliminar(this.idSucursal);
	}
	public int getIdSucursal() {
		return idSucursal;
	}
	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getHorarios() {
		return horarios;
	}
	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}

	public SucursalDTO toDTO() {
		SucursalDTO suc = new SucursalDTO();
		suc.setHorarios(horarios);
		suc.setNombre(nombre);
		suc.setNumero(idSucursal);
		suc.setUbicacion(ubicacion);
		return suc;
	}

	

}
