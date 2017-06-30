package test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businessDelegate.BusinessDelegate;
import dto.PrendaDTO;
import negocio.Prenda;
import objetoRemoto.ObjetoRemoto;
import persistencia.PrendaDAO;

public class test1 {

	public static void main(String[] args) {

		PrendaDTO pre= new PrendaDTO();
		pre.setDescripcion("Remera");
		ArrayList<PrendaDTO> prendas;
		try {
			prendas = BusinessDelegate.getInstancia().getPrendasPorNombre(pre);
			System.out.println(prendas.size());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
