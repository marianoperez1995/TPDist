package negocio;

import dto.OpcDTO;
import dto.OrdenProduccionDTO;
import entities.OrdenProduccionEntity;
import persistencia.OrdenProduccionDAO;

public class Opc extends OrdenProduccion {

	public Opc (OpcDTO opDTO){
		this.fecha = opDTO.getFecha();
		this.idOrdenProduccion = opDTO.getCodigo();
		this.pedidoCliente = new PedidoCliente (opDTO.getPedidoCliente());
		this.prenda = new Prenda (opDTO.getPrenda());
	}
	public Opc() {

	}
	public Opc(OrdenProduccionDTO opDTO) {
		this.fecha = opDTO.getFecha();
		this.idOrdenProduccion = opDTO.getCodigo();
		this.pedidoCliente = new PedidoCliente (opDTO.getPedidoCliente());
		this.prenda = new Prenda (opDTO.getPrenda());
	}	
	public Opc(OrdenProduccionEntity ope) {
		this.fecha = ope.getFecha();
		this.idOrdenProduccion = ope.getCodigo();
		this.pedidoCliente = new PedidoCliente (ope.getPedidoCliente());
		this.prenda = new Prenda (ope.getPrenda());

	}	
	
}
