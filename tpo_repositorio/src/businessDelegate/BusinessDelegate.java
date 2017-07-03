package businessDelegate;

import interfaces.InterfazRemota;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.ClienteDTO;
import dto.CuentaCorrienteDTO;
import dto.EmpleadoDTO;
import dto.FacturaDTO;
import dto.OrdenProduccionDTO;
import dto.PagoDTO;
import dto.PedidoClienteDTO;
import dto.PrendaDTO;
import dto.ReclamoDTO;

public class BusinessDelegate {
	private static BusinessDelegate instancia;
	private InterfazRemota objetoRemoto;
	
	private BusinessDelegate() {
		
	}
	public static BusinessDelegate getInstancia(){
		if (instancia==null){
			instancia= new BusinessDelegate();
			instancia.getStub();
		}
		return instancia;
	}
    public void getStub() {
    	  
			try {
				

				objetoRemoto = (InterfazRemota)Naming.lookup ("//localhost/ObjetoRemoto");
				
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //obtiene la refencia del ojeto remoto

    }
    
    public boolean estoyConectado(){
		if(objetoRemoto != null){
			return true;
		}
    	return false;
    }
    
    /*public void altaEmpleado(EmpleadoDTO empleado) throws RemoteException{
    	
    	objetoRemoto.altaEmpleado(empleado);
   
    }*/
    
    public EmpleadoDTO buscarLogin(EmpleadoDTO env) throws RemoteException{
    	
		return objetoRemoto.buscarLogin(env);
    }
    
	public void altaClientePendiente(ClienteDTO cli) throws RemoteException {
		// TODO Auto-generated method stub
		objetoRemoto.altaClientePendiente(cli);
	}
	
	public ArrayList<ClienteDTO> listadoClientes() throws RemoteException {
		// TODO Auto-generated method stub
		return objetoRemoto.listadoClientes();
	}
	
	public ArrayList<PrendaDTO> getPrendasPorNombre(PrendaDTO prenda) throws RemoteException{
		return objetoRemoto.getPrendaPorNombre(prenda);
	}
	
	public ClienteDTO buscarCliente(ClienteDTO b) throws RemoteException {
		// TODO Auto-generated method stub
		return objetoRemoto.obtenerCliente(b);
	}
	
	public CuentaCorrienteDTO buscarCuenta(CuentaCorrienteDTO cuenta) throws RemoteException {
		// TODO Auto-generated method stu
		return objetoRemoto.buscarCuenta(cuenta);
	}
	public void modificarCliente(ClienteDTO cliente) throws RemoteException {
		objetoRemoto.modificarCliente(cliente);
	}
	public void bajaCliente(ClienteDTO nuevo) throws RemoteException {
		objetoRemoto.bajaCliente(nuevo);
	}
	public void rechazarCliente(ClienteDTO nuevo) throws RemoteException{
		// TODO Auto-generated method stub
		objetoRemoto.rechazarCliente(nuevo);
	}
	public ArrayList<PrendaDTO> getPrendas() throws RemoteException {
		return objetoRemoto.getPrendas();
	}
	public PrendaDTO getPrenda(int id)  throws RemoteException {
		return objetoRemoto.getPrenda(id);
	}
	public void modificarPrenda(PrendaDTO prenda)   throws RemoteException {
		 objetoRemoto.modificarPrenda(prenda);
		
	}
	public ArrayList<PedidoClienteDTO> getPedidos() throws RemoteException {
		return objetoRemoto.getPedidos();
	}
	
	public void aumentarLimiteCredito(ClienteDTO cliente, float limite) throws RemoteException{
		objetoRemoto.aumentarLimiteCredito(cliente, limite);
	}
	public int nuevoPedidoCliente(PedidoClienteDTO pedido) throws RemoteException{
		return	objetoRemoto.nuevoPedidoCliente(pedido);
		
	}
	public void altaCliente(ClienteDTO nuevo) throws RemoteException{
		// TODO Auto-generated method stub
		objetoRemoto.altaCliente(nuevo);
	}
	public PedidoClienteDTO buscarPedido(PedidoClienteDTO seleccionado) throws RemoteException {
		// TODO Auto-generated method stub
		return objetoRemoto.buscarPedido(seleccionado);
	}
	public void nuevoReclamo(ReclamoDTO reclamo) throws RemoteException {
		// TODO Auto-generated method stub
		objetoRemoto.altaReclamo(reclamo);
	}
	public ReclamoDTO buscarReclamo(ReclamoDTO reclamo) throws RemoteException {
		// TODO Auto-generated method stub
		return objetoRemoto.getReclamo(reclamo);
	}
	public ArrayList<ReclamoDTO> listadoReclamos() throws RemoteException{
		// TODO Auto-generated method stub
		return objetoRemoto.getListadoReclamos();
	}
	public String verificarPedido(PedidoClienteDTO seleccionado) throws RemoteException{
		return objetoRemoto.verificarPedido(seleccionado);
	}
	public void modificarPedidoCliente(PedidoClienteDTO seleccionado) throws RemoteException {
		objetoRemoto.modificarPedidoCliente(seleccionado);
		
	}
	public void enviarPedido(PedidoClienteDTO seleccionado) throws RemoteException {
		// TODO Auto-generated method stub
		objetoRemoto.enviarPedido(seleccionado);
	}
	public ArrayList<OrdenProduccionDTO> getOrdenes() throws RemoteException {
		// TODO Auto-generated method stub
		return objetoRemoto.getOrdenes();
	}
	public OrdenProduccionDTO buscarOrden(OrdenProduccionDTO seleccionado) throws RemoteException {
		return objetoRemoto.getOrden(seleccionado);
	}
	public void aprobarPedido(PedidoClienteDTO seleccionado) throws RemoteException {
		// TODO Auto-generated method stub
		objetoRemoto.aprobarPedido(seleccionado);
	}
	public ClienteDTO buscarLoginCliente(ClienteDTO env) throws RemoteException {
		// TODO Auto-generated method stub
		return objetoRemoto.buscarLoginCliente(env);
	}
	public ArrayList<PrendaDTO> buscarPrendaPorNombre(PrendaDTO prenda) throws RemoteException {
		return objetoRemoto.getPrendaPorNombre(prenda);
	}
	public ArrayList<PrendaDTO> buscarPrendaPorNombreYColor(PrendaDTO prenda) throws RemoteException {
		return objetoRemoto.buscarPrendasPorColorYNombre(prenda);
	}
	public ArrayList<PedidoClienteDTO> obtenerPedidosDeCliente(ClienteDTO env) throws RemoteException {
		return objetoRemoto.buscarPedidosDeCliente(env);
	}
	public FacturaDTO buscarFactura(FacturaDTO factSel) throws RemoteException  {
		return objetoRemoto.buscarFactura(factSel);
	}
	public void cancelarPedido(PedidoClienteDTO ped) throws RemoteException  {
		objetoRemoto.cancelarPedido(ped);
		
	}
	public void confirmarClientePedido(PedidoClienteDTO ped) throws RemoteException  {
		objetoRemoto.confirmarClientePedido(ped);
		
	}
	public PrendaDTO buscarPrendaPorNombreYColorYTalle(String color, String prenda, String talle) throws RemoteException  {
		return objetoRemoto.buscarPrendaPorNombreYColorYTalle(color,  prenda, talle);
	}
	public void altaPedido(PedidoClienteDTO pedido) throws RemoteException {
		 objetoRemoto.altaPedido(pedido);
		
	}
	public ArrayList<PagoDTO> buscarPagos(ClienteDTO seleccionado) throws RemoteException  {
		return objetoRemoto.buscarPagos(seleccionado);
	}
	public void agregarPago(PagoDTO pago)  throws RemoteException  {
		objetoRemoto.agregarPago(pago);
	}

}
