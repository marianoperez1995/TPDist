package objetoRemoto;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import controladores.AdministradorClientes;
import controladores.AdministradorPedidos;
import controladores.AdministradorPrenda;
import controladores.AdministradorSucursales;
import dto.ClienteDTO;
import dto.CuentaCorrienteDTO;
import dto.EmpleadoDTO;
import dto.PedidoClienteDTO;
import dto.PrendaDTO;
import dto.ReclamoDTO;
import interfaces.InterfazRemota;

public class ObjetoRemoto extends UnicastRemoteObject implements InterfazRemota,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1285941708135636555L;

	public ObjetoRemoto() throws RemoteException{
		// TODO Auto-generated constructor stub
	}
	

	public EmpleadoDTO buscarLogin(EmpleadoDTO empleado) throws RemoteException{
		return AdministradorSucursales.getInstancia().buscarLogin(empleado);
	}
	
	public ArrayList<ClienteDTO> listadoClientes() throws RemoteException{
		return AdministradorClientes.getInstancia().listadoClientes();
	}
	
	@Override
	public void altaClientePendiente(ClienteDTO cli) throws RemoteException {
		// TODO Auto-generated method stub
		AdministradorClientes.getInstancia().agregarCliente(cli);
	}

	@Override
	public void modificarCliente(ClienteDTO cliente) throws RemoteException {
		// TODO Auto-generated method stub
		AdministradorClientes.getInstancia().modificarCliente(cliente);
	}

	@Override
	public ClienteDTO obtenerCliente(ClienteDTO b) throws RemoteException {
		
		return AdministradorClientes.getInstancia().obtenerCliente(b);
	}

	@Override
	public CuentaCorrienteDTO buscarCuenta(CuentaCorrienteDTO cuenta) throws RemoteException {
		return AdministradorClientes.getInstancia().obtenerCuenta(cuenta);
	}

	@Override
	public void bajaCliente(ClienteDTO nuevo) throws RemoteException {
		// TODO Auto-generated method stub
		AdministradorClientes.getInstancia().bajaCliente(nuevo);
	}

	@Override
	public void rechazarCliente(ClienteDTO nuevo) throws RemoteException {
		// TODO Auto-generated method stub
		AdministradorClientes.getInstancia().rechazarCliente(nuevo);
	}

	@Override
	public void altaCliente(ClienteDTO nuevo) throws RemoteException {
		// TODO Auto-generated method stub
		AdministradorClientes.getInstancia().darDeAltaCliente(nuevo);
	}
	
	@Override
	public ArrayList<PrendaDTO> getPrendas() throws RemoteException {
		// TODO Auto-generated method stub
		return AdministradorPrenda.getInstancia().buscarAllPrenda();
	}

	@Override
	public PrendaDTO getPrenda(int id) throws RemoteException {
		return AdministradorPrenda.getInstancia().getPrenda(id);
	}

	@Override
	public void modificarPrenda(PrendaDTO prenda) throws RemoteException {
		AdministradorPrenda.getInstancia().modificarPrenda(prenda);
		
	}

	@Override
	public ArrayList<PedidoClienteDTO> getPedidos() throws RemoteException {
		return AdministradorPedidos.getInstancia().getAllPedidos();
	}
	
	
	public int nuevoPedidoCliente(PedidoClienteDTO pedido) {
		return AdministradorPedidos.getInstancia().nuevoPedido(pedido);
	}

	@Override
	public void aumentarLimiteCredito(ClienteDTO cliente, float limite) throws RemoteException {
		AdministradorClientes.getInstancia().aumentarLimiteCreditoCliente(limite, cliente);

	}

	@Override
	public PedidoClienteDTO buscarPedido(PedidoClienteDTO seleccionado) throws RemoteException {
		return AdministradorPedidos.getInstancia().getPedido(seleccionado);
	}

	@Override
	public void altaReclamo(ReclamoDTO reclamo) throws RemoteException {
		AdministradorClientes.getInstancia().crearReclamo(reclamo);
	}

	@Override
	public ReclamoDTO getReclamo(ReclamoDTO reclamo) throws RemoteException {
		return AdministradorClientes.getInstancia().getReclamo(reclamo);
	}

	@Override
	public ArrayList<ReclamoDTO> getListadoReclamos() throws RemoteException {
		// TODO Auto-generated method stub
		return AdministradorClientes.getInstancia().getListadoReclamos();
	}

	@Override
	public String verificarPedido(PedidoClienteDTO seleccionado) throws RemoteException {
		return AdministradorPedidos.getInstancia().verificarPedido(seleccionado);
	}

	@Override
	public void modificarPedidoCliente(PedidoClienteDTO seleccionado) throws RemoteException {
		AdministradorPedidos.getInstancia().modificarPedido(seleccionado);
		
	}
	
	
	
	}
	

