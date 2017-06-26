package test;

import java.util.ArrayList;

import negocio.OrdenProduccion;
import persistencia.OrdenProduccionDAO;

public class test1 {

	public static void main(String[] args) {
		ArrayList<OrdenProduccion> ordenes= new ArrayList<OrdenProduccion>();
		ordenes= OrdenProduccionDAO.getInstancia().getAll();
		for (OrdenProduccion or: ordenes){
			System.out.println(or.toString());
		}
	}

}
