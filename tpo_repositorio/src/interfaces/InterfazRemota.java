package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.ClienteDTO;
import dto.CuentaCorrienteDTO;
import dto.EmpleadoDTO;
import dto.PedidoClienteDTO;
import dto.PrendaDTO;

public interface InterfazRemota extends Remote {
	
	/*//AdministradorStock
	public void agregarLoteInsumo(LoteInsumoDTO loteInsumo) throws RemoteException;
	public void agregarBulto(BultoDTO bulto) throws RemoteException;
	public void agregarUbicacionLoteInsumo(LoteInsumoDTO lote) throws RemoteException;
	public void nuevoMovStock(MovimientoStockDTO movimiento) throws RemoteException;
	
	//Administrador Cliente
	public void bajaCliente(ClienteDTO cliente) throws RemoteException;*/
	public void modificarCliente(ClienteDTO cliente) throws RemoteException;
	public void altaCliente(ClienteDTO cli) throws RemoteException;
	public ArrayList<ClienteDTO> listadoClientes() throws RemoteException;
	
	/*//administrador Compras
	public void generarOrdenCompra(InsumoDTO insDTO) throws RemoteException;
	public void generarPedido(PedidoClienteDTO datosPedido) throws RemoteException;
	
	//AdministradorFacturacion
	public void generarFactura(PedidoClienteDTO pedido) throws RemoteException; 
	
	//Administadord Pedidos
	public int nuevoPedido(PedidoClienteDTO pedido) throws RemoteException;
	
	//Administrador Prenda
	public void generarPrenda(PrendaDTO prenda) throws RemoteException;
	public void bajaPrenda(PrendaDTO prenda) throws RemoteException;
	public void modificarPrenda(PrendaDTO prenda) throws RemoteException;
	
	//Administrador Produccion
	public void generarOrdenProduccionParcial(OppDTO opp) throws RemoteException;
	public void generarOrdenProduccionCompleta(OpcDTO opc) throws RemoteException;
	
	//AdministradorSucursales
	public void crearSucursal(SucursalDTO sucursal) throws RemoteException;
	public void altaEmpleado(EmpleadoDTO empleado) throws RemoteException;*/
	public EmpleadoDTO buscarLogin(EmpleadoDTO env) throws RemoteException;
	public ClienteDTO obtenerCliente(ClienteDTO b) throws RemoteException;
	public CuentaCorrienteDTO buscarCuenta(CuentaCorrienteDTO cuenta) throws RemoteException;
	public void bajaCliente(ClienteDTO nuevo) throws RemoteException;
	public void rechazarCliente(ClienteDTO nuevo) throws RemoteException;
	public ArrayList<PrendaDTO> getPrendas() throws RemoteException;
	public PrendaDTO getPrenda(int id, int talle, int color) throws RemoteException;
	public void modificarPrenda(PrendaDTO prenda)throws RemoteException;
	public ArrayList<PedidoClienteDTO> getPedidos() throws RemoteException;
	public void aumentarLimiteCredito(ClienteDTO cliente, float limite) throws RemoteException;
	public int nuevoPedidoCliente(PedidoClienteDTO pedido) throws RemoteException;

	//despacho
	//falta agregar metodos al despacho
	
	
	
}
