package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ItemOrdenProduccionEntity;
import entities.ItemOrdenProduccionID;
import hibernate.HibernateUtil;
import negocio.ItemOrdenProduccion;

public class ItemOrdenProduccionDAO {
	private static SessionFactory sf;
	private static ItemOrdenProduccionDAO instancia;
	
	public static ItemOrdenProduccionDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new ItemOrdenProduccionDAO();
		}
		return instancia;
		
	}
	private ItemOrdenProduccionDAO(){
		
	}
	
	public void insert(ItemOrdenProduccion item){
		ItemOrdenProduccionEntity it= toEntity(item);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.save(it);
		sesion.getTransaction().commit();
		sesion.close();
	}

	public ItemOrdenProduccionEntity toEntity(ItemOrdenProduccion item) {
		ItemOrdenProduccionEntity res = new ItemOrdenProduccionEntity();
		res.setCantidadPedida(item.getCantidadPedida());
		res.setCantidadRealizada(item.getCantidadRealizada());
		ItemOrdenProduccionID id = new ItemOrdenProduccionID();
		id.setOrden(OrdenProduccionDAO.getInstancia().toEntity(item.getOrden()));
		id.setPrenda(PrendaDAO.getInstancia().toEntity(item.getPrenda()));		
		res.setId(id);
		return res;	
	}
	

	public void eliminar( int idPrenda,  int idOrden) {	
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ItemOrdenProduccionEntity item =  new ItemOrdenProduccionEntity();
		item = (ItemOrdenProduccionEntity) sesion.createQuery("from ItemOrdenProduccionEntity where idPrenda = ? and idOrdenProduccion = ?")
				.setParameter(0, idPrenda)
				.setParameter(1, idOrden)				
				.uniqueResult();
		sesion.delete(item);
		sesion.close();	
	}
}