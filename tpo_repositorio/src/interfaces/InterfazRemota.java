package interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.BultoDTO;
import dto.ClienteDTO;
import dto.CuentaCorrienteDTO;
import dto.EmpleadoDTO;
import dto.FacturaDTO;
import dto.InsumoDTO;
import dto.OrdenProduccionDTO;
import dto.PagoDTO;
import dto.PedidoClienteDTO;
import dto.PrendaDTO;
import dto.ReclamoDTO;

public interface InterfazRemota extends Remote {
	
	/*//AdministradorStock
	public void agregarLoteInsumo(LoteInsumoDTO loteInsumo) throws RemoteException;
	public void agregarBulto(BultoDTO bulto) throws RemoteException;
	public void agregarUbicacionLoteInsumo(LoteInsumoDTO lote) throws RemoteException;
	public void nuevoMovStock(MovimientoStockDTO movimiento) throws RemoteException;
	
	//Administrador Cliente
	public void bajaCliente(ClienteDTO cliente) throws RemoteException;*/
	public void modificarCliente(ClienteDTO cliente) throws RemoteException;
	public void altaClientePendiente(ClienteDTO cli) throws RemoteException;
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
	
	public void modificarPrenda(PrendaDTO prenda)throws RemoteException;
	public ArrayList<PedidoClienteDTO> getPedidos() throws RemoteException;
	public void aumentarLimiteCredito(ClienteDTO cliente, float limite) throws RemoteException;
	public int nuevoPedidoCliente(PedidoClienteDTO pedido) throws RemoteException;
	public void altaCliente(ClienteDTO nuevo) throws RemoteException;
	PrendaDTO getPrenda(int id) throws RemoteException;
	public PedidoClienteDTO buscarPedido(PedidoClienteDTO seleccionado) throws RemoteException;
	public void altaReclamo(ReclamoDTO reclamo) throws RemoteException;
	public ReclamoDTO getReclamo(ReclamoDTO reclamo) throws RemoteException;
	public ArrayList<ReclamoDTO> getListadoReclamos() throws RemoteException;
	public String verificarPedido(PedidoClienteDTO seleccionado)throws RemoteException;
	public void modificarPedidoCliente(PedidoClienteDTO seleccionado) throws RemoteException;
	public void enviarPedido(PedidoClienteDTO seleccionado) throws RemoteException;
	public ArrayList<OrdenProduccionDTO> getOrdenes() throws RemoteException;
	public OrdenProduccionDTO getOrden(OrdenProduccionDTO seleccionado) throws RemoteException;
	public void aprobarPedido(PedidoClienteDTO seleccionado) throws RemoteException;
	public ArrayList<PrendaDTO> getPrendaPorNombre(PrendaDTO prenda)throws RemoteException;
	public ArrayList<PrendaDTO> buscarPrendasPorColorYNombre(PrendaDTO prenda) throws RemoteException;
	public ClienteDTO buscarLoginCliente(ClienteDTO env)throws RemoteException;
	public ArrayList<PedidoClienteDTO> buscarPedidosDeCliente(ClienteDTO env)throws RemoteException;
	public FacturaDTO buscarFactura(FacturaDTO factSel)throws RemoteException;
	public ArrayList<PagoDTO> buscarPagos(ClienteDTO seleccionado) throws RemoteException;
	public void agregarPago(PagoDTO pago) throws RemoteException;
	public void cancelarPedido(PedidoClienteDTO ped) throws RemoteException;
	public void confirmarClientePedido(PedidoClienteDTO ped) throws RemoteException;
	public PrendaDTO buscarPrendaPorNombreYColorYTalle(String color, String prenda, String talle)throws RemoteException;
	public void altaPedido(PedidoClienteDTO pedido)throws RemoteException;
	public void fabricarOrden(OrdenProduccionDTO seleccionado) throws RemoteException;
	public void altaPrenda(PrendaDTO prenda) throws RemoteException;
	public ArrayList<InsumoDTO> getInsumos() throws RemoteException;
	public InsumoDTO getInsumo(InsumoDTO insumo1) throws RemoteException;
	public ArrayList<BultoDTO> buscarBultoPorId(int idPrenda) throws RemoteException;

	//despacho
	//falta agregar metodos al despacho
	
	
	
}
