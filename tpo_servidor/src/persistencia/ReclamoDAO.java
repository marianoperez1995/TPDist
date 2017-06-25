package persistencia;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.ClienteEntity;
import entities.PedidoClienteEntity;
import entities.ReclamosEntity;
import hibernate.HibernateUtil;
import negocio.Cliente;
import negocio.PedidoCliente;
import negocio.Reclamo;

public class ReclamoDAO {
	private static SessionFactory sf;
	private static ReclamoDAO instancia;

	public static ReclamoDAO getInstancia() {
		if (instancia == null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new ReclamoDAO();
		}
		return instancia;

	}

	private ReclamoDAO() {

	}

	public void insert(Reclamo reclamo) {
		ReclamosEntity rec = toEntity(reclamo);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.save(rec);
		sesion.getTransaction().commit();
		sesion.close();
	}

	public ReclamosEntity toEntity(Reclamo rec) {
		ReclamosEntity reclamo = new ReclamosEntity();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		reclamo.setCliente(ClienteDAO.getInstancia().toEntity(rec.getCliente()));
		reclamo.setFechaReclamo(Calendar.getInstance().getTime());
		reclamo.setReclamo(rec.getReclamo());
		return reclamo;
	}

}
