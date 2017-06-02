package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.ClienteDTO;
import dto.EmpleadoDTO;

public interface InterfazRemota extends Remote {
	
	/*//AdministradorStock
	public void agregarLoteInsumo(LoteInsumoDTO loteInsumo);
	public void agregarBulto(BultoDTO bulto);
	public void agregarUbicacionLoteInsumo(LoteInsumoDTO lote);
	public void nuevoMovStock(MovimientoStockDTO movimiento);
	
	//Administrador Cliente
	public void bajaCliente(ClienteDTO cliente);
	public void modificarCliente(ClienteDTO cliente);*/
	public void altaCliente(ClienteDTO cli) throws RemoteException;
	
	/*//administrador Compras
	public void generarOrdenCompra(InsumoDTO insDTO);
	public void generarPedido(PedidoClienteDTO datosPedido);
	
	//AdministradorFacturacion
	public void generarFactura(PedidoClienteDTO pedido); 
	
	//Administadord Pedidos
	public void nuevoPedido(PedidoClienteDTO pedido);
	
	//Administrador Prenda
	public void generarPrenda(PrendaDTO prenda);
	public void bajaPrenda(PrendaDTO prenda);
	public void modificarPrenda(PrendaDTO prenda);
	
	//Administrador Produccion
	public void generarOrdenProduccionParcial(OppDTO opp);
	public void generarOrdenProduccionCompleta(OpcDTO opc);
	
	//AdministradorSucursales
	public void crearSucursal(SucursalDTO sucursal);
	public void altaEmpleado(EmpleadoDTO empleado);*/
	public EmpleadoDTO buscarLogin(EmpleadoDTO env) throws RemoteException;
	
	public ArrayList<ClienteDTO> listadoClientes() throws RemoteException;
	
	//despacho
	//falta agregar metodos al despacho
	
	
	
}
