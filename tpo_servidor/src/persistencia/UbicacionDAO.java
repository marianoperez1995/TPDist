package persistencia;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.InsumoEntity;
import entities.UbicacionEntity;
import hibernate.HibernateUtil;
import negocio.Ubicacion;

public class UbicacionDAO {
	private static SessionFactory sf;
	private static UbicacionDAO instancia;
	
	public static UbicacionDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new UbicacionDAO();
		}
		return instancia;
		
	}
	private UbicacionDAO(){
	}

	public UbicacionEntity toEntity(Ubicacion u) {
		UbicacionEntity ue = new UbicacionEntity();
		ue.setCodigo(u.getCodigo());
		ue.setEstado(u.getEstado());
		return ue;
	}
	
	@SuppressWarnings("unchecked")
	public Ubicacion get(String ubicacion) {
		UbicacionEntity ue = new UbicacionEntity();
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ue = (UbicacionEntity) sesion.createQuery("from UbicacionEntity where codigo = ?")
				.setParameter(0, ubicacion).uniqueResult();		
		sesion.close();		
		return new Ubicacion(ue);
	}
	public UbicacionEntity obtenerPrimeraUbicacionLibre() { //para bultos
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		Query query = (Query) sesion.createQuery("from UbicacionEntity where estado = ?").setParameter(0, "Libre");				
		@SuppressWarnings("unchecked")
		ArrayList<UbicacionEntity> ubic = (ArrayList<UbicacionEntity>) query.list();
		return ubic.get(0);
	}
	public void update(Ubicacion ubicacion) {
		UbicacionEntity in= toEntity(ubicacion);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();	
		sesion.update(in);
		sesion.getTransaction().commit();
		sesion.close();
		
	}
}
