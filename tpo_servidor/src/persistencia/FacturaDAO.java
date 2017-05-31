package persistencia;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.FacturaEntity;
import hibernate.HibernateUtil;
import negocio.Factura;

public class FacturaDAO {
	
	private static SessionFactory sf;
	private static FacturaDAO instancia;
	
	public static FacturaDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new FacturaDAO();
		}
		return instancia;
		
	}
	private FacturaDAO(){
		
	}
	
	public void eliminar(int id){
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		FacturaEntity res= (FacturaEntity) session.get(FacturaEntity.class, id);
		session.beginTransaction();
		session.delete(res);
		session.getTransaction().commit();
		session.close();	
	}

	public void insert(Factura fac){
		FacturaEntity fa= toEntity(fac);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.saveOrUpdate(fa);
		sesion.getTransaction().commit();
		sesion.close();
	}

	public Factura getFactura(int id) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		FacturaEntity emp = (FacturaEntity) sesion.get(FacturaEntity.class, id);	
		sesion.close();		
		return new Factura(emp);
	}
	
	public FacturaEntity toEntity(Factura fac){
		FacturaEntity factu= new FacturaEntity();
		factu.setNumeroFact(fac.getIdFactura());
		factu.setImpuestos(fac.getImpuestos());
		factu.setTotal(fac.getTotal());
		factu.setFechaGeneracion(fac.getFechaGeneracion());
		factu.setCliente(ClienteDAO.getInstancia().toEntity(fac.getCliente()));
		factu.setPedido(PedidoClienteDAO.getInstancia().toEntity(fac.getPedido()));
		return factu;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Factura> getAll() {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ArrayList<FacturaEntity> fac = new ArrayList<>();
		Query query = sesion.createQuery("from FacturaEntity");
		fac = (ArrayList<FacturaEntity>) query.list();
		sesion.close();
		ArrayList<Factura> fact = new ArrayList<>();
		for (FacturaEntity f : fac){
			fact.add(new Factura(f));
		}
		return fact;		
	}
	


}
