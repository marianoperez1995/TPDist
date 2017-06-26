package test;

import negocio.AreaProduccion;
import negocio.ItemPrendaArea;
import persistencia.AreaProduccionDAO;
import persistencia.ItemPrendaAreaDAO;

public class test1 {

	public static void main(String[] args) {
	//	AreaProduccion area= AreaProduccionDAO.getInstancia().getAreaProduccion(1);
	//	System.out.println(area.toString());
	//	LineaProduccion lineas = LineaProduccionDAO.getInstancia().getLineaProduccion(3);
		//System.out.println(lineas.toString());
		
		ItemPrendaArea itemPA = ItemPrendaAreaDAO.getInstancia().get(2,2);
		System.out.println(itemPA.toString());
		
		
	}

}
