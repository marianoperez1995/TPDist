package persistencia;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ClienteEntity;
import entities.LineaProduccionEntity;
import entities.LineaProduccionEntity;
import hibernate.HibernateUtil;
import negocio.Cliente;
import negocio.LineaProduccion;
import negocio.LineaProduccion;

public class LineaProduccionDAO  {
	
	private static SessionFactory sf;
	private static LineaProduccionDAO instancia;
	
	public static LineaProduccionDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new LineaProduccionDAO();
		}
		return instancia;
		
	}
	private LineaProduccionDAO(){
		
	}
	
	public void eliminar(int id){
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		LineaProduccionEntity res= (LineaProduccionEntity) session.get(LineaProduccionEntity.class, id);
		session.beginTransaction();
		session.delete(res);
		session.getTransaction().commit();
		session.close();	
	}
	

	public void insert(LineaProduccion linea){
		LineaProduccionEntity li= toEntity(linea);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.save(li);
		sesion.getTransaction().commit();
		sesion.close();
	}


	public LineaProduccion getLineaProduccion(int id) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		LineaProduccionEntity emp = (LineaProduccionEntity) sesion.get(LineaProduccionEntity.class, id);	
		sesion.close();		
		return new LineaProduccion(emp);
	}


	
	public LineaProduccionEntity toEntity(LineaProduccion linea){
		LineaProduccionEntity lp= new LineaProduccionEntity();
		lp.setCapacidad(linea.getCapacidad());
		lp.setEstado(linea.isEstado());
		lp.setHoraInicio(linea.getHoraInicio());
		lp.setTiempoDeUso(linea.getTiempoDeUso());
		lp.setIdLinea(linea.getIdLineaProduccion());
		return lp;
	}
	
}
