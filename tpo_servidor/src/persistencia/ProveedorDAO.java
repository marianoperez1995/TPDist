package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ProveedorEntity;
import hibernate.HibernateUtil;
import negocio.Proveedor;

public class ProveedorDAO  {
	
	private static SessionFactory sf;
	private static ProveedorDAO instancia;
	
	public static ProveedorDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new ProveedorDAO();
		}
		return instancia;
		
	}
	private ProveedorDAO(){
		
	}
	
	public void eliminar(int id){
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ProveedorEntity res= (ProveedorEntity) session.get(ProveedorEntity.class, id);
		session.beginTransaction();
		session.delete(res);
		session.getTransaction().commit();
		session.close();	
	}
	
	
	public void insert(Proveedor prove){
		ProveedorEntity pr= toEntity(prove);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.save(pr);
		sesion.getTransaction().commit();
		sesion.close();
	}

	public Proveedor getProveedor(int id) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ProveedorEntity emp = (ProveedorEntity) sesion.get(ProveedorEntity.class, id);	
		sesion.close();		
		return new Proveedor(emp);
	}
	
	public ProveedorEntity toEntity(Proveedor prov){
		ProveedorEntity pr= new ProveedorEntity();
		pr.setidProveedor(prov.getIdProveedor());
		pr.setCuit(prov.getCuit());
		pr.setNombre(prov.getNombre());
	//itemproeveedorinsumo?
		return pr;

	}

}
