package controladores;

import java.util.ArrayList;

import dto.BultoDTO;
import dto.InsumoDTO;
import dto.PrendaDTO;
import negocio.Bulto;
import negocio.Cliente;
import negocio.Insumo;
import negocio.Prenda;
import persistencia.BultoDAO;
import persistencia.InsumoDAO;
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

	public PrendaDTO getPrendaPorNombreYColorYTalle(String color, String prenda, String talle) {
		Prenda pre= PrendaDAO.getInstancia().getPrendasPorNombreYColorYTalle(prenda, color, talle);
		return pre.toDTO();
	}

	public void altaPrenda(Prenda prenda) {
		prendas.add(prenda);
		prenda.insertar();
	}

	public ArrayList<InsumoDTO> getInsumos() {
		ArrayList<Insumo> ins = InsumoDAO.getInstancia().getAll();
		ArrayList<InsumoDTO> resultado = new ArrayList<InsumoDTO>();
		
		for(Insumo i: ins){
			resultado.add(i.toDTO());
		}
		
		return resultado;
	}

	public InsumoDTO getInsumo(String nombre) {
		return InsumoDAO.getInstancia().getInsumoPorNombre(nombre).toDTO();
	}

	public ArrayList<BultoDTO> buscarBultoPorId(int idPrenda) {
		ArrayList<BultoDTO> resultado = new ArrayList<>();
		
		for(Bulto b : BultoDAO.getInstancia().getBultos(idPrenda)){
			resultado.add(b.toDTO());
		}
		
		return resultado;
	}

}
