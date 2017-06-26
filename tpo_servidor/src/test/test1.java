package test;

import java.util.Calendar;

import controladores.AdministradorPedidos;
import negocio.Cliente;
import negocio.Factura;
import negocio.PedidoCliente;
import persistencia.ClienteDAO;
import persistencia.FacturaDAO;
import persistencia.PedidoClienteDAO;

public class test1 {

	public static void main(String[] args) {
		PedidoCliente ped= PedidoClienteDAO.getInstancia().getPedidoCliente(1);
		System.out.println(ped.getItemsPedidoCliente().size());
		AdministradorPedidos.getInstancia().completarPedido(ped.toDTO());
	}

}
