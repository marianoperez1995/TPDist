package controladores;

import java.util.ArrayList;

import dto.FacturaDTO;
import dto.PedidoClienteDTO;
import negocio.Cliente;
import negocio.Factura;
import negocio.PedidoCliente;

public class AdministradorFacturacion {
	private ArrayList<Factura> facturas;
	private ArrayList<Cliente> clientes;
private static AdministradorFacturacion instancia = null;
	
	
	private static AdministradorFacturacion getInstancia (){
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
				c.update(c);
			}
		}
		Cliente aux =null;
		aux= aux.buscarCliente(numeroCliente);
		
		if(aux != null){
			aux.getCuentaCorriente().setBalanceActual(aux.getCuentaCorriente().getBalanceActual()-cantidad);
			aux.update(aux);
		}
	}

	private Factura buscarFactura(int numero) {
		for (Factura f : facturas){
			if (f.sosLaFactura (numero)){
				return f;
			}
		}
		Factura fact = null;
		fact = fact.buscarFactura( numero);
		
		return fact;
	}
	public void bajaFactura(int numero) {
		for (Factura f : facturas){
			if (f.sosLaFactura (numero)){
				facturas.remove(f);
				f.delete();
			}
		}
		Factura fact = null;
		fact = fact.buscarFactura( numero);
		
		if( fact != null){
			fact.delete();
		}
	}

	private Cliente buscarCliente(int numero) {
		for (Cliente c  : clientes){
			if (c.sosElCliente (numero)){
				return c;
			}
		}
		Cliente cli= null;
		cli = cli.buscarCliente(numero);
		
		return cli;
	}
	
	public FacturaDTO BuscarFactura (int numeroFactura){
		for (Factura f : facturas){
			if (f.sosLaFactura (numeroFactura)){
				return f.toDTO();
			}
		}
		Factura fact = null;
		fact = fact.buscarFactura( numeroFactura);
		
		return fact.toDTO();
	}
	public ArrayList<FacturaDTO> BuscarAllFactura (){
		ArrayList<FacturaDTO> list = null;
		ArrayList<Factura> aux= null;
		// Vale esto ? otra cosa no se me ocurrio, sin tener que llamar al dao desde aca
		Factura help=null;
		aux= help.buscarTodos();
				
		for (Factura f : aux){
				list.add(f.toDTO());
		}
		return list;
	}
}
