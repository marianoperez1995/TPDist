package persistencia;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.AreaProduccionEntity;
import entities.ClienteEntity;
import entities.LineaProduccionEntity;
import entities.PrendaEntity;
import hibernate.HibernateUtil;
import negocio.AreaProduccion;
import negocio.Cliente;
import negocio.LineaProduccion;

public class AreaProduccionDAO {
	
	private static SessionFactory sf;
	private static AreaProduccionDAO instancia;
	
	public static AreaProduccionDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new AreaProduccionDAO();
		}
		return instancia;
		
	}
	
	public void eliminar(int idAreaProduccion){
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		AreaProduccionEntity res= (AreaProduccionEntity) session.get(AreaProduccionEntity.class, idAreaProduccion);
		session.beginTransaction();
		session.delete(res);
		session.getTransaction().commit();
		session.close();	
	}
	
	public AreaProduccionEntity toEntity(AreaProduccion ar){
		AreaProduccionEntity area= new AreaProduccionEntity();
		area.setNombre(ar.getNombre());
		ArrayList<LineaProduccionEntity> lineasEntity= new ArrayList<LineaProduccionEntity>();
		for (LineaProduccion li: ar.getLineasProduccion())
			lineasEntity.add(LineaProduccionDAO.getInstancia().toEntity(li));
			
		area.setLineas(lineasEntity);
		area.setIdAreaP(ar.getIdAreaProduccion());
		ArrayList<PrendaEntity> prendasEntity= new ArrayList<PrendaEntity>();
		return area;
		
	}

	public AreaProduccion getAreaProduccion(int id) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		AreaProduccionEntity area = (AreaProduccionEntity) sesion.get(AreaProduccionEntity.class, id);	
		sesion.close();		
		return new AreaProduccion(area);
	}

	public void insert(AreaProduccion area){
		AreaProduccionEntity ar= toEntity(area);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.saveOrUpdate(ar);
		sesion.getTransaction().commit();
		sesion.close();
	}

	public ArrayList<AreaProduccion> getAll(){
		
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ArrayList<AreaProduccion> areasProd = new ArrayList<AreaProduccion>();
		Query query = sesion.createQuery("from AreaProduccion");
		areasProd = (ArrayList<AreaProduccion>) query.list();
		sesion.close();
		return areasProd;		
	}
	
	
	
	
}
