package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.MovimientosEntity;
import entities.PrendaEntity;
import hibernate.HibernateUtil;
import negocio.Prenda;

public class MovimientosDAO {
	
	private static SessionFactory sf;
	private static MovimientosDAO instancia;
	
	public static MovimientosDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new MovimientosDAO();
		}
		return instancia;
		
	}
	private MovimientosDAO(){
		
	}
	public void disminuirStockPrendaPorPedido(Prenda prenda, int cantidad) {
		PrendaEntity prendaE= PrendaDAO.getInstancia().toEntity(prenda);
		String detalle= "Pedido de prenda";
		MovimientosEntity movimientoE= toEntity (prendaE, detalle, cantidad);
		insertEntity(movimientoE);
	}
	public MovimientosEntity toEntity(PrendaEntity prendaE, String detalle, int cantidad) {
		MovimientosEntity entity= new MovimientosEntity();
		entity.setCantidad(cantidad);
		entity.setDetalle(detalle);
		entity.setPrenda(prendaE);
		return entity;
		
	}
	
	public void insertEntity(MovimientosEntity e){
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.save(e);
		sesion.getTransaction().commit();
		sesion.close();
		
		
	}
	
	

}
