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

	public void generarPrenda (PrendaDTO preDTO){ 
		Prenda p = new Prenda(preDTO);
		prendas.add(p);
		p.insertar();
	}

	public void bajaPrenda(PrendaDTO pren) {
		for(Prenda p: prendas){
			if(p.sosLaPrenda(pren.getIdPrenda())){
				prendas.remove(p);
				p.borrar(); 
				return;
			}
		}
		Prenda prenda = PrendaDAO.getInstancia().getPrenda(pren.getIdPrenda());		
		if(prenda != null)
			prenda.borrar();		
	}
	
	public void modificarPrenda(PrendaDTO prenda){
		PrendaDAO.getInstancia().update(new Prenda(prenda));
	}
	
	public PrendaDTO getPrenda(int codigo){
		for (Prenda p : prendas){
			if (p.sosLaPrenda(codigo)){
				return p.toDTO();
			}
		}
		Prenda p = PrendaDAO.getInstancia().getPrenda(codigo);		
		return p.toDTO();
	}
	public ArrayList<PrendaDTO> buscarAllPrenda (){
		ArrayList<Prenda> prendas= PrendaDAO.getInstancia().getAll();
		ArrayList<PrendaDTO> prendasDTO= new ArrayList<PrendaDTO>();
				
		for (Prenda p : prendas){
				prendasDTO.add(p.toDTO());
		}
		return prendasDTO;
	}

	public ArrayList<PrendaDTO> getPrendaPorNombre(PrendaDTO prenda) {
		ArrayList<Prenda> prendas= PrendaDAO.getInstancia().getPrendasPorNombre(prenda);
		ArrayList<PrendaDTO> prendasDTO= new ArrayList<PrendaDTO>();
		for (Prenda pre: prendas){
			prendasDTO.add(pre.toDTO());
		}
		return prendasDTO;
	}

	public ArrayList<PrendaDTO> getPrendaPorNombreYColor(PrendaDTO prenda) {
		ArrayList<Prenda> prendas= PrendaDAO.getInstancia().getPrendasPorNombreYColor(prenda);
		ArrayList<PrendaDTO> prendasDTO= new ArrayList<PrendaDTO>();
		for (Prenda pre: prendas){
			prendasDTO.add(pre.toDTO());
		}
		return prendasDTO;
	}

}
