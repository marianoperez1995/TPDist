package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ItemPrendaAreaEntity;
import entities.ItemPrendaAreaID;
import hibernate.HibernateUtil;
import negocio.AreaProduccion;
import negocio.ItemPrendaArea;
import negocio.Prenda;

public class ItemPrendaAreaDAO  {
	
	private static SessionFactory sf;
	private static ItemPrendaAreaDAO instancia;
	
	public static ItemPrendaAreaDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new ItemPrendaAreaDAO();
		}
		return instancia;
		
	}
	private ItemPrendaAreaDAO(){
		
	}

	protected ItemPrendaArea get(Integer id) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ItemPrendaArea itemPA = (ItemPrendaArea) sesion.get(ItemPrendaAreaEntity.class, id);	
		sesion.close();		
		return itemPA;
	}
	public void insert(ItemPrendaArea itemPrendaArea) {
		ItemPrendaAreaEntity i= toEntity(itemPrendaArea);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.saveOrUpdate(i);
		sesion.getTransaction().commit();
		sesion.close();
		
	}
	public ItemPrendaAreaEntity toEntity(ItemPrendaArea itemPrendaArea) {
		ItemPrendaAreaEntity i = new ItemPrendaAreaEntity();
		ItemPrendaAreaID id = new ItemPrendaAreaID();
		AreaProduccion area = itemPrendaArea.getArea();
		id.setArea(AreaProduccionDAO.getInstancia().toEntity(area));
		Prenda prenda = itemPrendaArea.getPrenda();
		id.setPrenda(PrendaDAO.getInstancia().toEntity(prenda));		
		i.setId(id);
		i.setMinutosEnArea(itemPrendaArea.getMinutoEnArea());
		return i;
	}
	public void eliminar(int idItemPrendaArea) {
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ItemPrendaAreaEntity res= (ItemPrendaAreaEntity) session.get(ItemPrendaAreaEntity.class, idItemPrendaArea);
		session.beginTransaction();
		session.delete(res);
		session.getTransaction().commit();
		session.close();		
	}

}
