package objetoRemoto;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import controladores.AdministradorClientes;
import controladores.AdministradorFacturacion;
import controladores.AdministradorPedidos;
import controladores.AdministradorPrenda;
import controladores.AdministradorSucursales;
import dto.ClienteDTO;
import dto.CuentaCorrienteDTO;
import dto.EmpleadoDTO;
import dto.FacturaDTO;
import dto.OrdenProduccionDTO;
import dto.PagoDTO;
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

	public int nuevoPedido(PedidoClienteDTO pedido) {
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

	@Override
	public void enviarPedido(PedidoClienteDTO seleccionado) throws RemoteException {
		// TODO Auto-generated method stub
		AdministradorPedidos.getInstancia().enviarPedido(seleccionado);
	}

	@Override
	public ArrayList<OrdenProduccionDTO> getOrdenes() throws RemoteException {
		// TODO Auto-generated method stub
		return AdministradorPedidos.getInstancia().getAllOrdenes();
	}

	@Override
	public OrdenProduccionDTO getOrden(OrdenProduccionDTO seleccionado) throws RemoteException {
		// TODO Auto-generated method stub
		return AdministradorPedidos.getInstancia().getOrden(seleccionado);
	}

	@Override
	public void aprobarPedido(PedidoClienteDTO seleccionado) throws RemoteException {
		AdministradorPedidos.getInstancia().aprobarPedido(seleccionado);
	}

	@Override
	public ArrayList<PrendaDTO> getPrendaPorNombre(PrendaDTO prenda) throws RemoteException {
		
		return AdministradorPrenda.getInstancia().getPrendaPorNombre(prenda);
	}

	@Override
	public ArrayList<PrendaDTO> buscarPrendasPorColorYNombre(PrendaDTO prenda) throws RemoteException {
		return AdministradorPrenda.getInstancia().getPrendaPorNombreYColor(prenda);
	}

	@Override
	public ClienteDTO buscarLoginCliente(ClienteDTO env) throws RemoteException {
		return AdministradorClientes.getInstancia().buscarLoginCliente(env);
	}

	@Override
	public ArrayList<PedidoClienteDTO> buscarPedidosDeCliente(ClienteDTO env) throws RemoteException {
		return AdministradorPedidos.getInstancia().getPedidosDeCliente(env);
	}

	@Override
	public FacturaDTO buscarFactura(FacturaDTO factSel) throws RemoteException {
		return AdministradorFacturacion.getInstancia().buscarFactura(factSel.getPedido().getIdPedidoCliente());
	}

	@Override
	public ArrayList<PagoDTO> buscarPagos(ClienteDTO seleccionado) throws RemoteException {
		// TODO Auto-generated method stub
		return AdministradorFacturacion.getInstancia().buscarPagos(seleccionado.getNumeroCliente());
	}

	@Override
	public void agregarPago(PagoDTO pago) throws RemoteException {
		AdministradorFacturacion.getInstancia().agregarPago(pago);
	}
	
}
	

