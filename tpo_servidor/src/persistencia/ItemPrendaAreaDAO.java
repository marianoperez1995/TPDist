package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ItemPrendaAreaEntity;
import hibernate.HibernateUtil;
import negocio.ItemPrendaArea;

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

	@Override
	protected ItemPrendaArea get(Integer id) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ItemPrendaArea itemPA = (ItemPrendaArea) sesion.get(ItemPrendaAreaEntity.class, id);	
		sesion.close();		
		return itemPA;
	}

}
