package persistencia;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ItemPedidoInsumoEntity;
import entities.ItemPedidoInsumoID;
import hibernate.HibernateUtil;
import negocio.ItemPedidoInsumo;
import negocio.PedidoInsumo;

public class ItemPedidoInsumoDAO {
	private static SessionFactory sf;
	private static ItemPedidoInsumoDAO instancia;
	
	public static ItemPedidoInsumoDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new ItemPedidoInsumoDAO();
		}
		return instancia;
		
	}
	private ItemPedidoInsumoDAO(){
		
	}
	public void insert(ItemPedidoInsumo item, int ped){
		PedidoInsumo pedido = PedidoInsumoDAO.getInstancia().getPedidoInsumo(ped);
		ItemPedidoInsumoEntity it= toEntity(item, pedido);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.save(it);
		sesion.getTransaction().commit();
		sesion.close();
	}

	private ItemPedidoInsumoEntity toEntity(ItemPedidoInsumo item, PedidoInsumo ped) {
		ItemPedidoInsumoEntity ent = new ItemPedidoInsumoEntity();
		ent.setCantidad(item.getCantidad());
		ItemPedidoInsumoID id = new ItemPedidoInsumoID();
		id.setInsumo(InsumoDAO.getInstancia().toEntity(item.getInsumo()));
		id.setPedido(PedidoInsumoDAO.getInstancia().toEntity(ped));
		ent.setId(id);
		return ent;	
	}

	public void insert(ItemPedidoInsumo item, PedidoInsumo pedido){
		ItemPedidoInsumoEntity it= toEntity(item, pedido);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.save(it);
		sesion.getTransaction().commit();
		sesion.close();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<ItemPedidoInsumo> getItemsPedidoInsumo(int idPed) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();		
		ArrayList<ItemPedidoInsumoEntity> itemsE = new ArrayList<>();
		org.hibernate.Query query = sesion.createQuery("from ItemPedidoInsumoEntity where idPedidoInsumos = ?").setParameter(0, idPed);
		itemsE = (ArrayList<ItemPedidoInsumoEntity>) query.list();
		sesion.close();
		ArrayList<ItemPedidoInsumo> items = new ArrayList<>();
		for (ItemPedidoInsumoEntity i: itemsE){
			items.add(new ItemPedidoInsumo(i));
		}			
		return items;
	}
	public void eliminar(int idPedidoInsumos, int idInsumo) {	
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ItemPedidoInsumoEntity item =  new ItemPedidoInsumoEntity();
		item = (ItemPedidoInsumoEntity) sesion.createQuery("from ItemPedidoInsumoEntity where idPedidoInsumos = ? and idInsumo = ? ")
				.setParameter(0, idPedidoInsumos)
				.setParameter(1, idInsumo)			
				.uniqueResult();
		sesion.delete(item);
		sesion.close();	
	}
}
