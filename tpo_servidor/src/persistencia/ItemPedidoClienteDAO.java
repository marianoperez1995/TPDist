package persistencia;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ClienteEntity;
import entities.ItemPedidoClienteEntity;
import entities.ItemPedidoClienteId;
import entities.PedidoClienteEntity;
import hibernate.HibernateUtil;
import negocio.ItemPedidoCliente;
import negocio.PedidoCliente;

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
	public void insert(ItemPedidoCliente item, int ped){
		PedidoCliente pedido = PedidoClienteDAO.getInstancia().getPedidoCliente(ped);
		ItemPedidoClienteEntity it= toEntity(item, pedido);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.save(it);
		sesion.getTransaction().commit();
		sesion.close();
	}

	private ItemPedidoClienteEntity toEntity(ItemPedidoCliente item, PedidoCliente ped) {
		ItemPedidoClienteEntity ent = new ItemPedidoClienteEntity();
		ent.setCantidad(item.getCantidad());
		ent.setPrecio(item.getPrecio());
		ItemPedidoClienteId id = new ItemPedidoClienteId();
		ClienteEntity c = ClienteDAO.getInstancia().toEntity(ped.getCliente());		
		id.setPedido(PedidoClienteDAO.getInstancia().toEntity(ped,c));
		id.setPrenda(PrendaDAO.getInstancia().toEntity(item.getPrenda()));
		ent.setId(id);
		return ent;	
	}
	public ItemPedidoClienteEntity toE(ItemPedidoCliente item, PedidoClienteEntity ped) {
		ItemPedidoClienteEntity ent = new ItemPedidoClienteEntity();
		ent.setCantidad(item.getCantidad());
		ent.setPrecio(item.getPrecio());
		ItemPedidoClienteId id = new ItemPedidoClienteId();
		id.setPedido(ped);
		id.setPrenda(PrendaDAO.getInstancia().toEntity(item.getPrenda()));
		ent.setId(id);
		return ent;	
	}
	public void insert(ItemPedidoCliente item, PedidoCliente pedido){
		ItemPedidoClienteEntity it= toEntity(item, pedido);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.save(it);
		sesion.getTransaction().commit();
		sesion.close();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<ItemPedidoCliente> getItemsPedidoCliente(int idPed) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();		
		ArrayList<ItemPedidoClienteEntity> itemsE = new ArrayList<>();
		org.hibernate.Query query = sesion.createQuery("from ItemPedidoClienteEntity where idPedidoCliente = ?").setParameter(0, idPed);
		itemsE = (ArrayList<ItemPedidoClienteEntity>) query.list();
		sesion.close();
		ArrayList<ItemPedidoCliente> items = new ArrayList<>();
		for (ItemPedidoClienteEntity i: itemsE){
			items.add(new ItemPedidoCliente(i));
		}			
		return items;
	}
	public void eliminar(int idPedidoCliente, int idPrenda, int idTalle, int idColor) {	
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ItemPedidoClienteEntity item =  new ItemPedidoClienteEntity();
		item = (ItemPedidoClienteEntity) sesion.createQuery("from ItemPedidoClienteEntity where idPedidoCliente = ? and idPrenda = ? and idColor = ? and idTalle = ?")
				.setParameter(0, idPedidoCliente)
				.setParameter(1, idPrenda)
				.setParameter(2,idColor)
				.setParameter(3, idTalle)
				.uniqueResult();
		sesion.delete(item);
		sesion.close();	
	}
}
