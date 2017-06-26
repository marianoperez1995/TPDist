package controladores;

import java.util.ArrayList;
import java.util.Calendar;

import dto.PedidoClienteDTO;
import negocio.Cliente;
import negocio.Factura;
import negocio.ItemPedidoCliente;
import negocio.OrdenProduccion;
import negocio.PedidoCliente;
import negocio.Prenda;
import persistencia.FacturaDAO;
import persistencia.PedidoClienteDAO;
import persistencia.PrendaDAO;

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

	public PedidoClienteDTO getPedido(PedidoClienteDTO seleccionado) {
		PedidoCliente ped= PedidoClienteDAO.getInstancia().getPedidoCliente(seleccionado.getIdPedidoCliente());
		return ped.toDTO();
	}

	public String verificarPedido(PedidoClienteDTO seleccionado) {
		PedidoCliente ped= PedidoClienteDAO.getInstancia().getPedidoCliente(seleccionado.getIdPedidoCliente());
		return ped.verificarPedido();
	}

	public void modificarPedido(PedidoClienteDTO seleccionado) {
		PedidoClienteDAO.getInstancia().update(new PedidoCliente(seleccionado));
		
	}
	
	public void completarPedido(PedidoClienteDTO seleccionado){
				
		PedidoClienteDAO.getInstancia().update(new PedidoCliente(seleccionado));
		Factura fac= new Factura();
		Cliente cli= new Cliente(seleccionado.getCliente());
		PedidoCliente ped= new PedidoCliente(seleccionado);
		
		//CHEQUEAR QUE HAYA PRENDAS SUFICIENTES PARA EL PEDIDO ANTES DE INGRESAR FACT
		for (ItemPedidoCliente item : ped.getItemsPedidoCliente()){
			Prenda p = PrendaDAO.getInstancia().getPrenda(item.getPrenda().getIdPrenda());
			//aca si se pasaba del stock minimo se aprobaba igual si habia suficientes? asumo que si, y setea cantidadaconfeccionar
			//a la diferencia
			if (p.getStockActual() >= item.getCantidad()){
				PrendaDAO.getInstancia().disminuirStock(item.getPrenda(), item.getCantidad());
				p.disminuirStock(item.getCantidad());
			}
			else{
				System.out.println("No hay prendas suficientes para completar el pedido indicado");
				return;
			}
			//reviso si se paso del stockmin
			if (p.getStockMinimo() > p.getStockActual()){
				p.setCantidadAConfeccionar(p.getStockMinimo());
				System.out.println("Se deberian mandar a hacer "+p.getStockMinimo()+" de la prenda "+item.getPrenda().getIdPrenda());
			}			
			else 
				p.setCantidadAConfeccionar(0); //Por defecto siempre deberia ser 0, solo cambiaria en el if de arriba
		}	
		////////////////////////////
		fac.setCliente(cli);
		fac.setFechaGeneracion(Calendar.getInstance().getTime());
		fac.setImpuestos(35);
		fac.setPedido(ped);
		fac.setTotal(ped.getPrecioTotal());
		int id=FacturaDAO.getInstancia().insert(fac);
		fac.generarPDF(id);		
	
		
	}	
}
