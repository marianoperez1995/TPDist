package controladores;

import java.util.ArrayList;

import dto.PrendaDTO;
import negocio.Prenda;
import persistencia.PrendaDAO;

public class AdministradorPrenda {
	private static ArrayList<Prenda> prendas;
	private static AdministradorPrenda instancia = null;
	
	
	public static AdministradorPrenda getInstancia (){
		if(instancia== null){
			instancia= new AdministradorPrenda();
			prendas = new ArrayList<Prenda>();
		}
		return instancia;
	}

	
	//public void generarPrenda(ArrayList<String> talles, ArrayList<String> colores, String desc, float costoProduccion,
	//		float precio, float porcentaje) {
	public void generarPrenda (PrendaDTO preDTO){ // SE asumio que con talles se quiso decir lo mismo, entonces use el dto
		Prenda p = new Prenda(preDTO);
		prendas.add(p);
		p.insertar();
//revisar parametros, en Prenda estan talles disponibles, no "talles", por ahi querian decir lo mismo, pero por ahi no
	}

	private Prenda buscarPrenda(int numero) {
		for (Prenda p:prendas){
			if (p.sosLaPrenda(numero)){
				return p;
			}
		}
		Prenda prenda = null;
		prenda = prenda.buscarPrenda(numero);
		return prenda;
	}

	public void bajaPrenda(PrendaDTO pren) {
		for(Prenda p: prendas){
			if(p.sosLaPrenda(pren.getCodigo())){
				prendas.remove(p);
				p.delete(); 
				return;
			}
		}
		Prenda prenda = null;
		prenda = prenda.buscarPrenda(pren.getCodigo());
		
		if(prenda != null)
			prenda.delete();
	
		
	}
	public void modificarPrenda(PrendaDTO prenda){
		PrendaDAO.getInstancia().update(new Prenda(prenda));
	}
	public PrendaDTO BuscarPrenda(int codigo){
		for (Prenda p : prendas){
			if (p.sosLaPrenda(codigo)){
				return p.toDTO();
			}
		}
		Prenda fact = null;
		fact = fact.buscarPrenda(codigo);
		
		return fact.toDTO();
	}
	public ArrayList<PrendaDTO> BuscarAllPrenda (){
		ArrayList<Prenda> prendas= PrendaDAO.getInstancia().getAll();
		ArrayList<PrendaDTO> prendasDTO= new ArrayList<PrendaDTO>();
				
		for (Prenda p : prendas){
				prendasDTO.add(p.toDTO());
		}
		return prendasDTO;
	}


	public PrendaDTO getPrenda(int id, int talle, int color) {
		return PrendaDAO.getInstancia().getPrenda(id, talle, color).toDTO();
	}
}
