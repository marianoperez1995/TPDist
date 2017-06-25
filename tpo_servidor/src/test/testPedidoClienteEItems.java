package test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import controladores.AdministradorPedidos;
import negocio.ItemPedidoCliente;
import negocio.PedidoCliente;
import negocio.Transporte;
import persistencia.ClienteDAO;
import persistencia.PrendaDAO;

public class testPedidoClienteEItems {

	public static void main(String[] args) {
		float total = 0;
		PedidoCliente ped = new PedidoCliente();
		ped.setCliente(ClienteDAO.getInstancia().getCliente(4));
		Date f = new Date();
		f=(Calendar.getInstance().getTime());
		ped.setFechaDespacho(f);
		ped.setFechaGeneracion(f);
		ped.setFechaProbableDespacho(f);
		ped.setFechaEntregaCliente(f);
		ped.setEstado("Pendiente");
		ArrayList<ItemPedidoCliente>items = new ArrayList<>();
		ItemPedidoCliente i = new ItemPedidoCliente();
		i.setCantidad(20);
		i.setPrecio(PrendaDAO.getInstancia().getPrenda(3).getPrecio()*i.getCantidad());
		i.setPrenda(PrendaDAO.getInstancia().getPrenda(3));
		items.add(i);
		
		ItemPedidoCliente a = new ItemPedidoCliente();
		a.setCantidad(10);
		a.setPrecio(PrendaDAO.getInstancia().getPrenda(4).getPrecio()*a.getCantidad());
		a.setPrenda(PrendaDAO.getInstancia().getPrenda(4));
		items.add(a);
		

		ped.setItemsPedidoCliente(items);
		for (ItemPedidoCliente itped: items){
			total = itped.getPrecio() + total;
		}
		ped.setPrecioTotal(total);
		
		AdministradorPedidos.getInstancia().agregarPedido(ped.toDTO());
		
		//esta funcion genera un pedido y lo chequea automaticamente
		//AdministradorPedidos.getInstancia().nuevoPedido(ped.toDTO());
		
		
		
		/*
		Despacho d = new Despacho();
		d.setDescripcion("Despacho de despachar");
		ArrayList<PedidoCliente> pedidos = new ArrayList<>();
		ArrayList<Transporte> transportes = new ArrayList<>();
		pedidos.add(e);
		
		d.setPedidosCliente(pedidos);
		d.setTransportes(transportes);*/

	}

}
