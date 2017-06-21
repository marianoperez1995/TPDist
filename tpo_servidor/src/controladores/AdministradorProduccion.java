package controladores;

import java.util.ArrayList;
import java.util.Date;

import dto.LoteDTO;
import dto.OrdenProduccionDTO;
import negocio.AreaProduccion;
import negocio.ItemPedidoCliente;
import negocio.Lote;
import negocio.OrdenProduccion;
import negocio.PedidoCliente;
import negocio.Prenda;
import persistencia.OrdenProduccionDAO;

public class AdministradorProduccion {
	private ArrayList<Prenda> prendas;
	private ArrayList<AreaProduccion> areasProduccion;
	private ArrayList<OrdenProduccion> ordenesProduccion;
	private ArrayList<Lote> lotes;
	
	private static AdministradorProduccion instancia;
	
	
	public static AdministradorProduccion getInstancia (){
		if(instancia== null)
			instancia= new AdministradorProduccion ();
		return instancia;
	}
 /*
	//quito int cantidad d elos paremtros de los generarOrden porque ya esta en pedido creo
	public void generarOrdenProduccionParcial(Date fecha, int codigoPrenda, PedidoCliente pedido, ArrayList<ItemOPP> itemsOPP) {
		//ver de donde salen los itemsOPP
		Opp op = new Opp();
		op.setCodigo(codigoPrenda);
		op.setFecha(fecha);
		op.setPedidoCliente(pedido);
		op.setItems(itemsOPP);
		ordenesProduccion.add(op);
		op.insert();
	}
	
	//agrego y cambio  los generar para parcial y completo
	public void generarOrdenProduccionCompleta(Date fecha, int codigoPrenda, PedidoCliente pedido) {
		Opc oc = new Opc();
		oc.setCodigo(codigoPrenda);
		oc.setFecha(fecha);
		oc.setPedidoCliente(pedido);
		ordenesProduccion.add(oc);
		oc.insert();
	}
	private Prenda buscarPrenda(int codigo) {
		for (Prenda p:prendas){
			if (p.sosLaPrenda(codigo)){
				return p;
			}
		}
		Prenda  prend = null;
		prend = prend.buscarPrenda( codigo);
		
		return prend;
	}

	private OrdenProduccion buscarOrden(int codigo) {
		for (OrdenProduccion o:ordenesProduccion){
			if (o.sosLaOrden(codigo)){
				return o;
			}
		}
		OrdenProduccion aux = null;
		aux = aux.buscarOrdenProduccion (codigo);
		return aux;
	}
	
	private Lote buscarLote(int codigo){
		for (Lote lo: lotes){
			if (lo.sosElLote(codigo)){
				return lo;
			}
		}
		Lote aux = null;
		aux= aux.buscarLote(codigo);
		return aux;
	}
	
	public void bajaOrden (int codigo){
		for (OrdenProduccion o:ordenesProduccion){
			if (o.sosLaOrden(codigo)){
				ordenesProduccion.remove(o);
				o.delete();
			}
		}
		OrdenProduccion aux = null;
		aux = aux.buscarOrdenProduccion (codigo);
		if(aux != null)
			aux.delete();
	}
	
	public void altaLote (LoteDTO ldto){
		Lote l = new Lote(ldto);
		lotes.add(l);
		l.insert();
	}
	public void bajaLote ( int codigoLote){
		for(Lote l: lotes){
			if(l.sosElLote(codigoLote)){
				lotes.add(l);
				l.delete();
			}
		}
		
		Lote aux = null;
		aux= aux.buscarLote(codigoLote);
		if(aux != null)
			aux.delete();
	}
	
	public void modificarLote (LoteDTO ldto){
		Lote lo = new Lote(ldto);
		for(Lote l: lotes){
			if(l.sosElLote(ldto.getCodigo())){
				lotes.add(l);
				l.update(lo);
			}
		}
		
		Lote aux = null;
		aux= aux.buscarLote(ldto.getCodigo());
		if(aux != null)
			aux.update(lo);
	}
	
	
	
	//---------------------------------------------------------------------------
	//Estan los buscarAlgo y buscarAllAlgo nose si deberian ir 
	//---------------------------------------------------------------------------
	
	
	public OrdenProduccionDTO BuscarOrden(int codigo){
		for (OrdenProduccion op : ordenesProduccion){
			if (op.sosLaOrden(codigo)){
				return op.toDTO();
			}
		}
		OrdenProduccion fact = null;
		fact = fact.buscarOrdenProduccion(codigo);
		
		return fact.toDTO();
	}
	public ArrayList<OrdenProduccionDTO> BuscarAllOrden (){
		ArrayList<OrdenProduccionDTO> list = null;
		ArrayList<OrdenProduccion> aux= null;
		// Vale esto ? otra cosa no se me ocurrio, sin tener que llamar al dao desde aca
		OrdenProduccion help=null;
		aux= help.buscarTodos();
				
		for (OrdenProduccion p : aux){
				list.add(p.toDTO());
		}
		return list;
	}
	
	public LoteDTO BuscarLote (int codigo){
		for (Lote p : lotes){
			if (p.sosElLote(codigo)){
				return p.toDTO();
			}
		}
		Lote fact = null;
		fact = fact.buscarLote(codigo);
		
		return fact.toDTO();
	}
	public ArrayList<LoteDTO> BuscarAllLotes (){
		ArrayList<LoteDTO> list = null;
		ArrayList<Lote> aux= null;
		// Vale esto ? otra cosa no se me ocurrio, sin tener que llamar al dao desde aca
		Lote help=null;
		aux= help.buscarTodos();
				
		for (Lote p : aux){
				list.add(p.toDTO());
		}
		return list;
	}
*/
	public OrdenProduccion generarOrdenProduccion(ItemPedidoCliente itemPed, PedidoCliente pc) {
		if(itemPed.getCantidad()>=itemPed.getPrenda().getStockActual()){
			if((itemPed.getCantidad()-itemPed.getPrenda().getStockActual())<=3){
				OrdenProduccion ordenP=new OrdenProduccion();
				ordenP.setCantidad(itemPed.getCantidad()-itemPed.getPrenda().getStockActual());
				Date fecha=new Date();
				ordenP.setFecha(fecha);
				//ordenP.setPedidoCliente(pc);
				ordenP.setPrenda(itemPed.getPrenda());
				ordenP.setTipo("PARCIAL");
				//OrdenProduccionDAO.getInstancia().insert(ordenP);
				return ordenP;
			}
			OrdenProduccion ordenC=new OrdenProduccion();
			ordenC.setCantidad(itemPed.getPrenda().getCantidadAConfeccionar());
			Date fecha=new Date();
			ordenC.setFecha(fecha);
			//ordenC.setPedidoCliente(pc);
			ordenC.setTipo("COMPLETA");
			ordenC.setPrenda(itemPed.getPrenda());
			//OrdenProduccionDAO.getInstancia().insert(ordenC);
			return ordenC;
		}
		return null;
		
	}
	public void persistirOrdenes(PedidoCliente aux, ArrayList<OrdenProduccion> ordenes) {
		if(ordenes!=null){
			for(int i=0;i<ordenes.size();i++){
				ordenes.get(i).setPedidoCliente(aux);
				OrdenProduccionDAO.getInstancia().insert(ordenes.get(i));
			}
		}
		
	}
	

}
