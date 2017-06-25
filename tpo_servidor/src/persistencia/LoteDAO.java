package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.LoteEntity;
import hibernate.HibernateUtil;
import negocio.Lote;

public class LoteDAO {
	
	private static SessionFactory sf;
	private static LoteDAO instancia;
	
	public static LoteDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new LoteDAO();
		}
		return instancia;
		
	}
	private LoteDAO(){
		
	}
	
	public void eliminar(int id){
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		LoteEntity res= (LoteEntity) session.get(LoteEntity.class, id);
		session.beginTransaction();
		session.delete(res);
		session.getTransaction().commit();
		session.close();	
	}
	
	
	public void insert(Lote lote){
		LoteEntity lo= toEntity(lote);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.saveOrUpdate(lo);
		sesion.getTransaction().commit();
		sesion.close();
	}



	public Lote getLote(int id) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		LoteEntity emp = (LoteEntity) sesion.get(LoteEntity.class, id);	
		sesion.close();		
		return new Lote(emp);
	}
	
	public LoteEntity toEntity(Lote lote){
		LoteEntity lo= new LoteEntity();
		lo.setCantidadTotal(lote.getCantidadTotal());
		lo.setCodigo(lote.getIdLote());
		lo.setOrden(OrdenProduccionDAO.getInstancia().toEntity(lote.getOrden()));
		lo.setPrenda(PrendaDAO.getInstancia().toEntity(lote.getBultos().get(0).getPrenda())); //...
		return lo;
		
	}

}
