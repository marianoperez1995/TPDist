package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.EmpleadoEntity;
import entities.ItemPedidoClienteEntity;
import entities.ItemPedidoClienteId;
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
		ItemPedidoClienteEntity it= toEntity(item);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.saveOrUpdate(it);
		sesion.getTransaction().commit();
		sesion.close();
	}

	public ItemPedidoClienteEntity toEntity(ItemPedidoCliente item) {
		ItemPedidoClienteEntity it = new ItemPedidoClienteEntity();
		it.setCantidad(item.getCantidad());
		it.setColor(ColorDAO.getInstancia().toEntity(item.getColor()));
		ItemPedidoClienteId id = new ItemPedidoClienteId();
		//No tengo de donde sacar el PedidoClienteEntity que vendria a necesitar el ItemPedidoClienteId
//		id.setPedido(pedido);
		id.setPrenda(PrendaDAO.getInstancia().toEntity(item.getPrenda()));//no hay forma que ande bien esto
		it.setId(id);
		it.setPrecio(item.getPrecio());;
		it.setTalle(TalleDAO.getInstancia().toEntity(item.getTalle()));
		return null;
	}
	public Empleado getEmpleado(int id) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		EmpleadoEntity emp = (EmpleadoEntity) sesion.get(EmpleadoEntity.class, id);	
		sesion.close();		
		return new Empleado(emp);
	}
	public void eliminar(int id) {
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		ItemPedidoClienteEntity res= (ItemPedidoClienteEntity) sesion.get(ItemPedidoClienteEntity.class, id);
		sesion.delete(res);
		sesion.getTransaction().commit();
		sesion.close();		
	}
}
