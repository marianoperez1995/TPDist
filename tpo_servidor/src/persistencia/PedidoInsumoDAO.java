package persistencia;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ItemPedidoInsumoEntity;
import entities.PedidoInsumoEntity;
import hibernate.HibernateUtil;
import negocio.ItemPedidoInsumo;
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



	public PedidoInsumo getPedidoInsumo(int id) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		PedidoInsumoEntity p = (PedidoInsumoEntity) sesion.get(PedidoInsumoEntity.class, id);	
		sesion.close();		
		return new PedidoInsumo(p);
	}
	public PedidoInsumoEntity toEntity(PedidoInsumo pedido) {
		PedidoInsumoEntity p = new PedidoInsumoEntity();
		p.setFechaEntrega(pedido.getFechaEntrega());
		p.setFechaPedido(pedido.getFechaPedido());
		p.setIdPedidoInsumo(pedido.getIdPedidoInsumo());
		p.setProveedor(ProveedorDAO.getInstancia().toEntity(pedido.getProveedor()));
		ArrayList<ItemPedidoInsumoEntity> items = new ArrayList<>();
		for (ItemPedidoInsumo item : pedido.getItemsPedidoInsumo()){
			items.add(ItemPedidoInsumoDAO.getInstancia().toEntity(item, pedido));
			
		}
		
		return p;

	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<PedidoInsumo> getAll(){
		
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ArrayList<PedidoInsumoEntity> pre = new ArrayList<PedidoInsumoEntity> ();
		Query query = sesion.createQuery("from PedidoInsumoEntity");
		pre = (ArrayList<PedidoInsumoEntity>) query.list();
		sesion.close();
		ArrayList<PedidoInsumo> pedidos = new ArrayList<PedidoInsumo>();
		for (PedidoInsumoEntity ee : pre){
			pedidos.add(new PedidoInsumo(ee));
		}
		return pedidos;		
	}
}
