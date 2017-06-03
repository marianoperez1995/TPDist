package persistencia;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ClienteEntity;
import entities.ItemPedidoClienteEntity;
import entities.PedidoClienteEntity;
import hibernate.HibernateUtil;
import negocio.Cliente;
import negocio.ItemPedidoCliente;
import negocio.PedidoCliente;

public class PedidoClienteDAO {
	
	private static SessionFactory sf;
	private static PedidoClienteDAO instancia;
	
	public static PedidoClienteDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new PedidoClienteDAO();
		}
		return instancia;
		
	}
	private PedidoClienteDAO(){
	}
	
	public void eliminar(int id){
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		PedidoClienteEntity res= (PedidoClienteEntity) session.get(PedidoClienteEntity.class, id);
		session.beginTransaction();
		session.delete(res);
		session.getTransaction().commit();
		session.close();	
	}
	
	
	public void insert(PedidoCliente pedido, int idCliente ){
		Cliente cliente = ClienteDAO.getInstancia().getCliente(idCliente);
		ClienteEntity clienteE = ClienteDAO.getInstancia().toEntity(cliente);
		PedidoClienteEntity ped= toEntity(pedido, clienteE);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.save(ped);
		sesion.getTransaction().commit();
		sesion.close();
	}



	public PedidoCliente getPedidoCliente(int id) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		PedidoClienteEntity emp = (PedidoClienteEntity) sesion.get(PedidoClienteEntity.class, id);	
		sesion.close();		
		return new PedidoCliente(emp);
	}
	public PedidoClienteEntity toEntity(PedidoCliente pedido, ClienteEntity cliente) {
		PedidoClienteEntity ped= new PedidoClienteEntity();
		ped.setCliente(cliente);
		ped.setEstado(pedido.getEstado());
		ped.setFechaDespacho(pedido.getFechaDespacho());
		ped.setFechaGeneracion(pedido.getFechaGeneracion());
		ped.setFechaProbableDespacho(pedido.getFechaProbableDespacho());
		ped.setFechaEntregaCliente(pedido.getFechaEntregaCliente());
		ped.setNumPedidoCliente(pedido.getIdPedidoCliente());
		ped.setPrecioTotal(pedido.getPrecioTotal());
		ArrayList <ItemPedidoClienteEntity> itemsPedidoCliente= new ArrayList<ItemPedidoClienteEntity>();
		for (ItemPedidoCliente item:pedido.getItemsPedidoCliente()){
			itemsPedidoCliente.add(ItemPedidoClienteDAO.getInstancia().toE(item, ped));
		}
		ped.setItemsPedidoCliente(itemsPedidoCliente);
		return ped;
	}
	
	public ArrayList<PedidoCliente> getAll(){
		
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ArrayList<PedidoClienteEntity> pre = new ArrayList<PedidoClienteEntity>();
		Query query = sesion.createQuery("from PedidoClienteEntity");
		pre = (ArrayList<PedidoClienteEntity>) query.list();
		sesion.close();
		ArrayList<PedidoCliente> pedidos = new ArrayList<PedidoCliente>();
		for (PedidoClienteEntity ee : pre){
			pedidos.add(new PedidoCliente(ee));
		}
		return pedidos;		
	}
	
	

}
