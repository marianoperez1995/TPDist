package controladores;

import java.util.ArrayList;

import dto.ClienteDTO;
import dto.PedidoClienteDTO;
import negocio.Cliente;
import negocio.OrdenProduccion;
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
			System.out.println("El limite de precio del cliente permite el ingreso del pedido"+pedido.getIdPedidoCliente());
		//verifica si hay stock y puede generar una orden de compra
		ArrayList<OrdenProduccion> ordenes=new ArrayList<OrdenProduccion>();
		ordenes=AdministradorStock.getInstancia().verificarStockyGenerarOrdenes(pc);
		AdministradorStock.getInstancia().disminuirStockPorPedido(pc.getItemsPedidoCliente());
		//el pedido aux tiene el ID del pedido generado por la base de datos
		PedidoCliente aux=PedidoClienteDAO.getInstancia().insert(pc);
		AdministradorProduccion.getInstancia().persistirOrdenes(aux, ordenes);
		pedidos.add(aux);
		return aux.getIdPedidoCliente();
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
	public ArrayList<PedidoClienteDTO> getAllPedidos (){
		ArrayList<PedidoCliente> prendas= PedidoClienteDAO.getInstancia().getAll();
		ArrayList<PedidoClienteDTO> prendasDTO= new ArrayList<PedidoClienteDTO>();
				
		for (PedidoCliente p : prendas){		
				prendasDTO.add(p.toDTO());
		}
		return prendasDTO;
	}

	public void agregarPedido(PedidoClienteDTO dto) {
		PedidoCliente ped = new PedidoCliente(dto);
		pedidos.add(ped);
		ped.insertar();
	}
	
}
