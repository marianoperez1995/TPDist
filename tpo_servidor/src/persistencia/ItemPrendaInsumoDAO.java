package persistencia;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ItemPedidoClienteEntity;
import entities.ItemPedidoInsumoEntity;
import entities.ItemPedidoInsumoID;
import entities.ItemPrendaInsumoEntity;
import entities.ItemPrendaInsumoID;
import entities.PrendaEntity;
import hibernate.HibernateUtil;
import negocio.ItemPedidoCliente;
import negocio.ItemPrendaInsumo;
import negocio.PedidoCliente;
import negocio.Prenda;

public class ItemPrendaInsumoDAO{
	
	private static SessionFactory sf;
	private static ItemPrendaInsumoDAO instancia;
	
	public static ItemPrendaInsumoDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new ItemPrendaInsumoDAO();
		}
		return instancia;
		
	}
	private ItemPrendaInsumoDAO(){
		
	}

	protected ItemPrendaInsumo get(Integer id) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ItemPrendaInsumo itemPI = (ItemPrendaInsumo) sesion.get(ItemPrendaInsumoEntity.class, id);	
		sesion.close();		
		return itemPI;
	}
	public ItemPrendaInsumoEntity toEntity(ItemPrendaInsumo item) {
		ItemPrendaInsumoEntity e = new ItemPrendaInsumoEntity();
		e.setCantidad(item.getCantidad());
		e.setDesperdicio(item.getDesperdicio());
		ItemPrendaInsumoID id = new ItemPrendaInsumoID();
		id.setInsumo(InsumoDAO.getInstancia().toEntity(item.getInsumo()));
		id.setPrenda(PrendaDAO.getInstancia().toEntity(item.getPrenda()));
		e.setId(id);
		return e;
	}
	public void insert(ItemPrendaInsumo item) {
		ItemPrendaInsumoEntity it= toEntity(item);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.save(it);
		sesion.getTransaction().commit();
		sesion.close();
		
	}
	@SuppressWarnings("unchecked")
	public ArrayList<ItemPrendaInsumo> obtenerTodosDePrenda(int idPrenda) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();		
		ArrayList<ItemPrendaInsumoEntity> itemsE = new ArrayList<>();
		org.hibernate.Query query = sesion.createQuery("from ItemPrendaInsumoEntity where idPrenda = ?").setParameter(0, idPrenda);
		itemsE = (ArrayList<ItemPrendaInsumoEntity>) query.list();
		sesion.close();
		ArrayList<ItemPrendaInsumo> items = new ArrayList<>();
		for (ItemPrendaInsumoEntity i: itemsE){
			items.add(new ItemPrendaInsumo(i));
		}			
		return items;
	}

}
