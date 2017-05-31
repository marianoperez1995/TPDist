package persistencia;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.EmpleadoEntity;
import entities.ItemPrendaAreaEntity;
import entities.ItemPrendaInsumoEntity;
import entities.PrendaEntity;
import hibernate.HibernateUtil;
import negocio.Empleado;
import negocio.ItemPrendaArea;
import negocio.ItemPrendaInsumo;
import negocio.Prenda;

public class PrendaDAO  {
	
	private static SessionFactory sf;
	private static PrendaDAO instancia;
	
	public static PrendaDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new PrendaDAO();
		}
		return instancia;
		
	}
	private PrendaDAO(){
		
	}
	
	public void eliminar(int id){
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		PrendaEntity res= (PrendaEntity) session.get(PrendaEntity.class, id);
		session.beginTransaction();
		session.delete(res);
		session.getTransaction().commit();
		session.close();	
	}
	
	
	public void insert(Prenda prenda){
		PrendaEntity pr= toEntity(prenda);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.saveOrUpdate(pr);
		sesion.getTransaction().commit();
		sesion.close();
	}


	public Prenda getPrenda(int id) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		PrendaEntity emp = (PrendaEntity) sesion.get(PrendaEntity.class, id);	
		sesion.close();		
		return new Prenda(emp);
	}
	
	

	public PrendaEntity toEntity(Prenda prenda){//Arreglar, cambiamos primary key a 3 cosas ahora
		PrendaEntity pre= new PrendaEntity();
		pre.setCodigo(prenda.getIdPrenda());
		pre.setDescripcion(prenda.getDescripcion());
		pre.setOrdenProduccion(OrdenProduccionDAO.getInstancia().toEntity(prenda.getOrdenProduccion()));
		pre.setEstadoProduccion(prenda.isEstadoProduccion());
		pre.setCostoProduccionReal(prenda.getCostoProduccionReal());
		pre.setCostoProduccionActual(prenda.getCostoProduccionActual());
		pre.setPorcentajeGanancia(prenda.getPorcentajeGanancia());
		pre.setPrecio(prenda.getPrecio());
		pre.setCantidadAConfeccionar(prenda.getCantidadAConfeccionar());
		//falta crea el array de colores y de prenda
		ArrayList<ItemPrendaInsumoEntity> itemsPrenda= new ArrayList<ItemPrendaInsumoEntity>();
		for (ItemPrendaInsumo item: prenda.getItemsPrendaInsumo()){
			itemsPrenda.add(ItemPrendaInsumoDAO.getInstancia().toEntity(item));
		}
		pre.setItemsPrendaInsumo(itemsPrenda);
		ArrayList<ItemPrendaAreaEntity> itemsPrendaArea= new ArrayList<ItemPrendaAreaEntity>();
		for (ItemPrendaArea item: prenda.getItemsPrendaArea()){
			itemsPrendaArea.add(ItemPrendaAreaDAO.getInstancia().toEntity(item));
		}
		pre.setItemsPrendaArea(itemsPrendaArea);
		return pre;
	}
	
	public ArrayList<Prenda> getAll(){
		
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ArrayList<PrendaEntity> pre = new ArrayList<PrendaEntity>();
		Query query = sesion.createQuery("from PrendaEntity");
		pre = (ArrayList<PrendaEntity>) query.list();
		sesion.close();
		ArrayList<Prenda> prendas = new ArrayList<Prenda>();
		for (PrendaEntity ee : pre){
			prendas.add(new Prenda(ee));
		}
		return prendas;		
	}
	

}
