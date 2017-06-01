package controladores;

import java.util.ArrayList;

import dto.ClienteDTO;
import dto.PedidoClienteDTO;
import negocio.Cliente;
import negocio.CuentaCorriente;
import negocio.PedidoCliente;
import negocio.Sucursal;

public class AdministradorClientes {
	private static AdministradorClientes instancia;
	private static ArrayList<Cliente> clientes;

	public static AdministradorClientes getInstancia() {
		if (instancia == null){
			instancia = new AdministradorClientes();
			clientes = new ArrayList<Cliente>();
		}
			return instancia;
	}

	public void agregarCliente(ClienteDTO cliDTO) {
		Cliente cli = new Cliente(cliDTO);
		clientes.add(cli);
		cli.insertar();
	}

	public void bajaCliente(ClienteDTO cliente) {
		for (Cliente c : clientes) {
			if (c.sosElCliente(cliente.getNumeroCliente())) {
				clientes.remove(c);
				return; // revisar si esta bien poner estos return aca...
			}
		}
	}

	public void modificarCliente(ClienteDTO cliente) { // modificar este metodo
		for (Cliente c : clientes) {
			if (c.sosElCliente(cliente.getNumeroCliente())) {
				c.setCuentaCorriente(new CuentaCorriente(cliente.getCuentaCorriente()));
				c.setCuit(cliente.getCuit());
				c.setDireccion(cliente.getDireccion());
				c.setEncargado(cliente.getEncargado());
				c.setEstado(cliente.getEstado());
				c.setGeneroEncargado(cliente.getGeneroEncargado());
				c.setIdCliente(cliente.getNumeroCliente());
				c.setMailEncargado(cliente.getMailEncargado());
				c.setNombre(cliente.getNombre());
				c.setSucursal(new Sucursal(cliente.getSucursal()));
				ArrayList<PedidoCliente> pedidos = new ArrayList<>();
				for (PedidoClienteDTO p : cliente.getPedidosCliente()) {
					pedidos.add(new PedidoCliente(p));
				}
				c.setPedidosCliente(pedidos);
				c.setTelefono(cliente.getTelefono());
				c.setTelEncargado(cliente.getTelEncargado());
				c.actualizar();
			}
		}
		
	}

	public Cliente buscarCliente(int numeroCliente) {
		for (Cliente c : clientes) {
			if (c.sosElCliente(numeroCliente)) {
				return c;
			}
		}
		return null;

	}
}
