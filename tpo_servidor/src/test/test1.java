package test;

import java.util.ArrayList;

import controladores.AdministradorProduccion;
import negocio.ItemPedidoCliente;
import negocio.ItemPrendaArea;
import negocio.OrdenProduccion;
import negocio.PedidoCliente;
import persistencia.ItemPedidoClienteDAO;
import persistencia.ItemPrendaAreaDAO;
import persistencia.PedidoClienteDAO;

public class test1 {

	public static void main(String[] args) {
		PedidoCliente ped= PedidoClienteDAO.getInstancia().getPedidoCliente(1);
		
		System.out.println(ped.getCausa());
	}

}
