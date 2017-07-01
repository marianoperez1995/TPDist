package test;

import controladores.AdministradorPedidos;
import dto.PedidoClienteDTO;
import persistencia.PedidoClienteDAO;

public class testGenerarFacturaPDF {

	public static void main(String[] args) {
		
		PedidoClienteDTO p = PedidoClienteDAO.getInstancia().getPedidoCliente(1).toDTO();
		AdministradorPedidos.getInstancia().enviarPedido(p);

	}

}
