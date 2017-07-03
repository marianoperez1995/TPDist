package persistencia;

import java.util.ArrayList;
import java.util.Calendar;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.BultoEntity;
import entities.FacturaEntity;
import entities.UbicacionEntity;
import hibernate.HibernateUtil;
import negocio.Bulto;
import negocio.Factura;
import negocio.Ubicacion;

public class BultoDAO {
	private static SessionFactory sf;
	private static BultoDAO instancia;
	
	public static BultoDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new BultoDAO();
		}
		return instancia;
		
	}
	private BultoDAO(){
	}
	public void insert(Bulto bul){
		BultoEntity be= toEntity(bul);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.save(be);
		sesion.getTransaction().commit();
		sesion.close();
	}
	
	public BultoEntity toEntity(Bulto bul) {
		BultoEntity bultoE = new BultoEntity();
		bultoE.setCantidad(bul.getCantidad());
		bultoE.setFechaGeneracion(Calendar.getInstance().getTime());
		bultoE.setUbicacion(UbicacionDAO.getInstancia().toEntity(bul.getUbicacion()));
		bultoE.setPrenda(PrendaDAO.getInstancia().toEntity(bul.getPrenda()));
		return bultoE;
	}	
	
	@SuppressWarnings("unchecked")
	public ArrayList<Bulto> getBultos(int idPrenda) {
		ArrayList<Bulto> bultos = new ArrayList<>();
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		Query query = (Query) sesion.createQuery("from BultoEntity where idPrenda = ?")
				.setParameter(0, idPrenda);
		bultos = (ArrayList<Bulto>) ((org.hibernate.Query) query).list();
		sesion.close();		
		return bultos;
	}
}
