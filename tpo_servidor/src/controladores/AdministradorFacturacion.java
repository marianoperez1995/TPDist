package controladores;

import java.util.ArrayList;

import dto.FacturaDTO;
import dto.PedidoClienteDTO;
import negocio.Cliente;
import negocio.Factura;
import negocio.PedidoCliente;
import persistencia.ClienteDAO;
import persistencia.FacturaDAO;

public class AdministradorFacturacion {
	private ArrayList<Factura> facturas;
	private ArrayList<Cliente> clientes;
	private static AdministradorFacturacion instancia = null;
	
	
	public static AdministradorFacturacion getInstancia (){
		if(instancia== null)
			instancia= new AdministradorFacturacion();
		return instancia;
	}
	
	
	public void generarFactura(PedidoClienteDTO pedido) {
		Factura f = new Factura(new PedidoCliente(pedido));
		facturas.add(f);
		f.insertar();
		
	}

	public void registrarPago(float cantidad, int numeroCliente) {
		for(Cliente c: clientes){
			if(c.sosElCliente(numeroCliente)){
				c.getCuentaCorriente().setBalanceActual(c.getCuentaCorriente().getBalanceActual()- cantidad);
				c.actualizar();
			}
		}
		Cliente aux = ClienteDAO.getInstancia().getCliente(numeroCliente);
		
		if(aux != null){
			aux.getCuentaCorriente().setBalanceActual(aux.getCuentaCorriente().getBalanceActual()-cantidad);
			aux.actualizar();
		}
	}

	public FacturaDTO buscarFactura(int numero) {
		return FacturaDAO.getInstancia().getFactura(numero).toDTO();	
	}
	
	public void bajaFactura(int numero) {
		for (Factura f : facturas){
			if (f.sosLaFactura (numero)){
				facturas.remove(f);
			}
		}
		FacturaDAO.getInstancia().eliminar(numero);
	}

	public Cliente buscarCliente(int numero) {
		for (Cliente c  : clientes){
			if (c.sosElCliente (numero)){
				return c;
			}
		}
		return ClienteDAO.getInstancia().getCliente(numero);
	}
	
	public ArrayList<Factura> BuscarAllFactura (){
		ArrayList<Factura> fact = new ArrayList<>();
		for (Factura f : this.facturas)
			fact.add(f);
		for (Factura f : FacturaDAO.getInstancia().getAll())
			fact.add(f);
		return fact;
	}
}
