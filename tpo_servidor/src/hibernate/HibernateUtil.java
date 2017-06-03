package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.ClienteEntity;
import entities.ColorEntity;
import entities.CuentaCorrienteEntity;
import entities.EmpleadoEntity;
import entities.InsumoEntity;
import entities.ItemPedidoClienteEntity;
import entities.ItemProveedorInsumoEntity;
import entities.LoteEntity;
import entities.OrdenProduccionEntity;
import entities.PedidoClienteEntity;
import entities.PrendaEntity;
import entities.ProveedorEntity;
import entities.SucursalEntity;
import entities.TalleEntity;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;

	static {
		try {

			AnnotationConfiguration config = new AnnotationConfiguration();
		
			/*config.addAnnotatedClass(AreaProduccionEntity.class);
			config.addAnnotatedClass(DespachoEntity.class);
			config.addAnnotatedClass(EmpleadoEntity.class);
			config.addAnnotatedClass(FacturaEntity.class);
			
			config.addAnnotatedClass(ItemPedidoInsumoEntity.class);
			config.addAnnotatedClass(ItemPrendaAreaEntity.class);
			config.addAnnotatedClass(ItemPrendaInsumoEntity.class);
			
			config.addAnnotatedClass(LineaProduccionEntity.class);
			
			config.addAnnotatedClass(MovimientosEntity.class);
			config.addAnnotatedClass(LoteInsumoEntity.class);
			config.addAnnotatedClass(OpcEntity.class);
			config.addAnnotatedClass(OppEntity.class);
			config.addAnnotatedClass(OrdenProduccionEntity.class);
			config.addAnnotatedClass(PedidoInsumoEntity.class);
			config.addAnnotatedClass(PedidoTransporteEntity.class);
			
			config.addAnnotatedClass(PrendasEliminadasEntity.class);
			
			config.addAnnotatedClass(ReclamosEntity.class);
			config.addAnnotatedClass(SucursalEntity.class);
			config.addAnnotatedClass(TransporteEntity.class);*/
			config.addAnnotatedClass(CuentaCorrienteEntity.class);
			config.addAnnotatedClass(SucursalEntity.class);
			config.addAnnotatedClass(EmpleadoEntity.class);
			config.addAnnotatedClass(ClienteEntity.class);
			config.addAnnotatedClass(PedidoClienteEntity.class);
			config.addAnnotatedClass(PrendaEntity.class);
			config.addAnnotatedClass(ColorEntity.class);
			config.addAnnotatedClass(TalleEntity.class);
			config.addAnnotatedClass(ProveedorEntity.class);
		//	config.addAnnotatedClass(ItemProveedorInsumoEntity.class);
		//	config.addAnnotatedClass(InsumoEntity.class);
			//config.addAnnotatedClass(LoteEntity.class);
			//config.addAnnotatedClass(OrdenProduccionEntity.class);
			config.addAnnotatedClass(ItemPedidoClienteEntity.class);
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
