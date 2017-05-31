package persistencia;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ClienteEntity;
import entities.PedidoClienteEntity;
import entities.PrendaEntity;
import hibernate.HibernateUtil;
import negocio.Cliente;
import negocio.CuentaCorriente;
import negocio.PedidoCliente;
import negocio.Prenda;
import negocio.Sucursal;

public class ClienteDAO {
	private static SessionFactory sf;
	private static ClienteDAO instancia;

	public static ClienteDAO getInstancia() {
		if (instancia == null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new ClienteDAO();
		}
		return instancia;

	}

	private ClienteDAO() {

	}

	public void eliminar(int idCliente) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ClienteEntity res = (ClienteEntity) session.get(ClienteEntity.class, idCliente);
		session.beginTransaction();
		session.delete(res);
		session.getTransaction().commit();
		session.close();
	}

	public Cliente getCliente(int id) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ClienteEntity emp = (ClienteEntity) sesion.get(ClienteEntity.class, id);
		sesion.close();
		return new Cliente(emp);
	}

	public void insert(Cliente cliente) {
		ClienteEntity cli = toEntity(cliente);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.saveOrUpdate(cli);
		sesion.getTransaction().commit();
		sesion.close();
	}

	public ClienteEntity toEntity(Cliente cli) {
		ClienteEntity cliente = new ClienteEntity();
		cliente.setNumeroCliente(cli.getIdCliente());
		cliente.setDireccion(cli.getDireccion());
		cliente.setCuit(cli.getCuit());
		cliente.setCuentaCorriente(CuentaCorrienteDAO.getInstancia().toEntity(cli.getCuentaCorriente()));
		cliente.setNombre(cli.getNombre());
		cliente.setTelefono(cli.getTelefono());
		cliente.setSucursal(SucursalDAO.getInstancia().toEntity(cli.getSucursal()));
		cliente.setTelencargado(cli.getTelEncargado());
		cliente.setMailEncargado(cli.getMailEncargado());
		cliente.setGeneroencargado(cli.getGeneroEncargado());
		
		ArrayList<PedidoClienteEntity> pedidos = new ArrayList<PedidoClienteEntity>();
		if (cli.getPedidosCliente() != null) {
			for (PedidoCliente p : cli.getPedidosCliente()) {
				pedidos.add(PedidoClienteDAO.getInstancia().toEntity(p));
			}
			cliente.setPedidosCliente(pedidos);
		}
		cliente.setEncargado(cli.getEncargado());
		cliente.setEstado(cli.getEstado());
		return cliente;
	}

	public ArrayList<Cliente> getAll() {

		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ArrayList<ClienteEntity> pre = new ArrayList<ClienteEntity>();
		Query query = sesion.createQuery("from ClienteEntity");
		pre = (ArrayList<ClienteEntity>) query.list();
		sesion.close();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		for (ClienteEntity ee : pre) {
			clientes.add(new Cliente(ee));
		}
		return clientes;
	}

}
