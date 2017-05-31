package persistencia;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ClienteEntity;
import entities.FacturaEntity;
import entities.FacturaEntity;
import hibernate.HibernateUtil;
import negocio.Cliente;
import negocio.Empleado;
import negocio.Factura;
import negocio.PedidoCliente;
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
	


}
