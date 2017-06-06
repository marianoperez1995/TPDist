package controladores;

import java.util.ArrayList;

import dto.ClienteDTO;
import dto.PedidoClienteDTO;
import negocio.PedidoCliente;
import persistencia.PedidoClienteDAO;

public class AdministradorPedidos {
	private static ArrayList<PedidoCliente> pedidos;
	private static AdministradorPedidos instancia = null;
	
	
	public static AdministradorPedidos getInstancia(){
		if(instancia== null){
			instancia= new AdministradorPedidos();
			pedidos = new ArrayList<PedidoCliente>();
		}
		return instancia;
	}

	public void nuevoPedido(PedidoClienteDTO pedido) {
		PedidoCliente pc= new PedidoCliente(pedido);
		pedidos.add(pc);
		pc.insert();
	}
	private PedidoCliente buscarPedidoCliente(int numero) {
		for (PedidoCliente pc : pedidos){
			if (pc.getNumPedidoCliente()== numero){
				return pc;
			}
		}
		PedidoCliente aux= null;
		aux = aux.buscarPedidoCliente(numero);
		
		return aux;
	}
	public void bajaPedidoCliente(int numero) {
		for (PedidoCliente pc : pedidos){
			if (pc.getNumPedidoCliente()== numero){
				pedidos.remove(pc);
				pc.delete();
			}
		}
		PedidoCliente aux= null;
		aux = aux.buscarPedidoCliente(numero);
		
		if(aux != null){
			aux.delete();
		}
	}
	
	public PedidoClienteDTO BuscarPedidoCliente (int numeroPedidoCliente){
		for (PedidoCliente pc : pedidos){
			if (pc.getNumPedidoCliente() == numeroPedidoCliente){
				return pc.toDTO();
			}
		}
		PedidoCliente fact = null;
		fact = fact.buscarPedidoCliente(numeroPedidoCliente);
		
		return fact.toDTO();
	}
	public ArrayList<PedidoClienteDTO> BuscarAllCliente (){
		ArrayList<PedidoCliente> prendas= PedidoClienteDAO.getInstancia().getAll();
		ArrayList<PedidoClienteDTO> prendasDTO= new ArrayList<PedidoClienteDTO>();
				
		for (PedidoCliente p : prendas){
				
				prendasDTO.add(p.toDTO());
		}
		return prendasDTO;
	}
	
}
