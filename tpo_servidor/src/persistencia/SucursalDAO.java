package persistencia;


import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.SucursalEntity;
import hibernate.HibernateUtil;
import negocio.Sucursal;

public class SucursalDAO {
	
	private static SessionFactory sf;
	private static SucursalDAO instancia;
	
	public static SucursalDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new SucursalDAO();
		}
		return instancia;
		
	}
	private SucursalDAO(){
		
	}
	
	public void eliminar(int id){
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		SucursalEntity res= (SucursalEntity) session.get(SucursalEntity.class, id);
		session.beginTransaction();
		session.delete(res);
		session.getTransaction().commit();
		session.close();	
	}
	
	
	public void insert(Sucursal sucu){
		SucursalEntity su= toEntity(sucu);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.save(su);
		sesion.getTransaction().commit();
		sesion.close();
	}


	public Sucursal getSucursal(int id) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		SucursalEntity emp = (SucursalEntity) sesion.get(SucursalEntity.class, id);	
		System.out.println(emp.getNombre());
		sesion.close();		
		return new Sucursal(emp);
	}
	
	
	public SucursalEntity toEntity(Sucursal sucu){ 
		//Revisar lo de empleados
		SucursalEntity sucursal= new SucursalEntity();
		
		sucursal.setHorarios(sucu.getHorarios());
		sucursal.setNombre(sucu.getNombre());
		sucursal.setNumero(sucu.getIdSucursal());
		sucursal.setUbicacion(sucu.getUbicacion());
		return sucursal;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Sucursal> getAll(){
		
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ArrayList<SucursalEntity> pre = new ArrayList<SucursalEntity>();
		Query query = sesion.createQuery("from SucursalEntity");
		pre = (ArrayList<SucursalEntity>) query.list();
		sesion.close();
		ArrayList<Sucursal> sucursales = new ArrayList<Sucursal>();
		for (SucursalEntity ee : pre){
			sucursales.add(new Sucursal(ee));
		}
		return sucursales;		
	}
	

}
