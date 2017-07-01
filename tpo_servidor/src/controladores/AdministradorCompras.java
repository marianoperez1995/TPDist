package controladores;

import java.util.ArrayList;
import java.util.Date;

import dto.InsumoDTO;
import dto.PedidoClienteDTO;
import dto.ProveedorDTO;
import negocio.Insumo;
import negocio.ItemPedidoInsumo;
import negocio.OrdenProduccion;
import negocio.PedidoCliente;
import negocio.PedidoInsumo;
import negocio.Proveedor;
import persistencia.OrdenProduccionDAO;
import persistencia.PedidoInsumoDAO;

public class AdministradorCompras {
	
	//Test commit
	private ArrayList<Proveedor> proveedores;
	private ArrayList<PedidoInsumo> pedidosInsumos;
	private ArrayList<PedidoCliente> pedidosClientes;
	
	

	public void generarOrdenCompra(InsumoDTO insDTO,ProveedorDTO proDto,Date fEntrega, Date fPedido, int codOP) {
	
		
		Insumo i= new Insumo(insDTO);
		Proveedor p=new Proveedor(proDto);
		OrdenProduccion op = null;
	//	op= op.buscarOrdenProduccion(codOP);
		op = OrdenProduccionDAO.getInstancia().getOrdenProduccion(codOP);
		PedidoInsumo nuevo = new PedidoInsumo();
		nuevo.setProveedor(p);
		nuevo.setOrdenProduccion(op);
		nuevo.setFechaEntrega(fEntrega);
		nuevo.setFechaPedido(fPedido);
		ItemPedidoInsumo aux= new ItemPedidoInsumo();
		aux.setInsumo(i);
		aux.setCantidad(i.getCantAComprar());
		nuevo.getItemsPedidoInsumo().add(aux);
		
		pedidosInsumos.add(nuevo);
		
	}

	public void generarPedido(PedidoClienteDTO pcDto) {
		PedidoCliente aux = new PedidoCliente(pcDto);
		pedidosClientes.add(aux);
		aux.insertar();
		
	}

	public PedidoInsumo buscarPedidoInsumo(int codigo) {
		for (PedidoInsumo p : pedidosInsumos){
			if (p.sosElPedido(codigo))
				return p;
		}
		return PedidoInsumoDAO.getInstancia().getPedidoInsumo(codigo);		
	}

	public ArrayList<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(ArrayList<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}
}
