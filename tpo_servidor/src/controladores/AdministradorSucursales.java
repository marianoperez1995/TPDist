package controladores;

import java.util.ArrayList;

import dto.ClienteDTO;
import dto.EmpleadoDTO;
import negocio.Cliente;
import negocio.Empleado;
import negocio.Sucursal;
import persistencia.ClienteDAO;
import persistencia.EmpleadoDAO;

public class AdministradorSucursales {
	private ArrayList<Sucursal> sucursales;
	
private static AdministradorSucursales instancia;
	
	
	public static AdministradorSucursales getInstancia (){
		if(instancia== null)
			instancia= new AdministradorSucursales();
		return instancia;
	}
	/*
	public void crearSucursal(SucursalDTO sur) {
		Sucursal sucur = new Sucursal(sur);
		sucursales.add(sucur);
		sucur.insert();
	}
	
	public Sucursal buscarSucursal (int numero){
		for(Sucursal s: sucursales){
			if (s.sosLaSucursal(numero))
				return s;
		}
		
		Sucursal  suc = null;
		suc = suc.buscarSucusal( numero);
		
		return suc;
	}
	
	public void bajaSucusal(int numero){
		for(Sucursal s: sucursales){
			if (s.sosLaSucursal(numero)){
				sucursales.remove(s);
				s.delete ();
			}
		}
		Sucursal  suc = null;
		suc = suc.buscarSucusal( numero);
		if(suc != null)
			suc.delete();
	}
	public void modificarSucursal(SucursalDTO sur){
		Sucursal suc= new Sucursal(sur);
		for(Sucursal s: sucursales){
			if (s.sosLaSucursal(sur.getNumero())){
				sucursales.remove(s);
				s.delete ();
			}
		}
		Sucursal aux = null;
		aux = aux.buscarSucusal(sur.getNumero());
		
		if(aux != null)
			aux.update(suc);
	}
	
	public SucursalDTO BuscarSucursal(int codigoS){
		for (Sucursal s : sucursales){
			if (s.sosLaSucursal(codigoS)){
				return s.toDTO();
			}
		}
		Sucursal fact = null;
		fact = fact.buscarSucusal(codigoS);
		
		return fact.toDTO();
	}
	public ArrayList<SucursalDTO> BuscarAllPrenda (){
		ArrayList<SucursalDTO> list = null;
		ArrayList<Sucursal> aux= null;
		// Vale esto ? otra cosa no se me ocurrio, sin tener que llamar al dao desde aca
		Sucursal help=null;
		aux= help.buscarTodos();
				
		for (Sucursal s : aux){
				list.add(s.toDTO());
		}
		return list;
	}*/
	
	
	public EmpleadoDTO buscarLogin(EmpleadoDTO emp){
		ArrayList<Empleado> lista = new ArrayList<Empleado>();
		lista = EmpleadoDAO.getInstancia().getAll();
		
		if(lista != null){
			for(Empleado e: lista){
				if(e.getUsuario().equalsIgnoreCase(emp.getUsuario()) && e.getPass().equals(emp.getPass())){
					return e.toDTO();
				}
			}
		}
		return null;
	}
}
