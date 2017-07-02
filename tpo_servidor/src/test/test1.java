package test;

import java.util.ArrayList;

import controladores.AdministradorProduccion;
import negocio.ItemPedidoCliente;
import negocio.OrdenProduccion;
import negocio.PedidoCliente;
import persistencia.ItemPedidoClienteDAO;
import persistencia.PedidoClienteDAO;

public class test1 {

	public static void main(String[] args) {
		//Test ordenes produccion parcial/completa
		PedidoCliente p = PedidoClienteDAO.getInstancia().getPedidoCliente(1);
		ArrayList<ItemPedidoCliente> pedidos = ItemPedidoClienteDAO.getInstancia().getItemsPedidoCliente(1);
		p.setItemsPedidoCliente(pedidos);
		ArrayList<OrdenProduccion> ordenes = AdministradorProduccion.getInstancia().generarOrdenes(p);
		for (OrdenProduccion o : ordenes){
			System.out.println(o.getTipo());
		}
	}

}
