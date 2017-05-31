package persistencia;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ItemPedidoClienteEntity;
import entities.PedidoClienteEntity;
import entities.PedidoInsumoEntity;
import hibernate.HibernateUtil;
import negocio.ItemPedidoCliente;
import negocio.PedidoCliente;
import negocio.PedidoInsumo;

public class PedidoInsumoDAO {
	private static SessionFactory sf;
	private static PedidoInsumoDAO instancia;
	
	public static PedidoInsumoDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new PedidoInsumoDAO();
		}
		return instancia;
		
	}
	private  PedidoInsumoDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void eliminar(int id){
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		PedidoInsumoEntity res= (PedidoInsumoEntity) session.get(PedidoInsumoEntity.class, id);
		session.beginTransaction();
		session.delete(res);
		session.getTransaction().commit();
		session.close();	
	}
	
	
	public void insert(PedidoInsumo pedido){
		PedidoInsumoEntity ped= toEntity(pedido);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.saveOrUpdate(ped);
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
	public PedidoInsumoEntity toEntity(PedidoInsumo pedido) {
		PedidoClienteEntity ped= new PedidoClienteEntity();
		ped.setCliente(ClienteDAO.getInstancia().toEntity(pedido.getCliente()));
		ped.setEstado(pedido.getEstado());
		ped.setFechaDespacho(pedido.getFechaDespacho());
		ped.setFechaGeneracion(pedido.getFechaGeneracion());
		ped.setFechaProbableDespacho(pedido.getFechaProbableDespacho());
		ped.setNumPedidoCliente(pedido.getIdPedidoCliente());
		ped.setPrecioTotal(pedido.getPrecioTotal());
		ArrayList <ItemPedidoClienteEntity> itemsPedidoCliente= new ArrayList<ItemPedidoClienteEntity>();
		for (ItemPedidoCliente item:pedido.getItemsPedidoCliente()){
			itemsPedidoCliente.add(ItemPedidoClienteDAO.getInstancia().toEntity(item));
		}
		ped.setItemsPedidoCliente(itemsPedidoCliente);
		return ped;
	}
	
	public ArrayList<PedidoInsumo> getAll(){
		
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ArrayList<PedidoInsumoEntity> pre = new ArrayList<PedidoInsumoEntity> ();
		Query query = sesion.createQuery("from PedidoClienteEntity");
		pre = (ArrayList<PedidoInsumoEntity>) query.list();
		sesion.close();
		ArrayList<PedidoInsumo> pedidos = new ArrayList<PedidoInsumo>();
		for (PedidoInsumoEntity ee : pre){
			pedidos.add(new PedidoInsumo(ee));
		}
		return pedidos;		
	}
}
