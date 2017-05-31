package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.TalleEntity;
import hibernate.HibernateUtil;

public class TalleDAO {
	private static SessionFactory sf;
	private static TalleDAO instancia;
	
	public static TalleDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new TalleDAO();
		}
		return instancia;		
	}
	
	public void insert(String nombreTalle){
		TalleEntity talle = new TalleEntity(0,nombreTalle);
		//el id es 0 porque es identity en la base
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.saveOrUpdate(talle);
		sesion.getTransaction().commit();
		sesion.close();
	}
	
	public void eliminar(int id) {
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		TalleEntity res= (TalleEntity) sesion.get(TalleEntity.class, id);
		sesion.delete(res);
		sesion.getTransaction().commit();
		sesion.close();		
	}

	public TalleEntity toEntity(String talle) {
		TalleEntity t = new TalleEntity(0,talle);
		return t;
	}
	
	
}
