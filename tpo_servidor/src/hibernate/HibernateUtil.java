package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.*;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;

	static {
		try {

			AnnotationConfiguration config = new AnnotationConfiguration();

			//config.addAnnotatedClass(DespachoEntity.class); No tiene tabla
			//config.addAnnotatedClass(LoteEntity.class);	
			//config.addAnnotatedClass(ItemPedidoInsumoEntity.class);
			//config.addAnnotatedClass(ItemPedidoInsumoEntity.class);
			config.addAnnotatedClass(ItemPrendaInsumoEntity.class);			
			/*config.addAnnotatedClass(LoteInsumoEntity.class);	
			config.addAnnotatedClass(PedidoInsumoEntity.class);
			config.addAnnotatedClass(PedidoTransporteEntity.class);	
			config.addAnnotatedClass(PrendasEliminadasEntity.class);	
			config.addAnnotatedClass(ItemProveedorInsumoEntity.class);*/
			config.addAnnotatedClass(InsumoEntity.class);
			
			//De aca para abajo andan bien en teoria
			config.addAnnotatedClass(ClienteEntity.class);
			config.addAnnotatedClass(SucursalEntity.class);
			config.addAnnotatedClass(CuentaCorrienteEntity.class);
			config.addAnnotatedClass(PedidoClienteEntity.class);
			config.addAnnotatedClass(OrdenProduccionEntity.class);
			/*config.addAnnotatedClass(AreaProduccionEntity.class);
			config.addAnnotatedClass(ItemPrendaAreaEntity.class);
			
			config.addAnnotatedClass(LineaProduccionEntity.class);*/
			config.addAnnotatedClass(EmpleadoEntity.class);
			config.addAnnotatedClass(PrendaEntity.class);
			config.addAnnotatedClass(ProveedorEntity.class);
			config.addAnnotatedClass(ReclamosEntity.class);
			config.addAnnotatedClass(ItemPedidoClienteEntity.class);
			config.addAnnotatedClass(FacturaEntity.class);
			/*config.addAnnotatedClass(MovimientosEntity.class);
			config.addAnnotatedClass(TransporteEntity.class);
		
			config.addAnnotatedClass(ItemPedidoClienteEntity.class);*/
			
			sessionFactory = config.buildSessionFactory();

		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}