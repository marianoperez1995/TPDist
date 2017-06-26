package test;

import negocio.Insumo;
import negocio.ItemPrendaInsumo;
import negocio.Prenda;
import persistencia.InsumoDAO;
import persistencia.PrendaDAO;

public class testtt {

	public static void main(String[] args) {
		
		ItemPrendaInsumo item = new ItemPrendaInsumo();
		Insumo ins = InsumoDAO.getInstancia().getInsumo(9);
		Prenda p = PrendaDAO.getInstancia().getPrenda(2);
		item.setCantidad(50);
		item.setDesperdicio(10);
		item.setInsumo(ins);
		item.setPrenda(p);
		item.insertar();
		
		
		/*		
		ArrayList<Prenda> prendas = new ArrayList<>();
		prendas = PrendaDAO.getInstancia().getAll();
		for (Prenda p : prendas){
			System.out.println(p.toString());
		}
		*/
	}

}
