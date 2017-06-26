package negocio;

import java.util.ArrayList;
import java.util.Date;

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
	private Date fechaEntregaCliente;
	private ArrayList<ItemPedidoCliente> itemsPedidoCliente;
	private float precioTotal;
	
	public PedidoCliente(PedidoClienteDTO pedDTO) {
		this.idPedidoCliente = pedDTO.getIdPedidoCliente();
		this.cliente = new Cliente(pedDTO.getCliente());
		this.estado = pedDTO.getEstado();
		this.fechaGeneracion = pedDTO.getFechaGeneracion();
		this.fechaProbableDespacho = pedDTO.getFechaProbableDespacho();
		this.fechaDespacho = pedDTO.getFechaDespacho();
		//ItemPedidoCliente item=new ItemPedidoCliente();
		ArrayList<ItemPedidoCliente> items=new ArrayList<ItemPedidoCliente>();
		//System.out.println(items.get(0).getPrenda().getDescripcion());
		//System.out.println(items.get(1).getPrenda().getDescripcion());
		this.precioTotal=pedDTO.getPrecioTotal();
		for (ItemPedidoClienteDTO item:  pedDTO.getItemsPedidoCliente()){
			items.add(new ItemPedidoCliente(item));
		}
		this.itemsPedidoCliente=items;
		this.fechaEntregaCliente=pedDTO.getFechaEntregaCliente();
	}

	public PedidoCliente(PedidoClienteEntity pedE) {
		this.idPedidoCliente = pedE.getNumPedidoCliente();
		this.cliente = new Cliente(pedE.getCliente());
		this.estado = pedE.getEstado();
		this.fechaGeneracion = pedE.getFechaGeneracion();
		this.fechaProbableDespacho = pedE.getFechaProbableDespacho();
		this.fechaDespacho = pedE.getFechaDespacho();
		this.itemsPedidoCliente= new ArrayList<ItemPedidoCliente>();
		this.precioTotal=pedE.getPrecioTotal();
		for (ItemPedidoClienteEntity p : pedE.getItemsPedidoCliente()){
			this.itemsPedidoCliente.add(new ItemPedidoCliente(p));
		}
		this.fechaEntregaCliente =pedE.getFechaEntregaCliente();
	}
	public PedidoCliente() {
		// TODO Auto-generated constructor stub
	}

	public PedidoCliente(PedidoClienteEntity pedE, Cliente c) {
		this.idPedidoCliente = c.getIdCliente();
		this.cliente = c;
		this.estado = pedE.getEstado();
		this.fechaGeneracion = pedE.getFechaGeneracion();
		this.fechaProbableDespacho = pedE.getFechaProbableDespacho();
		this.fechaDespacho = pedE.getFechaDespacho();
		for (ItemPedidoClienteEntity p : pedE.getItemsPedidoCliente()){
			this.itemsPedidoCliente.add(new ItemPedidoCliente(p));
		}
		this.fechaEntregaCliente =pedE.getFechaEntregaCliente();
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
	public PedidoClienteDTO toDTO() {
		PedidoClienteDTO p = new PedidoClienteDTO();
		p.setCliente(cliente.toDTO());
		p.setEstado(estado);
		p.setFechaDespacho(fechaDespacho);
		p.setFechaGeneracion(fechaGeneracion);
		p.setFechaProbableDespacho(fechaProbableDespacho);
		p.setFechaEntregaCliente(fechaEntregaCliente);
		p.setIdPedidoCliente(idPedidoCliente);
		ArrayList<ItemPedidoClienteDTO> itemsDTO = new ArrayList<ItemPedidoClienteDTO>();
		for(int i=0;i<itemsPedidoCliente.size();i++){
			ItemPedidoClienteDTO itemDTO=new ItemPedidoClienteDTO();

			itemDTO.setCantidad(itemsPedidoCliente.get(i).getCantidad());
			itemDTO.setPrecio(itemsPedidoCliente.get(i).getPrecio());
			itemDTO.setPrenda(itemsPedidoCliente.get(i).getPrenda().toDTO());
			itemsDTO.add(itemDTO);
		}
		p.setItemsPedidoCliente(itemsDTO);
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
		ArrayList<ItemPedidoClienteDTO> items = new ArrayList<ItemPedidoClienteDTO>();
		for (ItemPedidoCliente i : this.itemsPedidoCliente){
			items.add(i.toDTO(p));
		}
		p.setItemsPedidoCliente(items);
		p.setPrecioTotal(precioTotal);
		return p;
	}

	public Date getFechaEntregaCliente() {
		return fechaEntregaCliente;
	}

	public void setFechaEntregaCliente(Date fechaEntregaCliente) {
		this.fechaEntregaCliente = fechaEntregaCliente;
	}
	
	public float montoAPagarEnCasoDeCancelacion(){
		if(this.estado.equalsIgnoreCase("Confirmado")){
			return this.precioTotal;
			
		}
		
		return 0;
		
		
	}

	@Override
	public String toString() {
		return "PedidoCliente [idPedidoCliente=" + idPedidoCliente + ", cliente=" + cliente + ", estado=" + estado
				+ ", fechaGeneracion=" + fechaGeneracion + ", fechaProbableDespacho=" + fechaProbableDespacho
				+ ", fechaDespacho=" + fechaDespacho + ", fechaEntregaCliente=" + fechaEntregaCliente
				+ ", itemsPedidoCliente=" + itemsPedidoCliente + ", precioTotal=" + precioTotal + "]";
	}

	public String verificarPedido() {
		int ok=0;
		for (ItemPedidoCliente item: this.itemsPedidoCliente){
			if (!item.getPrenda().isEstadoProduccion()){
				if (!item.getPrenda().verificarCantidad(item.getCantidad())){
					ok=1;
				}
			}
		}
		if (this.getCliente().verificarLimite(this.precioTotal) && ok==0){
			return "Aprobado";
		} else {
			return "desaprobado";
		}
	}

	
}
