package persistencia;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.OrdenProduccionEntity;
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
		sesion.save(or);
		sesion.getTransaction().commit();
		sesion.close();
	}

	//El return tiene q devolver opc o opp
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
		or.setPedidoCliente(PedidoClienteDAO.getInstancia().toEntity(orden.getPedidoCliente(),ClienteDAO.getInstancia().toEntity(orden.getPedidoCliente().getCliente())));
		or.setPrenda(PrendaDAO.getInstancia().toEntity(orden.getPrenda()));
		or.setCantidad(orden.getCantidad());
		or.setEstado(orden.getEstado());
		return or;
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<OrdenProduccion> getAll() {

		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ArrayList<OrdenProduccionEntity> ordenes = new ArrayList<OrdenProduccionEntity>();
		Query query = sesion.createQuery("from OrdenProduccionEntity");
		ordenes = (ArrayList<OrdenProduccionEntity>) query.list();
		sesion.close();
		ArrayList<OrdenProduccion> orde = new ArrayList<OrdenProduccion>();
		for (OrdenProduccionEntity ee : ordenes) {
			orde.add(new OrdenProduccion(ee));
		}
		return orde;
	}
	public void update(OrdenProduccion ordenProduccion) {
		OrdenProduccionEntity or= toEntity(ordenProduccion);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.update(or);
		sesion.getTransaction().commit();
		sesion.close();
		
	}

	public ArrayList<OrdenProduccion> getOrdenesDePedido(PedidoCliente pedidoCliente) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ArrayList<OrdenProduccionEntity> ordenes = new ArrayList<OrdenProduccionEntity>();
		Query query = sesion.createQuery("from OrdenProduccionEntity where idPedidoCliente=?").setParameter(0, pedidoCliente.getIdPedidoCliente());
		ordenes = (ArrayList<OrdenProduccionEntity>) query.list();
		sesion.close();
		ArrayList<OrdenProduccion> orde = new ArrayList<OrdenProduccion>();
		for (OrdenProduccionEntity ee : ordenes) {
			orde.add(new OrdenProduccion(ee));
		}
		return orde;
	}

}
