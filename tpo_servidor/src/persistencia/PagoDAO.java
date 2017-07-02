package persistencia;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.EmpleadoEntity;
import entities.PagoEntity;
import hibernate.HibernateUtil;
import negocio.Empleado;
import negocio.Pago;

public class PagoDAO {
	private static SessionFactory sf;
	private static PagoDAO instancia;

	public static PagoDAO getInstancia() {
		if (instancia == null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new PagoDAO();
		}
		return instancia;

	}

	private PagoDAO() {

	}

	public void eliminar(Pago p) {
		PagoEntity pa = toEntity(p);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.delete(pa);
		sesion.getTransaction().commit();
		sesion.close();
	}

	public Pago getPago(int id) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		PagoEntity pago = (PagoEntity) sesion.get(PagoEntity.class, id);
		sesion.close();
		Pago p = new Pago(pago);
		return p;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Pago> getPagosPorCliente (int idCliente){
		ArrayList<Pago> pagos = new ArrayList<>();
		Session s = sf.openSession();
		s.beginTransaction();
		ArrayList<PagoEntity> pe = new ArrayList<>();
		Query query = s.createQuery("from PagoEntity where idCliente = ?").setParameter(0, idCliente);
		pe = (ArrayList<PagoEntity>) query.list();
		for (PagoEntity p : pe){
			pagos.add(new Pago(p));
		}
		s.close();
		return pagos;
	}

	public void insert(Pago p) {
		PagoEntity pa = toEntity(p);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.save(pa);
		sesion.getTransaction().commit();
		sesion.close();
	}
	public void update(Pago p) {
		PagoEntity pa = toEntity(p);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.update(pa);
		sesion.getTransaction().commit();
		sesion.close();
	}
	public PagoEntity toEntity(Pago p) {
		PagoEntity pa = new PagoEntity();
		pa.setCliente(ClienteDAO.getInstancia().toEntity(p.getCliente()));
		pa.setFechaPago(p.getFechaPago());
		pa.setIdPago(p.getIdPago());
		pa.setMonto(p.getMonto());
		pa.setMontoAnterior(p.getMontoAnterior());
		return pa;
	}

}