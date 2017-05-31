package controladores;

import java.util.ArrayList;

import dto.PrendaDTO;
import negocio.Prenda;

public class AdministradorPrenda {
	private ArrayList<Prenda> prendas;
	private static AdministradorPrenda instancia = null;
	
	
	private static AdministradorPrenda getInstancia (){
		if(instancia== null)
			instancia= new AdministradorPrenda();
		return instancia;
	}

	
	//public void generarPrenda(ArrayList<String> talles, ArrayList<String> colores, String desc, float costoProduccion,
	//		float precio, float porcentaje) {
	public void generarPrenda (PrendaDTO preDTO){ // SE asumio que con talles se quiso decir lo mismo, entonces use el dto
		Prenda p = new Prenda(preDTO);
		prendas.add(p);
		p.insert();
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
		Prenda pren= new Prenda(prenda);
		for (Prenda p:prendas){
			if (p.sosLaPrenda(pren.getCodigo())){
				p.update(pren);
			}
		}
		Prenda prenda2 = null;
		prenda2 = pren.buscarPrenda(pren.getCodigo());
		
		if(prenda2 != null)
			prenda2.update(pren);
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
		ArrayList<PrendaDTO> list = null;
		ArrayList<Prenda> aux= null;
		// Vale esto ? otra cosa no se me ocurrio, sin tener que llamar al dao desde aca
		Prenda help=null;
		aux= help.buscarTodos();
				
		for (Prenda p : aux){
				list.add(p.toDTO());
		}
		return list;
	}
}
