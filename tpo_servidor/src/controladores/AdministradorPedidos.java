package controladores;

import java.util.ArrayList;
import java.util.Calendar;

import dto.ClienteDTO;
import dto.OrdenProduccionDTO;
import dto.PedidoClienteDTO;
import negocio.Cliente;
import negocio.Factura;
import negocio.ItemPedidoCliente;
import negocio.OrdenProduccion;
import negocio.PedidoCliente;
import persistencia.FacturaDAO;
import persistencia.OrdenProduccionDAO;
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
	
	
	public void aprobarPedido(PedidoClienteDTO pedi){
		int ok=0;
		PedidoCliente ped= new PedidoCliente(pedi);
		for (ItemPedidoCliente item : ped.getItemsPedidoCliente()){
			if (!item.getPrenda().verificarCantidad(item.getCantidad())){
				ok=1;
				ped.generarOrdenProduccion(item);
				
			}
		}
		if (ok==1){
			ped.setEstado("En Fabricacion");
			
		}else{
			ped.setEstado("Completo");
		}
		PedidoClienteDAO.getInstancia().update(ped);
		
	}
	public PedidoCliente buscarPedidoCliente(int numero) {
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
	
	public void enviarPedido(PedidoClienteDTO seleccionado){
		seleccionado.setEstado("Enviado");
		PedidoClienteDAO.getInstancia().update(new PedidoCliente(seleccionado));
		Factura fac= new Factura();
		Cliente cli= new Cliente(seleccionado.getCliente());
		PedidoCliente ped= new PedidoCliente(seleccionado);
		fac.setCliente(cli);
		fac.setFechaGeneracion(Calendar.getInstance().getTime());
		float subtotal = ped.getPrecioTotal();
		float impuestos=  (float) (subtotal*0.21);
		fac.setImpuestos(impuestos);
		float total = subtotal + impuestos;
		fac.setPedido(ped);
		fac.setTotal(total);
		fac.setSubtotal(subtotal);
		int id=FacturaDAO.getInstancia().insert(fac);
		fac.generarPDF(id);		
		
	}

	public ArrayList<OrdenProduccionDTO> getAllOrdenes() {
		// TODO Auto-generated method stub
		ArrayList<OrdenProduccion> ord = OrdenProduccionDAO.getInstancia().getAll();
		ArrayList<OrdenProduccionDTO> carlos = new ArrayList<OrdenProduccionDTO>(); 
		for(OrdenProduccion c: ord){
			carlos.add(c.toDTO());
		}
		
		return carlos;
	}

	public OrdenProduccionDTO getOrden(OrdenProduccionDTO seleccionado) {
		return OrdenProduccionDAO.getInstancia().getOrdenProduccion(seleccionado.getIdOrden()).toDTO();
	}

	public ArrayList<PedidoClienteDTO> getPedidosDeCliente(ClienteDTO env) {
		ArrayList<PedidoCliente> prendas= PedidoClienteDAO.getInstancia().getPedidosDeCliente(env);
		ArrayList<PedidoClienteDTO> prendasDTO= new ArrayList<PedidoClienteDTO>();
				
		for (PedidoCliente p : prendas){		
				prendasDTO.add(p.toDTO());
		}
		return prendasDTO;
	}	
}
