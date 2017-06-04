package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.AreaProduccionEntity;
import entities.ClienteEntity;
import entities.ColorEntity;
import entities.CuentaCorrienteEntity;
import entities.EmpleadoEntity;
import entities.FacturaEntity;
import entities.ItemPrendaAreaEntity;
import entities.LineaProduccionEntity;
import entities.MovimientosEntity;
import entities.OpcEntity;
import entities.OppEntity;
import entities.OrdenProduccionEntity;
import entities.PedidoClienteEntity;
import entities.PrendaEntity;
import entities.ProveedorEntity;
import entities.ReclamosEntity;
import entities.SucursalEntity;
import entities.TalleEntity;
import entities.TransporteEntity;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;

	static {
		try {

			AnnotationConfiguration config = new AnnotationConfiguration();
		
			/*
			config.addAnnotatedClass(DespachoEntity.class);
			config.addAnnotatedClass(ItemPedidoInsumoEntity.class);			
			config.addAnnotatedClass(ItemPrendaInsumoEntity.class);			
			config.addAnnotatedClass(LoteInsumoEntity.class);			
			config.addAnnotatedClass(PedidoInsumoEntity.class);
			config.addAnnotatedClass(PedidoTransporteEntity.class);			
			config.addAnnotatedClass(PrendasEliminadasEntity.class);	
			config.addAnnotatedClass(ItemProveedorInsumoEntity.class);
			config.addAnnotatedClass(InsumoEntity.class);
			config.addAnnotatedClass(LoteEntity.class);		
			config.addAnnotatedClass(ItemPedidoClienteEntity.class);
			*/
			config.addAnnotatedClass(AreaProduccionEntity.class);
			config.addAnnotatedClass(LineaProduccionEntity.class);
			config.addAnnotatedClass(ItemPrendaAreaEntity.class);
			config.addAnnotatedClass(CuentaCorrienteEntity.class);
			config.addAnnotatedClass(SucursalEntity.class);
			config.addAnnotatedClass(EmpleadoEntity.class);
			config.addAnnotatedClass(ClienteEntity.class);
			config.addAnnotatedClass(PedidoClienteEntity.class);
			config.addAnnotatedClass(PrendaEntity.class);
			config.addAnnotatedClass(ColorEntity.class);
			config.addAnnotatedClass(TalleEntity.class);
			config.addAnnotatedClass(ProveedorEntity.class);
			config.addAnnotatedClass(MovimientosEntity.class);
			config.addAnnotatedClass(ReclamosEntity.class);
			config.addAnnotatedClass(OpcEntity.class);
			config.addAnnotatedClass(OppEntity.class);
			config.addAnnotatedClass(OrdenProduccionEntity.class);
			config.addAnnotatedClass(TransporteEntity.class);
			config.addAnnotatedClass(FacturaEntity.class);
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
