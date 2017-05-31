package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.PrendasEliminadasEntity;
import hibernate.HibernateUtil;
import negocio.PrendasEliminadas;

public class PrendasEliminadasDAO {
	private static SessionFactory sf;
	private static PrendasEliminadasDAO instancia;
	
	public static PrendasEliminadasDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new PrendasEliminadasDAO();
		}
		return instancia;
		
	}
	private PrendasEliminadasDAO(){
		
	}
	
	public void eliminar(int id){
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		PrendasEliminadasEntity res= (PrendasEliminadasEntity) session.get(PrendasEliminadasEntity.class, id);
		session.beginTransaction();
		session.delete(res);
		session.getTransaction().commit();
		session.close();	
	}
	

	public PrendasEliminadas getPrendaEliminada(int id) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		PrendasEliminadasEntity p = (PrendasEliminadasEntity) sesion.get(PrendasEliminadasEntity.class, id);	
		sesion.close();		
		return new PrendasEliminadas(p);
	}


	public void insert(PrendasEliminadas p){
		PrendasEliminadasEntity pr= toEntity(p);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.saveOrUpdate(pr);
		sesion.getTransaction().commit();
		sesion.close();
	}
	
	
	public PrendasEliminadasEntity toEntity(PrendasEliminadas p) {
		PrendasEliminadasEntity pe= new PrendasEliminadasEntity();
		pe.setDescripcion(p.getDescripcion());
		pe.setEmpBaja(EmpleadoDAO.getInstancia().toEntity(p.getEmpBaja()));
		pe.setGerente(EmpleadoDAO.getInstancia().toEntity(p.getGerente()));
		pe.setIdPrendaEliminada(p.getIdPrendaEliminada());
		pe.setPrenda(PrendaDAO.getInstancia().toEntity(p.getPrenda()));
		return pe;
	}
	
	
}
