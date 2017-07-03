package persistencia;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dto.PrendaDTO;
import entities.PrendaEntity;
import hibernate.HibernateUtil;
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
		sesion.save(pr);
		sesion.getTransaction().commit();
		sesion.close();
		sesion = sf.openSession();
		sesion.beginTransaction();
		if(prenda.getInsumos() != null){
			for (int i=0;i<prenda.getInsumos().size();i++){
				ItemPrendaInsumo item=new ItemPrendaInsumo();
				item=prenda.getInsumos().get(i);
				item.insertar();
			}
		}
	}


	public Prenda getPrenda(int idP) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		PrendaEntity p = (PrendaEntity) sesion.createQuery("from PrendaEntity where idPrenda = ? ")
				.setParameter(0, idP)				
				.uniqueResult();
		Prenda prenda = new Prenda(p);
		prenda.setInsumos(ItemPrendaInsumoDAO.getInstancia().obtenerTodosDePrenda(prenda.getIdPrenda()));
		sesion.close();
		return prenda;
	}
	
	

	public PrendaEntity toEntity(Prenda prenda){
		PrendaEntity p = new PrendaEntity();
		p.setIdPrenda(prenda.getIdPrenda());
		p.setCantidadAConfeccionar(prenda.getCantidadAConfeccionar());
		p.setCostoProduccionActual(prenda.getCostoProduccionActual());
		p.setCostoProduccionReal(prenda.getCostoProduccionReal());
		p.setDescripcion(prenda.getDescripcion());
		p.setEstadoProduccion(prenda.isEstadoProduccion());
		p.setPorcentajeGanancia(prenda.getPorcentajeGanancia());
		p.setPrecio(prenda.getPrecio());
		p.setStockActual(prenda.getStockActual());
		p.setStockMinimo(prenda.getStockMinimo());	
		p.setColor(prenda.getColor());
		p.setTalle(prenda.getTalle());
		return p;
	}
	
	
	@SuppressWarnings("unchecked")
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
		for (Prenda p : prendas){
			p.setInsumos(ItemPrendaInsumoDAO.getInstancia().obtenerTodosDePrenda(p.getIdPrenda()));
		}
		
		return prendas;		
	}
	
	public void update(Prenda prenda) {
		PrendaEntity pre = toEntity(prenda);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.update(pre);
		sesion.getTransaction().commit();
		sesion.close();
	}
	
	public void disminuirStock(Prenda prenda, int cantidad) {
		if(cantidad>=prenda.getStockActual()){
			prenda.setStockActual(0);
		}else{
			prenda.setStockActual(prenda.getStockActual()-cantidad);
		}
		update(prenda);
		
	}
	@SuppressWarnings("unchecked")
	public ArrayList<Prenda> getPrendasPorNombre(PrendaDTO prenda) {
			Session sesion = sf.openSession();
			sesion.beginTransaction();
			ArrayList<PrendaEntity> pre = new ArrayList<PrendaEntity>();
			Query query = sesion.createQuery("from PrendaEntity where descripcion=?").setParameter(0, prenda.getDescripcion());
			pre = (ArrayList<PrendaEntity>) query.list();
			sesion.close();
			ArrayList<Prenda> prendas = new ArrayList<Prenda>();
			for (PrendaEntity ee : pre){
				prendas.add(new Prenda(ee));
			}
			for (Prenda p : prendas){
				p.setInsumos(ItemPrendaInsumoDAO.getInstancia().obtenerTodosDePrenda(p.getIdPrenda()));
			}
			return prendas;		
		}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Prenda> getPrendasPorNombreYColor(PrendaDTO prenda) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ArrayList<PrendaEntity> pre = new ArrayList<PrendaEntity>();
		Query query = sesion.createQuery("from PrendaEntity where descripcion=? and color=?").setParameter(0, prenda.getDescripcion()).setParameter(1, prenda.getColor());
		pre = (ArrayList<PrendaEntity>) query.list();
		sesion.close();
		ArrayList<Prenda> prendas = new ArrayList<Prenda>();
		for (PrendaEntity ee : pre){
			prendas.add(new Prenda(ee));
		}
		for (Prenda p : prendas){
			p.setInsumos(ItemPrendaInsumoDAO.getInstancia().obtenerTodosDePrenda(p.getIdPrenda()));
		}
		return prendas;	
	}
	public Prenda getPrendasPorNombreYColorYTalle(String prenda, String color, String talle) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		PrendaEntity pre = new PrendaEntity();
		Query query = sesion.createQuery("from PrendaEntity where descripcion=? and color=? and talle=?").setParameter(0, prenda).setParameter(1, color).setParameter(2,talle);
		pre =  (PrendaEntity) query.uniqueResult();
		sesion.close();
		Prenda prend = new Prenda(pre);
		prend.setInsumos(ItemPrendaInsumoDAO.getInstancia().obtenerTodosDePrenda(prend.getIdPrenda()));
		return prend;	
	}

}
	

