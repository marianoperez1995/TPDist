package controladores;

import java.util.ArrayList;

import dto.ClienteDTO;
import dto.PedidoClienteDTO;
import negocio.Cliente;
import negocio.CuentaCorriente;
import negocio.PedidoCliente;
import negocio.Sucursal;
import persistencia.ClienteDAO;

public class AdministradorClientes {
	private ArrayList<Cliente> clientes;

	public void agregarCliente(ClienteDTO cliDTO) {
		Cliente cli = new Cliente(cliDTO);
		clientes.add(cli);
		cli.insertar();
	}

	public void bajaCliente(ClienteDTO cliente) {
		for (Cliente c : clientes) {
			if (c.sosElCliente(cliente.getNumeroCliente())) {
				clientes.remove(c);
			}
		}
		Cliente c = new Cliente(cliente);
		c.borrar();
	}

	public void modificarCliente(ClienteDTO cliente) {
		// Busco en array y modifico ahi
		for (Cliente c : clientes) {
			if (c.sosElCliente(cliente.getNumeroCliente())) {
				c.setCuentaCorriente(new CuentaCorriente(cliente.getCuentaCorriente()));
				c.setCuit(cliente.getCuit());
				c.setDireccion(cliente.getDireccion());
				c.setNombre(cliente.getNombre());
				c.setSucursal(new Sucursal(cliente.getSucursal()));
				c.setEncargado(cliente.getEncargado());
				c.setEstado(cliente.getEstado());
				ArrayList<PedidoCliente> pedidos = new ArrayList<>();
				for (PedidoClienteDTO p : cliente.getPedidosCliente()) {
					pedidos.add(new PedidoCliente(p));					
				}
				c.setPedidosCliente(pedidos);
				break;
			}
		}
		
		Cliente c = ClienteDAO.getInstancia().getCliente(cliente.getNumeroCliente());
		if (c!= null){
			c.setCuentaCorriente(new CuentaCorriente(cliente.getCuentaCorriente()));
			c.setCuit(cliente.getCuit());
			c.setDireccion(cliente.getDireccion());
			c.setNombre(cliente.getNombre());
			c.setSucursal(new Sucursal(cliente.getSucursal()));
			c.setEncargado(cliente.getEncargado());
			c.setEstado(cliente.getEstado());
			ArrayList<PedidoCliente> pedidos = new ArrayList<>();
			for (PedidoClienteDTO p : cliente.getPedidosCliente()) {
				pedidos.add(new PedidoCliente(p));					
			}
			c.setPedidosCliente(pedidos);
			c.insertar();
		}
	}
			
	public ClienteDTO buscarCliente(int numeroCliente) {
		for (Cliente c : clientes) {
			if (c.sosElCliente(numeroCliente)) {
				return c.toDTO();
			}
		}
		return ClienteDAO.getInstancia().getCliente(numeroCliente).toDTO();
		
		//falta exception

	}
}
