package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dto.CuentaCorrienteDTO;
import entities.ClienteEntity;
import entities.CuentaCorrienteEntity;
import entities.CuentaCorrienteEntity;
import hibernate.HibernateUtil;
import negocio.AreaProduccion;
import negocio.CuentaCorriente;
import negocio.CuentaCorriente;

public class CuentaCorrienteDAO  {
	
	private static SessionFactory sf;
	private static CuentaCorrienteDAO instancia;
	
	public static CuentaCorrienteDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new CuentaCorrienteDAO();
		}
		return instancia;
		
	}
	private CuentaCorrienteDAO(){
		
	}

	public void eliminar(int idCuentaCorriente){
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		CuentaCorrienteEntity res= (CuentaCorrienteEntity) session.get(CuentaCorrienteEntity.class, idCuentaCorriente);
		session.beginTransaction();
		session.delete(res);
		session.getTransaction().commit();
		session.close();	
	}

	public CuentaCorriente getCuentaCorriente(int id) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		CuentaCorrienteEntity emp = (CuentaCorrienteEntity) sesion.get(CuentaCorrienteEntity.class, id);	
		sesion.close();		
		return new CuentaCorriente(emp);
	}
	
	public void insert(CuentaCorriente cuenta){
		CuentaCorrienteEntity cu= toEntity(cuenta);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.save(cu);
		sesion.getTransaction().commit();
		sesion.close();
	}
	
	public CuentaCorrienteEntity toEntity(CuentaCorriente cuenta){
		CuentaCorrienteEntity res= new CuentaCorrienteEntity();
		res.setBalanceActual(cuenta.getBalanceActual());
		res.setCondiciones(cuenta.getCondiciones());
		res.setLimite(cuenta.getLimite());
		res.setFecha(cuenta.getFechaPago());
		res.setEstado(cuenta.getEstado());
		res.setNroCC(cuenta.getIdCuentaCorriente());
		return res;
	}


}
