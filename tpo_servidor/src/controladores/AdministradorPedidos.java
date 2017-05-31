package controladores;

import java.util.ArrayList;

import dto.PedidoClienteDTO;
import negocio.PedidoCliente;

public class AdministradorPedidos {
	private ArrayList<PedidoCliente> pedidosPendientes;
private static AdministradorPedidos instancia = null;
	
	
	private static AdministradorPedidos getInstancia (){
		if(instancia== null)
			instancia= new AdministradorPedidos();
		return instancia;
	}

	public void nuevoPedido(PedidoClienteDTO pedido) {
		PedidoCliente pc= new PedidoCliente(pedido);
		pedidosPendientes.add(pc);
		pc.insert();
	}
	private PedidoCliente buscarPedidoCliente(int numero) {
		for (PedidoCliente pc : pedidosPendientes){
			if (pc.getNumPedidoCliente()== numero){
				return pc;
			}
		}
		PedidoCliente aux= null;
		aux = aux.buscarPedidoCliente(numero);
		
		return aux;
	}
	public void bajaPedidoCliente(int numero) {
		for (PedidoCliente pc : pedidosPendientes){
			if (pc.getNumPedidoCliente()== numero){
				pedidosPendientes.remove(pc);
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
		for (PedidoCliente pc : pedidosPendientes){
			if (pc.getNumPedidoCliente() == numeroPedidoCliente){
				return pc.toDTO();
			}
		}
		PedidoCliente fact = null;
		fact = fact.buscarPedidoCliente(numeroPedidoCliente);
		
		return fact.toDTO();
	}
	public ArrayList<PedidoClienteDTO> BuscarAllCliente (){
		ArrayList<PedidoClienteDTO> list = null;
		ArrayList<PedidoCliente> aux= null;
		// Vale esto ? otra cosa no se me ocurrio, sin tener que llamar al dao desde aca
		PedidoCliente help=null;
		aux= help.buscarTodos();
				
		for (PedidoCliente pc : aux){
				list.add(pc.toDTO());
		}
		return list;
	}
	
}
