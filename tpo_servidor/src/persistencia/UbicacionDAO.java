package persistencia;

import java.util.ArrayList;
import java.util.Calendar;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.BultoEntity;
import entities.UbicacionEntity;
import hibernate.HibernateUtil;
import negocio.Bulto;
import negocio.Factura;
import negocio.Ubicacion;

public class UbicacionDAO {
	private static SessionFactory sf;
	private static UbicacionDAO instancia;
	
	public static UbicacionDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new UbicacionDAO();
		}
		return instancia;
		
	}
	private UbicacionDAO(){
	}

	public UbicacionEntity toEntity(Ubicacion u) {
		UbicacionEntity ue = new UbicacionEntity();
		ue.setCodigo(u.getCodigo());
		ue.setEstado(u.getEstado());
		return ue;
	}
	
	@SuppressWarnings("unchecked")
	public Ubicacion get(String ubicacion) {
		UbicacionEntity ue = new UbicacionEntity();
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ue = (UbicacionEntity) sesion.createQuery("from UbicacionEntity where codigo = ?")
				.setParameter(0, ubicacion);
		
		sesion.close();		
		return new Ubicacion(ue);
	}
}
