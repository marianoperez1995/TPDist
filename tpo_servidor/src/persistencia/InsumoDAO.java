package persistencia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.InsumoEntity;
import entities.PrendaEntity;
import hibernate.HibernateUtil;
import negocio.Insumo;
import negocio.Prenda;

public class InsumoDAO  {
	
	private static SessionFactory sf;
	private static InsumoDAO instancia;
	
	public static InsumoDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new InsumoDAO();
		}
		return instancia;
		
	}
	private InsumoDAO(){
		
	}
	
	public void eliminar(int id){
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		InsumoEntity res= (InsumoEntity) session.get(InsumoEntity.class, id);
		session.beginTransaction();
		session.delete(res);
		session.getTransaction().commit();
		session.close();	
	}
	
	public void insert(Insumo insumo){
		InsumoEntity in= toEntity(insumo);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.save(in);
		sesion.getTransaction().commit();
		sesion.close();
	}


	public Insumo getInsumo(int id) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		InsumoEntity emp = (InsumoEntity) sesion.get(InsumoEntity.class, id);	
		sesion.close();		
		return new Insumo(emp);
	}
	
	public Insumo getInsumoPorNombre(String nombre) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		InsumoEntity p = (InsumoEntity) sesion.createQuery("from InsumoEntity where nombre = ? ")
				.setParameter(0, nombre)				
				.uniqueResult();
		sesion.close();
		return new Insumo(p);
	}
	

	public InsumoEntity toEntity(Insumo insu){
		InsumoEntity in= new InsumoEntity();
		in.setCodigo(insu.getIdInsumo());
		in.setNombre(insu.getNombre());
		in.setStockActual(insu.getStockActual());
		in.setStockMinimo(insu.getStockMinimo());
		in.setPrecioFinal(insu.getPrecioFinal());
		in.setUnidad(insu.getUnidad());
		in.setCantAComprar(insu.getCantAComprar());
		in.setFechaRecepcion(insu.getFechaRecepcion());
		return in;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Insumo> getAll(){
		
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ArrayList<InsumoEntity> pre = new ArrayList<InsumoEntity>();
		Query query = sesion.createQuery("from InsumoEntity");
		pre = (ArrayList<InsumoEntity>) query.list();
		sesion.close();
		ArrayList<Insumo> insumos = new ArrayList<Insumo>();
		for (InsumoEntity ee : pre){
			insumos.add(new Insumo(ee));
		}
		return insumos;		
	}
	public void update(Insumo ins) {

		InsumoEntity in= toEntity(ins);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.update(in);
		sesion.getTransaction().commit();
		sesion.close();
	}
	public boolean existenInsumosSuficientes(HashMap<Insumo, Float> mapa) {
		boolean resultado = true;
		for (Entry<Insumo, Float> entry : mapa.entrySet()){
			Insumo insumoEnBase = getInsumo(entry.getKey().getIdInsumo());
			if (entry.getValue() > insumoEnBase.getStockActual()){
				//Generar orden de compra de insumoEnBase.getCantAComprar();
				resultado = false;
			}
		}		
		return resultado;
	}
	
	
	
	
}
