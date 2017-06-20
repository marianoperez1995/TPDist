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

	public int nuevoPedido(PedidoClienteDTO pedido) {
		PedidoCliente pc= new PedidoCliente(pedido);
		//verifica si el precio del pedido es inferior o igual al limite 
		if(pc.getCliente().verificarLimite(pedido.getPrecioTotal())){
		pedidos.add(pc);
		PedidoClienteDAO.getInstancia().insert(pc);
		AdministradorStock.getInstancia().disminuirStockPorPedido(pc.getItemsPedidoCliente());;
		return pc.getIdPedidoCliente();
		}
		return 0;
	}
	
	
	
	private PedidoCliente buscarPedidoCliente(int numero) {
		for (PedidoCliente pc : pedidos){
			if (pc.getIdPedidoCliente()== numero){
				return pc;
			}
		}
		PedidoCliente aux= null;
		aux = PedidoClienteDAO.getInstancia().getPedidoCliente(numero);
		
		return aux;
	}
	public float bajaPedidoCliente(int numero) {
		for (PedidoCliente pc : pedidos){
			if (pc.getIdPedidoCliente()== numero){
				pedidos.remove(pc);
				PedidoClienteDAO.getInstancia().eliminar(numero);
				return pc.montoAPagarEnCasoDeCancelacion();
			}
		}
		PedidoCliente aux= null;
		aux = PedidoClienteDAO.getInstancia().getPedidoCliente(numero);
		
		if(aux != null){
			PedidoClienteDAO.getInstancia().eliminar(numero);
			return aux.montoAPagarEnCasoDeCancelacion();
		}
		return 0;
		
	}
	
	public PedidoClienteDTO BuscarPedidoCliente (int numeroPedidoCliente){
		for (PedidoCliente pc : pedidos){
			if (pc.getIdPedidoCliente() == numeroPedidoCliente){
				return pc.toDTO();
			}
		}
		PedidoCliente fact = null;
		fact=PedidoClienteDAO.getInstancia().getPedidoCliente(numeroPedidoCliente);
		
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
