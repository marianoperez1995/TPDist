package controladores;

import java.util.ArrayList;

import dto.ClienteDTO;
import dto.CuentaCorrienteDTO;
import dto.PedidoClienteDTO;
import dto.ReclamoDTO;
import negocio.Cliente;
import negocio.CuentaCorriente;
import negocio.PedidoCliente;
import negocio.Reclamo;
import negocio.Sucursal;
import persistencia.ClienteDAO;
import persistencia.CuentaCorrienteDAO;

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
				//clientes.remove(c);
				c.setEstado("Baja");
				return; // revisar si esta bien poner estos return aca...
			}
		}
		
		Cliente cli = new Cliente(cliente);
		CuentaCorriente ccorr = new CuentaCorriente(cliente.getCuentaCorriente());
		ccorr.setEstado("Baja");
		cli.setEstado("Baja");
		cli.actualizar();
		ccorr.actualizar();
	}

	public void modificarCliente(ClienteDTO cliente) {
		 Cliente modif = new Cliente(cliente);
		 modif.actualizar();
	}

	public Cliente buscarCliente(int numeroCliente) {
		for (Cliente c : clientes) {
			if (c.sosElCliente(numeroCliente)) {
				return c;
			}
		}
		return null;

	}
	
	public ArrayList<ClienteDTO> listadoClientes(){
		ArrayList<ClienteDTO> resultado = new ArrayList<ClienteDTO>();
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		lista = ClienteDAO.getInstancia().getAll();
		
		for(Cliente e: lista){
			resultado.add(e.toDTO());
		}
		return resultado;
	}
	
	public ClienteDTO obtenerCliente(ClienteDTO b){
		return ClienteDAO.getInstancia().getCliente(b.getNumeroCliente()).toDTO();		
	}

	public CuentaCorrienteDTO obtenerCuenta(CuentaCorrienteDTO cuenta) {
		return CuentaCorrienteDAO.getInstancia().getCuentaCorriente(cuenta.getIdCuentaCorriente()).toDTO();
	}

	public void rechazarCliente(ClienteDTO cliente) {
		for (Cliente c : clientes) {
			if (c.sosElCliente(cliente.getNumeroCliente())) {
				//clientes.remove(c);
				c.setEstado("Rechazado");
				return; // revisar si esta bien poner estos return aca...
			}
		}
		
		Cliente cli = new Cliente(cliente);
		CuentaCorriente ccorr = new CuentaCorriente(cliente.getCuentaCorriente());
		ccorr.setEstado("Rechazado");
		cli.setEstado("Rechazado");
		cli.actualizar();
		ccorr.actualizar();
	}
	
	public void aumentarLimiteCreditoCliente(float limite, ClienteDTO clientedto){
		Cliente cliente=ClienteDAO.getInstancia().getCliente(clientedto.getNumeroCliente());
		cliente.aumentarLimiteCredito(limite);
		ClienteDAO.getInstancia().update(cliente);
		
		
	}

	public void darDeAltaCliente(ClienteDTO cliente) {
		for (Cliente c : clientes) {
			if (c.sosElCliente(cliente.getNumeroCliente())) {
				//clientes.remove(c);
				c.setEstado("Alta");
				return; // revisar si esta bien poner estos return aca...
			}
		}
		
		Cliente cli = new Cliente(cliente);
		CuentaCorriente ccorr = new CuentaCorriente(cliente.getCuentaCorriente());
		ccorr.setEstado("Alta");
		cli.setEstado("Alta");
		cli.actualizar();
		ccorr.actualizar();
	}

	public void crearReclamo(ReclamoDTO reclamo) {
		Reclamo rec = new Reclamo(reclamo);
		rec.insertar();
	}
}
