package test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import controladores.AdministradorPedidos;
import negocio.Despacho;
import negocio.ItemPedidoCliente;
import negocio.PedidoCliente;
import negocio.Transporte;
import persistencia.ClienteDAO;
import persistencia.PrendaDAO;

public class testPedidoClienteEItems {

	public static void main(String[] args) {
		
		PedidoCliente ped = new PedidoCliente();
		ped.setCliente(ClienteDAO.getInstancia().getCliente(3));
		ped.setEstado("Aceptado");
		Date f = new Date();
		f=(Calendar.getInstance().getTime());
		ped.setFechaDespacho(f);
		ped.setFechaGeneracion(f);
		ped.setFechaProbableDespacho(f);
		ped.setFechaEntregaCliente(f);
		//ped.setIdPedidoCliente(6);
		ArrayList<ItemPedidoCliente>items = new ArrayList<>();
		ItemPedidoCliente i = new ItemPedidoCliente();
		i.setCantidad(5);
		i.setPrecio(50);
		i.setPrenda(PrendaDAO.getInstancia().getPrenda(3));
		items.add(i);
		ItemPedidoCliente a = new ItemPedidoCliente();
		a.setCantidad(100);
		a.setPrecio(12);
		a.setPrenda(PrendaDAO.getInstancia().getPrenda(4));
		items.add(a);
		ped.setItemsPedidoCliente(items);
		ped.setPrecioTotal(5000);
		//System.out.println(ped.toDTO().getItemsPedidoCliente().get(0).getPrenda().getIdPrenda());
		AdministradorPedidos.getInstancia().nuevoPedido(ped.toDTO());
	
		
		
		
		
		
		
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
