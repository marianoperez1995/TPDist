package controladores;

import java.util.ArrayList;
import java.util.Date;

import negocio.PedidoCliente;
import negocio.Transporte;

public class Despacho {
	private ArrayList<Transporte> transportes;
	private ArrayList<PedidoCliente> pedidos;
private static Despacho instancia = null;
	
	
	private static Despacho getInstancia (){
		if(instancia== null)
			instancia= new Despacho();
		return instancia;
	}
	public void registrarFecha(int numeroPedido, Date fechaRealDespecho) { 
		//agregue que se ingrese la fecha porque se puede registrar en un dia distinto al que se realizo la entrega
		for (PedidoCliente pc: pedidos){
			if(pc.getNumPedidoCliente()==  numeroPedido){
				pc.setFechaDespacho(fechaRealDespecho);
				pc.update(pc);
			}
		}
		PedidoCliente aux = null;
		aux = aux.buscarPedidoCliente(numeroPedido);
		if(aux != null){
			aux.setFechaDespacho(fechaRealDespecho);
			aux.update(aux);
		}
	}


	public void confeccionarEnvio(PedidoCliente pedido, int codigoTransporte) {
		// se agrega el codigo para asociar al transporte y en transpote se agrega el campo pedidoClienteEntrega
		// para poder asociar el tranporte a un pedido (cambiar a un array si un transporte puede llevar mas de un pedido)
		// Asumo que transporte se encuentra en la BD
		PedidoCliente aux= null;
		for(PedidoCliente p : pedidos){
			if( (pedido.getNumPedidoCliente() == p.getNumPedidoCliente()) 
					&&   p.getEstado().equalsIgnoreCase("Confirmado")){
				for(Transporte t: transportes){
					if(t.sosElTranporte(codigoTransporte))
						t.setPedidoClienteEntrega(pedido);
						t.update (t);
				}
			}	
		}
		
		 aux = aux.buscarPedidoCliente(pedido.getNumPedidoCliente());
		 if(aux != null){
			 Transporte aux2= null;
			 aux2= aux2.buscarTransporte(codigoTransporte);
			 if(aux2 == null){
				 aux2.setPedidoClienteEntrega(aux);
				 aux2.update(aux2);
			 }
		 }
		 
	}

	private Transporte buscarTransporte(int codigo) {
		for (Transporte t: transportes){
			if (t.sosElTranporte(codigo))
				return t;
		}
		return null;
	}
}
