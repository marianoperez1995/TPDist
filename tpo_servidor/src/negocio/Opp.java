package negocio;

import java.util.ArrayList;

import dto.OppDTO;
import dto.OrdenProduccionDTO;
import entities.OrdenProduccionEntity;
import persistencia.OrdenProduccionDAO;

public class Opp extends OrdenProduccion {



	public Opp (OppDTO opDTO){
		this.fecha = opDTO.getFecha();
		this.idOrdenProduccion = opDTO.getCodigo();
		this.pedidoCliente = new PedidoCliente (opDTO.getPedidoCliente());
		this.prenda = new Prenda (opDTO.getPrenda());

	}
	
	public Opp(){
		
	}

	public Opp(OrdenProduccionDTO opDTO) {
		this.fecha = opDTO.getFecha();
		this.idOrdenProduccion = opDTO.getCodigo();
		this.pedidoCliente = new PedidoCliente (opDTO.getPedidoCliente());
		this.prenda = new Prenda (opDTO.getPrenda());
		
	}

	public Opp(OrdenProduccionEntity ope) {
		this.fecha = ope.getFecha();
		this.idOrdenProduccion = ope.getCodigo();
		this.pedidoCliente = new PedidoCliente (ope.getPedidoCliente());
		this.prenda = new Prenda (ope.getPrenda());
		
	}



}

