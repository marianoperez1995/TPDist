package negocio;

import java.util.ArrayList;
import java.util.Date;

import dto.ClienteDTO;
import dto.ItemPedidoClienteDTO;
import dto.PedidoClienteDTO;
import entities.ItemPedidoClienteEntity;
import entities.PedidoClienteEntity;
import persistencia.PedidoClienteDAO;

public class PedidoCliente {
	private int idPedidoCliente;
	private Cliente cliente;
	private String estado;
	private Date fechaGeneracion;
	private Date fechaProbableDespacho;
	private Date fechaDespacho;
	private ArrayList<ItemPedidoCliente> itemsPedidoCliente;
	private float precioTotal;
	
	public PedidoCliente(PedidoClienteDTO pedDTO) {
		this.idPedidoCliente = pedDTO.getIdPedidoCliente();
		this.cliente = new Cliente(pedDTO.getCliente());
		this.estado = pedDTO.getEstado();
		this.fechaGeneracion = pedDTO.getFechaGeneracion();
		this.fechaProbableDespacho = pedDTO.getFechaProbableDespacho();
		this.fechaDespacho = pedDTO.getFechaDespacho();
		for (ItemPedidoClienteDTO p : pedDTO.getItemsPedidoCliente()){
			this.itemsPedidoCliente.add(new ItemPedidoCliente(p));
		}
	}

	public PedidoCliente(PedidoClienteEntity pedE) {
		this.idPedidoCliente = pedE.getNumPedidoCliente();
		this.cliente = new Cliente(pedE.getCliente());
		this.estado = pedE.getEstado();
		this.fechaGeneracion = pedE.getFechaGeneracion();
		this.fechaProbableDespacho = pedE.getFechaProbableDespacho();
		this.fechaDespacho = pedE.getFechaDespacho();
		for (ItemPedidoClienteEntity p : pedE.getItemsPedidoCliente()){
			this.itemsPedidoCliente.add(new ItemPedidoCliente(p));
		}
	}
	public void insertar() {
		PedidoClienteDAO.getInstancia().insert(this);		
	}

	public void borrar() {
		PedidoClienteDAO.getInstancia().eliminar(this.idPedidoCliente);
	}
	public void confirmarPedido(Date fechaProbableDespacho) {
		this.estado = "Confirmado"; //Supongo q son Confirmado / Por confirmar / Cancelado
	}

	public void cancelarPedido(String motivos) {
		this.estado = "Cancelado";		
	}

	public void aceptarPedidoPorCliente() {
		//falta
	}

	public void cancelarPedidoPorCliente() {
		//falta
	}

	public float calcularPrecio() {
		float precio = 0;
		for (ItemPedidoCliente i : itemsPedidoCliente){
			precio = precio + i.getPrecio(); 
		}		
		this.precioTotal = precio;				
		return precio;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	public Date getFechaProbableDespacho() {
		return fechaProbableDespacho;
	}

	public void setFechaProbableDespacho(Date fechaProbableDespacho) {
		this.fechaProbableDespacho = fechaProbableDespacho;
	}

	public Date getFechaDespacho() {
		return fechaDespacho;
	}

	public void setFechaDespacho(Date fechaDespacho) {
		this.fechaDespacho = fechaDespacho;
	}

	public ArrayList<ItemPedidoCliente> getItemsPedidoCliente() {
		return itemsPedidoCliente;
	}

	public void setItemsPedidoCliente(ArrayList<ItemPedidoCliente> itemsPedidoCliente) {
		this.itemsPedidoCliente = itemsPedidoCliente;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

	public int getIdPedidoCliente() {
		return idPedidoCliente;
	}

	public void setIdPedidoCliente(int idPedidoCliente) {
		this.idPedidoCliente = idPedidoCliente;
	}

	
	//Se llama desde Cliente.toDTO()
	public PedidoClienteDTO toDTO(ClienteDTO cliente) {
		PedidoClienteDTO p = new PedidoClienteDTO();
		p.setCliente(cliente); //Va a tener la sucursal y pedidos sin nada el cliente aca
		p.setEstado(estado);
		p.setFechaDespacho(fechaDespacho);
		p.setFechaGeneracion(fechaGeneracion);
		p.setFechaProbableDespacho(fechaProbableDespacho);
		p.setIdPedidoCliente(idPedidoCliente);
		ArrayList<ItemPedidoClienteDTO> items = new ArrayList<>();
		for (ItemPedidoCliente i : this.itemsPedidoCliente){
			items.add(i.toDTO(p));
		}
		p.setItemsPedidoCliente(items);
		p.setPrecioTotal(precioTotal);
		return p;
	}

	//Este se llama desde Factura.toDTO()
	public PedidoClienteDTO toDTO(Factura fac) {
		PedidoClienteDTO p = new PedidoClienteDTO();
		p.setCliente(fac.getCliente().toDTO()); 
		p.setEstado(estado);
		p.setFechaDespacho(fechaDespacho);
		p.setFechaGeneracion(fechaGeneracion);
		p.setFechaProbableDespacho(fechaProbableDespacho);
		p.setIdPedidoCliente(idPedidoCliente);
		ArrayList<ItemPedidoClienteDTO> items = new ArrayList<>();
		for (ItemPedidoCliente i : this.itemsPedidoCliente){
			items.add(i.toDTO(p));
		}
		p.setItemsPedidoCliente(items);
		p.setPrecioTotal(precioTotal);
		return p;
	}
}
