package test;

import java.util.ArrayList;

import negocio.ItemPrendaInsumo;
import persistencia.ItemPrendaInsumoDAO;

public class testtt {

	public static void main(String[] args) {
		
	/*	ItemPrendaInsumo item = new ItemPrendaInsumo();
		Insumo ins = InsumoDAO.getInstancia().getInsumo(10);
		Prenda p = PrendaDAO.getInstancia().getPrenda(2);
		item.setCantidad(35);
		item.setDesperdicio(15);
		item.setInsumo(ins);
		item.setPrenda(p);
		item.insertar();*/		
				
		/*ArrayList<Prenda> prendas = new ArrayList<>();
		prendas = PrendaDAO.getInstancia().getAll();
		for (Prenda p : prendas){
			System.out.println(p.toString());
		}
		*/
		ArrayList<ItemPrendaInsumo> items = new ArrayList<>();
		items = ItemPrendaInsumoDAO.getInstancia().obtenerTodosDePrenda(1);
		for (ItemPrendaInsumo p : items){
			System.out.println(p.toString());
		}
	}

}
