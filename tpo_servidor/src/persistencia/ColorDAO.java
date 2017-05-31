package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ColorEntity;
import hibernate.HibernateUtil;

public class ColorDAO {
	private static SessionFactory sf;
	private static ColorDAO instancia;
	
	public static ColorDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new ColorDAO();
		}
		return instancia;		
	}
	
	public void insert(String nombreColor){
		ColorEntity color = new ColorEntity(0,nombreColor);
		//el id es 0 porque es identity en la base
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.saveOrUpdate(color);
		sesion.getTransaction().commit();
		sesion.close();
	}
	
	public void eliminar(int id) {
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		ColorEntity res= (ColorEntity) sesion.get(ColorEntity.class, id);
		sesion.delete(res);
		sesion.getTransaction().commit();
		sesion.close();		
	}

	public ColorEntity toEntity(String color) {
		ColorEntity c = new ColorEntity(0,color);
		return c;
	}
	
}
