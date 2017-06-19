package test;

import java.util.ArrayList;

import negocio.Prenda;
import persistencia.PrendaDAO;

public class test1 {

	public static void main(String[] args) {
		Prenda pre =PrendaDAO.getInstancia().getPrenda(5);
			System.out.println(pre.toString());
	
	}

}
