package controladores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import negocio.AreaProduccion;
import negocio.Bulto;
import negocio.Insumo;
import negocio.ItemPedidoCliente;
import negocio.ItemPrendaArea;
import negocio.ItemPrendaInsumo;
import negocio.LineaProduccion;
import negocio.Lote;
import negocio.OrdenProduccion;
import negocio.PedidoCliente;
import negocio.Prenda;
import persistencia.InsumoDAO;
import persistencia.ItemPrendaAreaDAO;
import persistencia.ItemPrendaInsumoDAO;
import persistencia.PedidoClienteDAO;

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

	public ArrayList<OrdenProduccion> generarOrdenes(PedidoCliente p){ 
		ArrayList<ItemPedidoCliente> items = p.getItemsPedidoCliente();
		ArrayList<OrdenProduccion> ordenes = new ArrayList<>();
		ArrayList<Prenda> prendasAFabricar = new ArrayList<>();
		for (ItemPedidoCliente i : items)
			if (i.getPrenda().getStockActual() < i.getCantidad())
				prendasAFabricar.add(i.getPrenda());	
		
		HashMap<Prenda, HashSet<String>> mapa = new HashMap<>();
		
		for (Prenda prenda : prendasAFabricar) {
			HashSet<String> distintos = mapa.get(prenda);
			
			if (distintos == null) {
				distintos = new HashSet<>();
				mapa.put(prenda, distintos);
			}
			
			distintos.add("COLOR_" + prenda.getColor());
			distintos.add("TALLE_" + prenda.getTalle());
		}

		for (Entry<Prenda, HashSet<String>> entry : mapa.entrySet()){
 			OrdenProduccion orden = new OrdenProduccion();
			Prenda prenda = entry.getKey();
			orden.setCantidad(prenda.getCantidadAConfeccionar());
			orden.setFecha(Calendar.getInstance().getTime());
			orden.setPedidoCliente(p);
			orden.setPrenda(prenda);
			
			//Si hay 6 o menos strings diferentes (entre la combinacion de colores y talles), lo toma como parcial
			//no se repiten los valores, porque es un hashset
			if (entry.getValue().size() <= 6){
				orden.setTipo("OPP");
			}
			else{
				orden.setTipo("OPC");
			}
			ordenes.add(orden);
		}
		return ordenes;		
	}
	
	public void fabricar(OrdenProduccion orden) { //SI NO FUNCIONA,hacer      new Thread(() -> fabricar(orden)).start();     cuando se llama al metodo, quitar lo del thread
		Thread t1 = new Thread(new Runnable() { //Hace todo en un nuevo thread, para que no tilde toda la aplicacion
			public void run() {
				orden.setEstado("En fabricacion");
				orden.update();
				PedidoCliente p = orden.getPedidoCliente();

				for (ItemPedidoCliente i : p.getItemsPedidoCliente()) {
					ArrayList<ItemPrendaArea> itemspa = ItemPrendaAreaDAO.getInstancia()
							.obtenerPorPrenda(i.getPrenda().getIdPrenda());
					int cantAProducirDePrenda = i.getCantidad();
					float minutosTotal = 0;
					for (ItemPrendaArea item : itemspa) {
						minutosTotal = minutosTotal + item.getMinutoEnArea(); 
						
					}
					for (ItemPrendaArea item : itemspa){
						if (minutosTotal <= 0){
							break;
						}
						else{
							AreaProduccion area = item.getArea();
							for (LineaProduccion l : area.getLineasProduccion()){
								minutosTotal = minutosTotal - item.getMinutoEnArea();
								try {
									if (!l.isEstado()){//no esta en uso la linea
										if (esFabricable (i.getPrenda(), i.getCantidad())){ //alcanzan los insumos
										
											l.setHoraInicio(Calendar.getInstance().getTime());
											l.setEstado(true);			
											l.actualizar();
											long tiempo = item.getMinutoEnArea() *1500;
											System.out.println("espera por "+tiempo +" ms");
											Thread.sleep(tiempo); //paso el tiempo, produjo la prenda en su cantidad maxima
											//agregarle *60 para q sean minutos
											l.setTiempoDeUso(tiempo);
											l.setEstado(false);		
											l.actualizar();
										}
									}
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								if (minutosTotal <= 0){
									break;
								}
							}
						}
					}
					//crear bultos, ya estan creadas las prendas aca, se actualizan en tabla Prendas y Bulto
					ArrayList<Bulto> bultos = new ArrayList<>();
					bultos = convertirABulto(i.getPrenda(),cantAProducirDePrenda);
					for (Bulto b : bultos)
						b.insertar();
					i.getPrenda().setStockActual(i.getPrenda().getStockActual() + cantAProducirDePrenda);
					i.getPrenda().update();
				}
				orden.setEstado("Completa");
				orden.update();
				if (orden.termino()){
					orden.getPedidoCliente().setEstado("Completo");
					PedidoClienteDAO.getInstancia().update(orden.getPedidoCliente());
				}
			}		
		});
		t1.start();
	}

	private boolean esFabricable(Prenda prenda, int cantidad) {
		ArrayList<ItemPrendaInsumo> insumosNecesarios = ItemPrendaInsumoDAO.getInstancia().obtenerTodosDePrenda(prenda.getIdPrenda());
		HashMap<Insumo, Float> mapa = new HashMap<>();
		for (ItemPrendaInsumo i : insumosNecesarios){
			mapa.put(i.getInsumo(), i.getCantidad());
		}
		
		return InsumoDAO.getInstancia().existenInsumosSuficientes(mapa);
		
	
	}
	private ArrayList<Bulto> convertirABulto(Prenda prenda, int cant) {
		ArrayList<Bulto> bultos = new ArrayList<>();
		while (cant > 0){
			Bulto bulto = new Bulto();
			if (cant < 150 && cant >= 0){
				bulto.setCantidad(cant);
				bulto.setPrenda(prenda);
			}
			else{
				bulto.setCantidad(150);
				bulto.setPrenda(prenda);
			}
			if (cant < 0){
				bulto.setCantidad(cant*-1);
				bulto.setPrenda(prenda);
			}
			cant = cant - 150;
			bultos.add(bulto);
		}		
		return bultos;		
	}
	
	public ArrayList<Prenda> getPrendas() {
		return prendas;
	}
	public void setPrendas(ArrayList<Prenda> prendas) {
		this.prendas = prendas;
	}
	public ArrayList<AreaProduccion> getAreasProduccion() {
		return areasProduccion;
	}
	public void setAreasProduccion(ArrayList<AreaProduccion> areasProduccion) {
		this.areasProduccion = areasProduccion;
	}
	public ArrayList<OrdenProduccion> getOrdenesProduccion() {
		return ordenesProduccion;
	}
	public void setOrdenesProduccion(ArrayList<OrdenProduccion> ordenesProduccion) {
		this.ordenesProduccion = ordenesProduccion;
	}
	public ArrayList<Lote> getLotes() {
		return lotes;
	}
	public void setLotes(ArrayList<Lote> lotes) {
		this.lotes = lotes;
	}

	public void persistirOrdenes(ArrayList<OrdenProduccion> ordenes) {
		for (OrdenProduccion o : ordenes){			
			o.insertar();
		}
	}
	

}
