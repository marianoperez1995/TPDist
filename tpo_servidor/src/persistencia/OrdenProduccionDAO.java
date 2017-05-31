package persistencia;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.OrdenProduccionEntity;
import entities.PedidoClienteEntity;
import hibernate.HibernateUtil;
import negocio.OrdenProduccion;
import negocio.PedidoCliente;

public class OrdenProduccionDAO{
	
	private static SessionFactory sf;
	private static OrdenProduccionDAO instancia;
	
	public static OrdenProduccionDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new OrdenProduccionDAO();
		}
		return instancia;
		
	}
	private OrdenProduccionDAO(){
		
	}
	
	public void eliminar(int id){
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		OrdenProduccionEntity res= (OrdenProduccionEntity) session.get(OrdenProduccionEntity.class, id);
		session.beginTransaction();
		session.delete(res);
		session.getTransaction().commit();
		session.close();	
	}
	
	
	public void insert(OrdenProduccion orden){
		OrdenProduccionEntity or= toEntity(orden);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.saveOrUpdate(or);
		sesion.getTransaction().commit();
		sesion.close();
	}


	public OrdenProduccion getOrdenProduccion(int id) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		OrdenProduccionEntity emp = (OrdenProduccionEntity) sesion.get(OrdenProduccionEntity.class, id);	
		sesion.close();		
		return new OrdenProduccion(emp);
	}
	
	public OrdenProduccionEntity toEntity(OrdenProduccion orden){
		OrdenProduccionEntity or= new OrdenProduccionEntity();
		or.setCodigo(orden.getIdOrdenProduccion());
		or.setFecha(orden.getFecha());
		or.setTipo(orden.getTipo());
		or.setPedidoCliente(PedidoClienteDAO.getInstancia().toEntity(orden.getPedidoCliente()));
		return or;
		
	}
}
