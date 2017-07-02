package controladores;

import java.util.ArrayList;

import dto.LoteInsumoDTO;
import dto.OrdenProduccionDTO;
import negocio.Bulto;
import negocio.Insumo;
import negocio.ItemPedidoCliente;
import negocio.ItemPrendaInsumo;
import negocio.LoteInsumo;
import negocio.OrdenProduccion;
import negocio.PedidoCliente;
import negocio.Ubicacion;
import persistencia.InsumoDAO;
import persistencia.ItemPrendaInsumoDAO;
import persistencia.MovimientosDAO;
import persistencia.PrendaDAO;

public class AdministradorStock {
	private static AdministradorStock instancia = null;
	private ArrayList<LoteInsumo> lotesInsumos;
	private ArrayList<Bulto> bultos;
	private ArrayList<Ubicacion> ubicaciones;

	
	
	public static AdministradorStock getInstancia () {
		if(instancia == null){
			instancia = new AdministradorStock();
		}
		
		return instancia;
	}
	//public void agregarLoteInsumo(Date fechaRec, Proveedor prov, float cant, Insumo ins){
	public void agregarLoteInsumo(LoteInsumoDTO liDTO){
		LoteInsumo li = new LoteInsumo(liDTO);
		this.lotesInsumos.add(li);
		li.insertar ();
	}
	
	public void disminuirStockPorPedido(ArrayList<ItemPedidoCliente> items){
		for (int i=0; i<items.size(); i++){
			//agrega el movimiento
			MovimientosDAO.getInstancia().disminuirStockPrendaPorPedido(items.get(i).getPrenda(),(-1)*items.get(i).getCantidad());
			//cambia e stock actual
			PrendaDAO.getInstancia().disminuirStock(items.get(i).getPrenda(),items.get(i).getCantidad());
			
		}
		
		
		
	}
	
	public ArrayList<OrdenProduccion> verificarStockyGenerarOrdenes(PedidoCliente pc) {
		return AdministradorProduccion.getInstancia().generarOrdenes(pc);		
	}
	
	public void fabricar(OrdenProduccionDTO orden){
		OrdenProduccion o = new OrdenProduccion(orden);
		o.getPrenda().aumentarStock(o.getCantidad());
		ArrayList<ItemPrendaInsumo> itemsIns = new ArrayList<>();
		itemsIns = ItemPrendaInsumoDAO.getInstancia().obtenerTodosDePrenda(o.getPrenda().getIdPrenda());
		System.out.println(itemsIns.size());
		//itemsIns = o.getPrenda().getInsumos();		
		for (ItemPrendaInsumo i : itemsIns){
			
			Insumo ins = i.getInsumo();
			System.out.println(ins.toString());
			float stockAct = ins.getStockActual();
			stockAct = stockAct - i.getCantidad();
			ins.setStockActual(stockAct);
			InsumoDAO.getInstancia().update(ins);;
		}
		
	}
	
	public ArrayList<LoteInsumo> getLotesInsumos() {
		return lotesInsumos;
	}
	public void setLotesInsumos(ArrayList<LoteInsumo> lotesInsumos) {
		this.lotesInsumos = lotesInsumos;
	}
	public ArrayList<Bulto> getBultos() {
		return bultos;
	}
	public void setBultos(ArrayList<Bulto> bultos) {
		this.bultos = bultos;
	}
	public ArrayList<Ubicacion> getUbicaciones() {
		return ubicaciones;
	}
	public void setUbicaciones(ArrayList<Ubicacion> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}
	
	
	/*
	public void agregarBulto(BultoDTO bulDto) { // lo cambie por DTO la entrada,  
			Bulto bul = new Bulto(bulDto);
			bultos.add(bul);
			bul.insertar();
	}

	public void agregarUbicacionLoteInsumo(int codLoteInsumo, String codigo) { // 
		LoteInsumo li = instancia.getInstancia().buscarLoteInsumo(codLoteInsumo);
		UbicacionLoteInsumo uli= new UbicacionLoteInsumo(li, codigo);
		ubicaciones.add(uli);
		uli.insertar ();
	}

	public void agrgarUbicacionBulto(int codigoBulto, String codigo) {
			Bulto bul= instancia.getInstancia().buscarBulto(codigoBulto);
			UbicacionBulto ub = new UbicacionBulto(bul,codigo);
			ubicaciones.add(ub);
			ub.insertar();
			
	}

	private Insumo buscarInsumo(int codigo) {
		for (LoteInsumo li : lotesInsumos){
			if (li.getInsumo().sosElInsumo(codigo)){
				return li.getInsumo();
			}
		}
		Insumo aux = null;
		
		aux= aux.buscarInsumo (codigo);
		return aux;
	}

	
	

	private LoteInsumo buscarLoteInsumo(int codigo) {
		for(LoteInsumo li: lotesInsumos){
			if(li.sosElLote(codigo))
				return li;
		}
		LoteInsumo aux = null;
		aux= aux.buscarLoteInsumo (codigo);
		return aux;

	}

	

	public void quitarBulto(int codigoBulto) {
		for (Bulto bul : bultos){
			if(bul.sosElBulto(codigoBulto)){
				bultos.remove(bul);
				bul.delete();
				
			}
		}
		Bulto aux = null;
		aux= aux.buscarBulto (codigoBulto);
		if(aux !=null)
			aux.delete();

	}
	public void quitarLoteInsumo(int codigoLote) {
		for (LoteInsumo l : lotesInsumos){
			if(l.sosElLote(codigoLote)){
				lotesInsumos.remove(l);
				l.delete();
				
			}
		}
		LoteInsumo aux = null;
		aux= aux.buscarLoteInsumo (codigoLote);
		if(aux!=null)
			aux.delete();

	}
	public void quitarUbicacion(String codigoUbicacion) {
		for (Ubicacion u : ubicaciones){
			if(u.sosLaUbicacion(codigoUbicacion)){
				ubicaciones.remove(u);
				u.delete();
				
			}
		}
		Ubicacion aux= null;
		aux= aux.buscarUbicacion();
		if(aux== null)
			aux.delete();

	}


	public boolean verificarStockPrenda(PedidoCliente pedido ) {
		ArrayList<ItemPedidoCliente> aux = pedido.getItemsPedidoCliente();
		int cant = 0;
		for (ItemPedidoCliente i: aux){
			cant = i.getCantidad();
			for(Bulto b : bultos){
				if(i.getPrenda().getCodigo() == b.getPrenda().getCodigo()){
					cant = cant - b.getCantidad ();
				}
				if(cant == 0)
					break;
			}
			if(cant > 0)
				return false;
		}
		return true;

	}

	public boolean verificarStockInsumo(Insumo insumo, int cantidad){
		float cant = cantidad;
		for(LoteInsumo li : lotesInsumos){
			if(li.getInsumo().sosElInsumo(insumo.getCodigo())){
				cant= cant - li.getInsumo().getStockActual();
			}
		}
		
		if(cant > 0)
			return false;
		else
			return true;
	}

	private Bulto buscarBulto(int codigoBulto) {
		for (Bulto bul : bultos){
			if(bul.sosElBulto(codigoBulto))
			 return bul;
		}
		Bulto aux = null;
		aux= aux.buscarBulto (codigoBulto);
		return aux;
	}
	
	//---------------------------------------------------------------------------
	//Estan los buscarAlgo y buscarAllAlgo nose si deberian ir 
	//---------------------------------------------------------------------------
	
	
	public BultoDTO BuscarBulto(int codigo){
		for (Bulto b : bultos){
			if (b.sosElBulto(codigo)){
				return b.toDTO();
			}
		}
		Bulto fact = null;
		fact = fact.buscarBulto(codigo);
		
		return fact.toDTO();
	}
	public ArrayList<BultoDTO> BuscarAllBulto (){
		ArrayList<BultoDTO> list = null;
		ArrayList<Bulto> aux= null;
		// Vale esto ? otra cosa no se me ocurrio, sin tener que llamar al dao desde aca
		Bulto help=null;
		aux= help.buscarTodos();
				
		for (Bulto p : aux){
				list.add(p.toDTO());
		}
		return list;
	}
	
	public LoteInsumoDTO BuscarLoteInsumo (int codigo){
		for (LoteInsumo p : lotesInsumos){
			if (p.sosElLote(codigo)){
				return p.toDTO();
			}
		}
		LoteInsumo fact = null;
		fact = fact.buscarLoteInsumo(codigo);
		
		return fact.toDTO();
	}
	public ArrayList<LoteInsumoDTO> BuscarAllLotesInsumo (){
		ArrayList<LoteInsumoDTO> list = null;
		ArrayList<LoteInsumo> aux= null;
		// Vale esto ? otra cosa no se me ocurrio, sin tener que llamar al dao desde aca
		LoteInsumo  help=null;
		aux= help.buscarTodos();
				
		for (LoteInsumo p : aux){
				list.add(p.toDTO());
		}
		return list;
	}
	*/
	
	
}
