package objetoRemoto;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import controladores.AdministradorClientes;
import controladores.AdministradorSucursales;
import dto.ClienteDTO;
import dto.CuentaCorrienteDTO;
import dto.EmpleadoDTO;
import interfaces.InterfazRemota;

public class ObjetoRemoto extends UnicastRemoteObject implements InterfazRemota,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1285941708135636555L;

	public ObjetoRemoto() throws RemoteException{
		// TODO Auto-generated constructor stub
	}
	
	/*
	public void agregarLoteInsumo(LoteInsumoDTO loteInsumo) {
		Sistema.getInstancia().getAdmStock().agregarLoteInsumo(loteInsumo);
		
	}

	public void agregarBulto(BultoDTO bulto) {
		Sistema.getInstancia().getAdmStock().agregarBulto(bulto);
		
	}

	public void agregarUbicacionLoteInsumo(LoteInsumoDTO lote) {
		Sistema.getInstancia().getAdmStock().agregarUbicacionLoteInsumo(lote);
		
	}


	public void nuevoMovStock(MovimientoStockDTO movimiento) {
		Sistema.getInstancia().getAdmStock().nuevoMovimientoStock(movimiento);
		
	}

	public void bajaCliente(ClienteDTO cliente) {
		Sistema.getInstancia().getAdmClientes().bajaCliente(cliente);
		
	}

	public void modificarCliente( ClienteDTO cliente) {
		Sistema.getInstancia().getAdmClientes().modificarCliente( cliente);
		
	}

	public void agregarCliente(ClienteDTO cliDTO) {
		Sistema.getInstancia().getAdmClientes().agregarCliente(cliDTO);
		
	}

	public void generarOrdenCompra(InsumoDTO insDTO) {
		Sistema.getInstancia().getAdmCompras().generarOrdenCompra(insDTO);
		
	}

	public void generarPedido(PedidoClienteDTO datosPedido) {
		Sistema.getInstancia().getAdmCompras().generarPedido(datosPedido);
		
	}

	public void generarFactura(PedidoClienteDTO pedido) {
		Sistema.getInstancia().getAdministradorFacutacion().generarFactura(pedido);
		
	}

	public void nuevoPedido(PedidoClienteDTO pedido) {
		Sistema.getInstancia().getAdmPedidos().nuevoPedido(pedido);
	}

	public void generarPrenda(PrendaDTO prenda) {
		Sistema.getInstancia().getAdmPrendas().generarPrenda(prenda);
		
	}

	public void bajaPrenda(PrendaDTO prenda) {
		Sistema.getInstancia().getAdmPrendas().bajaPrenda(prenda);
		
	}

	public void modificarPrenda(PrendaDTO prenda) {
		Sistema.getInstancia().getAdmPrendas().modificarPrenda(prenda);
		
	}

	public void generarOrdenProduccionParcial(OppDTO opp) {
		Sistema.getInstancia().getAdmProduccion().generarOrdenProduccionParcial(opp);
	}

	public void generarOrdenProduccionCompleta(OpcDTO opc) {
		Sistema.getInstancia().getAdmProduccion().generarOrdenProduccionCompleta(opc);
		
	}

	public void crearSucursal(SucursalDTO sucursal) {
		Sistema.getInstancia().getAdmSucursales().crearSucursal(sucursal);
		
	}

	public void altaEmpleado(EmpleadoDTO empleado) {
		Sistema.getInstancia().getAdmSucursales().altaEmpleado(empleado);
		
	}*/
	
	public EmpleadoDTO buscarLogin(EmpleadoDTO empleado) throws RemoteException{
		return AdministradorSucursales.getInstancia().buscarLogin(empleado);
	}
	
	public ArrayList<ClienteDTO> listadoClientes() throws RemoteException{
		return AdministradorClientes.getInstancia().listadoClientes();
	}
	
	@Override
	public void altaCliente(ClienteDTO cli) throws RemoteException {
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
	
}
