package test;

import java.util.ArrayList;

import negocio.PedidoCliente;
import persistencia.PedidoClienteDAO;

public class test1 {

	public static void main(String[] args) {
	
		
		
		ArrayList<PedidoCliente> pedidos= PedidoClienteDAO.getInstancia().getAll();
		for (PedidoCliente ped:pedidos){
			System.out.println(ped.toString());
		}
		
	}

}
