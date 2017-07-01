package persistencia;

import java.util.ArrayList;
import java.util.Calendar;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ReclamosEntity;
import hibernate.HibernateUtil;
import negocio.Reclamo;

public class ReclamoDAO {
	private static SessionFactory sf;
	private static ReclamoDAO instancia;

	public static ReclamoDAO getInstancia() {
		if (instancia == null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new ReclamoDAO();
		}
		return instancia;

	}

	private ReclamoDAO() {

	}

	public void insert(Reclamo reclamo) {
		ReclamosEntity rec = toEntity(reclamo);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.save(rec);
		sesion.getTransaction().commit();
		sesion.close();
	}

	public ReclamosEntity toEntity(Reclamo rec) {
		ReclamosEntity reclamo = new ReclamosEntity();
	//	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		reclamo.setCliente(ClienteDAO.getInstancia().toEntity(rec.getCliente()));
		reclamo.setFechaReclamo(Calendar.getInstance().getTime());
		reclamo.setReclamo(rec.getReclamo());
		return reclamo;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Reclamo> getAll() {

		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ArrayList<ReclamosEntity> pre = new ArrayList<ReclamosEntity>();
		Query query = sesion.createQuery("from ReclamosEntity");
		pre = (ArrayList<ReclamosEntity>) query.list();
		sesion.close();
		ArrayList<Reclamo> reclamos = new ArrayList<Reclamo>();
		for (ReclamosEntity ee : pre) {
			reclamos.add(new Reclamo(ee));
		}
		return reclamos;
	}

	public Reclamo getReclamo(int idReclamo) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ReclamosEntity emp = (ReclamosEntity) sesion.get(ReclamosEntity.class, idReclamo);
		sesion.close();
		Reclamo reclamo=new Reclamo(emp);
		return reclamo ;
	}
}
