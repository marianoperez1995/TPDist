package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.LoteInsumoEntity;
import hibernate.HibernateUtil;
import negocio.LoteInsumo;

public class LoteInsumoDAO  {
	
	private static SessionFactory sf;
	private static LoteInsumoDAO instancia;
	
	public static LoteInsumoDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new LoteInsumoDAO();
		}
		return instancia;
		
	}
	private LoteInsumoDAO(){
		
	}
	
	
	public void eliminar(int id){
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		LoteInsumo res= (LoteInsumo) session.get(LoteInsumo.class, id);
		session.beginTransaction();
		session.delete(res);
		session.getTransaction().commit();
		session.close();	
	}
	
	
	public void insert(LoteInsumo lote){
		LoteInsumoEntity lo= toEntity(lote);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.saveOrUpdate(lo);
		sesion.getTransaction().commit();
		sesion.close();
	}



	public LoteInsumo getLoteInsumo(int id) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		LoteInsumoEntity emp = (LoteInsumoEntity) sesion.get(LoteInsumoEntity.class, id);	
		sesion.close();		
		return new LoteInsumo(emp);
	}
	
	public LoteInsumoEntity toEntity(LoteInsumo lote){
		LoteInsumoEntity lo= new LoteInsumoEntity();
		lo.setCantidad(lote.getCantidad());
		lo.setCodigoLoteInsumo(lote.getIdLoteInsumo());
		lo.setFechaRecepcion(lote.getFechaRecepcion());
		lo.setInsumo(InsumoDAO.getInstancia().toEntity(lote.getInsumo()));
		lo.setProveedor(ProveedorDAO.getInstancia().toEntity(lote.getProveedor()));
		return lo;
	}

}
