package test;

import java.util.ArrayList;

import negocio.Prenda;
import persistencia.PrendaDAO;

public class test1 {

	public static void main(String[] args) {
		ArrayList<Prenda> prendas= PrendaDAO.getInstancia().getAll();
		for (Prenda pre: prendas){
			System.out.println(pre.toString());
		}
	}

}
