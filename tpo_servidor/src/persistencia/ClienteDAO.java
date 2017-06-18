package persistencia;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.ClienteEntity;
import entities.PedidoClienteEntity;
import hibernate.HibernateUtil;
import negocio.Cliente;
import negocio.PedidoCliente;

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
		/*SessionFactory sf = HibernateUtil.getSessionFactory();
		
		ClienteEntity res = (ClienteEntity) session.get(ClienteEntity.class, idCliente);
		session.beginTransaction();
		session.delete(res);
		session.getTransaction().commit();
		session.close();*/	
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		Query query;
		//Antes de borrar el cliente, hay que borrar todas sus asociaciones
		//Movimientos, Reclamos, Pedidos (de pedidos borrar ItemPedido, Transporte), Facturas, 
		query = session.createQuery("delete from MovimientosEntity where idCliente = ?").setParameter(0,idCliente); 
		int cantMov = query.executeUpdate();
		query = session.createQuery("delete from ReclamosEntity where idCliente = ?").setParameter(0,idCliente); 
		int cantR	=query.executeUpdate();
		query = session.createQuery("delete from PedidoClienteEntity where idCliente = ?").setParameter(0,idCliente); 
		int cantP=query.executeUpdate();
		query = session.createQuery("delete from FacturaEntity where idCliente = ?").setParameter(0,idCliente); 
		int cantF=query.executeUpdate();		
  		query = session.createQuery("delete from ClienteEntity where idCliente = ?").setParameter(0,idCliente);  		
  		int cantC=query.executeUpdate();
  		System.out.println("Movimientos Borrados: "+cantMov+"Pedidos: "+cantP+"Reclamos:"+cantR+"Facturas: "+cantF+"Clientes: "+cantC);
  		trans.commit();
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
		sesion.save(cli);
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
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date date = new Date();
		cliente.setFechaRegistro(dateFormat.format(date));		cliente.setEncargado(cli.getEncargado());
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

	public void update(Cliente cliente) {
		ClienteEntity cli = toEntity(cliente);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.update(cli);
		sesion.getTransaction().commit();
		sesion.close();
	}

}
