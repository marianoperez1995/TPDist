package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ClienteEntity;
import entities.ColorEntity;
import entities.TalleEntity;
import hibernate.HibernateUtil;
import negocio.Cliente;

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
		sesion.save(color);
		sesion.getTransaction().commit();
		sesion.close();
	}
	
	public ColorEntity getColor(String string) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ColorEntity c = (ColorEntity) sesion.createQuery("from ColorEntity where nombre = ?")
				.setParameter(0, string).uniqueResult();
		sesion.close();
		return c;
	
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
