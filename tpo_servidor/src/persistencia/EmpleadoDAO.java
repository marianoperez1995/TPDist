package persistencia;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ClienteEntity;
import entities.EmpleadoEntity;
import hibernate.HibernateUtil;
import negocio.Empleado;

public class EmpleadoDAO {
	
	private static SessionFactory sf;
	private static EmpleadoDAO instancia;
	
	public static EmpleadoDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new EmpleadoDAO();
		}
		return instancia;
		
	}
	private EmpleadoDAO(){
		
	}
	public void eliminar(int idEmpleado){
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		EmpleadoEntity res= (EmpleadoEntity) session.get(EmpleadoEntity.class, idEmpleado);
		session.beginTransaction();
		session.delete(res);
		session.getTransaction().commit();
		session.close();	
	}
	
	public void insert(Empleado emp){
		EmpleadoEntity em= toEntity(emp);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.saveOrUpdate(em);
		sesion.getTransaction().commit();
		sesion.close();
	}

	public Empleado getEmpleado(int id) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		EmpleadoEntity emp = (EmpleadoEntity) sesion.get(EmpleadoEntity.class, id);	
		sesion.close();		
		return new Empleado(emp);
	}

	
	
	public ArrayList<Empleado> getAll(){
		
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ArrayList<EmpleadoEntity> emp = new ArrayList<EmpleadoEntity>();
		Query query = sesion.createQuery("from EmpleadoEntity");
		emp = (ArrayList<EmpleadoEntity>) query.list();
		sesion.close();
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		for (EmpleadoEntity ee : emp){
			empleados.add(new Empleado(ee));
		}
		return empleados;		
	}
	
	public EmpleadoEntity toEntity(Empleado emp){
		EmpleadoEntity empl= new EmpleadoEntity();
		empl.setIdTrabajador(emp.getidEmpleado());
		empl.setNombre(emp.getNombre());
		empl.setTipo(emp.getTipo());
		empl.setSucursales(SucursalDAO.getInstancia().toEntity(emp.getSucursal()));
		empl.setPass(emp.getPass());
		empl.setPermisos(emp.getPermisos());
		empl.setUsuario(emp.getUsuario());
		return empl;
		
	}


}
