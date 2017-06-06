package test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businessDelegate.BusinessDelegate;
import dto.PedidoClienteDTO;
import dto.PrendaDTO;

public abstract class testStock {
	
	
	public static void main(String[] args) {
		
		ArrayList<PedidoClienteDTO> pedidos;
		try {
			System.out.println("Obtengo todas los pedidos:");
			pedidos = BusinessDelegate.getInstancia().getPedidos();
			for (PedidoClienteDTO ped: pedidos){
				System.out.println(ped.toString());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		
		
		ArrayList<PrendaDTO> prendas;
		try {
			System.out.println("Obtengo todas las prendas:");
			prendas = BusinessDelegate.getInstancia().getPrendas();
			for (PrendaDTO pre:prendas){
				System.out.println(pre.toString());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
		try {
			System.out.println("\n Obtengo una prenda sola (a modificar):");
			PrendaDTO prenda= BusinessDelegate.getInstancia().getPrenda(1,1,1);
			System.out.println(prenda.toString());
			prenda.setStockActual(prenda.getStockActual()-12);
			BusinessDelegate.getInstancia().modificarPrenda(prenda);
			System.out.println(" \nPrenda con stock modificado:");
			System.out.println(prenda.toString());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/
		
		
		
		
		
			
		
	}

}
