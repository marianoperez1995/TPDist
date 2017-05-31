package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ClienteEntity;
import entities.EmpleadoEntity;
import entities.ItemPedidoClienteEntity;
import hibernate.HibernateUtil;
import negocio.Empleado;
import negocio.ItemPedidoCliente;

public class ItemPedidoClienteDAO{
	private static SessionFactory sf;
	private static ItemPedidoClienteDAO instancia;
	
	public static ItemPedidoClienteDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new ItemPedidoClienteDAO();
		}
		return instancia;
		
	}
	private ItemPedidoClienteDAO(){
		
	}
	public void insert(ItemPedidoCliente item){
		ClienteEntity it= toEntity(item);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.saveOrUpdate(it);
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
}
