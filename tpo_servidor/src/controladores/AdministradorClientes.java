package controladores;

import java.util.ArrayList;

import dto.ClienteDTO;
import negocio.Cliente;
import negocio.CuentaCorriente;
import negocio.Factura;
import negocio.Sucursal;

public class AdministradorClientes {
	private static AdministradorClientes instancia;
	private ArrayList<Cliente> clientes;

	public static AdministradorClientes getInstancia (){
		if(instancia== null)
			instancia= new AdministradorClientes();
		return instancia;
	}
	
	public void agregarCliente(ClienteDTO cliDTO) {
		Cliente cli = new Cliente(cliDTO);
		clientes.add(cli);
		cli.insertar();
	}

	public void bajaCliente(ClienteDTO cliente) {	
		for (Cliente c : clientes){
			if (c.sosElCliente(cliente.getNumeroCliente())) {
				clientes.remove(c);
				return; //revisar si esta bien poner estos return aca...
			}
		}
	}

	public void modificarCliente(ClienteDTO cliente) { //modificar este metodo 
		for (Cliente c: clientes){
			if (c.sosElCliente(cliente.getNumeroCliente())){
				c.setCategoria(cliente.getCategoria());
				c.setCuentaCorriente(new CuentaCorriente(cliente.getCuentaCorriente()));
				c.setCuit(cliente.getCuit());
				c.setDireccion(cliente.getDireccion());
				c.setFactura(new Factura(cliente.getFactura()));
				c.setInformacionAdicional(cliente.getInformacionAdicional());
				c.setNombre(cliente.getNombre());
				c.setSucursal(new Sucursal(cliente.getSucursal()));
			}
	}
	}

	private Cliente buscarCliente(int numeroCliente) {
		for (Cliente c: clientes){
			if (c.sosElCliente(numeroCliente)){
				return c;
			}	
		}
		return null;

	}
}
