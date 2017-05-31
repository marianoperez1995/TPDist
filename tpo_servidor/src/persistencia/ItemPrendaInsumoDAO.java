package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ItemPrendaInsumoEntity;
import hibernate.HibernateUtil;
import negocio.ItemPrendaInsumo;

public class ItemPrendaInsumoDAO{
	
	private static SessionFactory sf;
	private static ItemPrendaInsumoDAO instancia;
	
	public static ItemPrendaInsumoDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new ItemPrendaInsumoDAO();
		}
		return instancia;
		
	}
	private ItemPrendaInsumoDAO(){
		
	}

	protected ItemPrendaInsumo get(Integer id) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ItemPrendaInsumo itemPI = (ItemPrendaInsumo) sesion.get(ItemPrendaInsumoEntity.class, id);	
		sesion.close();		
		return itemPI;
	}

}
