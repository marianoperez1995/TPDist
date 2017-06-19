package test;

import java.util.ArrayList;

import businessDelegate.BusinessDelegate;
import controladores.AdministradorClientes;
import dto.ClienteDTO;
import negocio.Prenda;
import objetoRemoto.ObjetoRemoto;
import persistencia.PrendaDAO;

public class test1 {

	public static void main(String[] args) {
		//Prenda pre =PrendaDAO.getInstancia().getPrenda(5);
			//System.out.println(pre.toString());
		ClienteDTO cliente= new ClienteDTO();
		cliente.setNumeroCliente(1);
		AdministradorClientes.getInstancia().aumentarLimiteCreditoCliente(2500000, cliente);
	
	}

}
