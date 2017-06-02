package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ColorEntity;
import entities.ItemProveedorInsumoEntity;
import entities.ItemProveedorInsumoID;
import hibernate.HibernateUtil;
import negocio.Insumo;
import negocio.ItemProveedorInsumo;
import negocio.Proveedor;

public class ItemProveedorInsumoDAO {
	private static SessionFactory sf;
	private static ItemProveedorInsumoDAO instancia;
	
	public static ItemProveedorInsumoDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new ItemProveedorInsumoDAO();
		}
		return instancia;
		
	}
	private ItemProveedorInsumoDAO(){
		
	}	

	public ItemProveedorInsumo getItemProveedorInsumo(int id) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ItemProveedorInsumoEntity emp = (ItemProveedorInsumoEntity) sesion.get(ItemProveedorInsumoEntity.class, id);	
		sesion.close();		
		return new ItemProveedorInsumo(emp);
	}


	public void insert(ItemProveedorInsumo i){
		ItemProveedorInsumoEntity it= toEntity(i);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.saveOrUpdate(it);
		sesion.getTransaction().commit();
		sesion.close();
	}
	
	
	public ItemProveedorInsumoEntity toEntity(ItemProveedorInsumo i) {
		ItemProveedorInsumoEntity item= new ItemProveedorInsumoEntity();
		ItemProveedorInsumoID id = new ItemProveedorInsumoID();
		id.setInsumo(InsumoDAO.getInstancia().toEntity(i.getInsumo()));
		id.setProveedor(ProveedorDAO.getInstancia().toEntity(i.getProv()));
		item.setId(id);
		item.setPrecio(i.getPrecio());
		return item;
		
	
	}
	public void eliminar(Insumo insumo, Proveedor prov) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ItemProveedorInsumoEntity c = (ItemProveedorInsumoEntity) sesion.createQuery("from ItemProveedorInsumoEntity where id.insumo.idInsumo = ? and id.proveedor.idProveedor = ?")
				.setParameter(0, insumo.getIdInsumo())
				.setParameter(1, prov.getIdProveedor())
				.uniqueResult();
		sesion.delete(c);
		sesion.close();
	}
}
