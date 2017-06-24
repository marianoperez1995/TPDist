package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ItemPedidoClienteEntity;
import entities.ItemPedidoInsumoEntity;
import entities.ItemPedidoInsumoID;
import entities.ItemPrendaInsumoEntity;
import entities.ItemPrendaInsumoID;
import hibernate.HibernateUtil;
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
	public ItemPrendaInsumoEntity toEntity(ItemPrendaInsumo item, Prenda prenda) {
		ItemPrendaInsumoEntity e = new ItemPrendaInsumoEntity();
		e.setCantidad(item.getCantidad());
		e.setDesperdicio(item.getDesperdicio());
		ItemPrendaInsumoID id = new ItemPrendaInsumoID();
		id.setInsumo(InsumoDAO.getInstancia().toEntity(item.getInsumo()));
		id.setPrenda(PrendaDAO.getInstancia().toEntity(prenda));
		e.setId(id);
		return e;
	}
	public void insert(ItemPrendaInsumo item, Prenda prenda) {
		ItemPrendaInsumoEntity it= toEntity(item, prenda);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.save(it);
		sesion.getTransaction().commit();
		sesion.close();
		
	}

}
