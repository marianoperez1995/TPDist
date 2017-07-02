package test;

import dto.PrendaDTO;
import negocio.Prenda;
import persistencia.PrendaDAO;

public class test1 {

	public static void main(String[] args) {
		
		Prenda pre= PrendaDAO.getInstancia().getPrendasPorNombreYColorYTalle("Remera", "Azul", "S");
		System.out.println(pre.toString());
	}

}
