package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
@Entity
public class PedidoClienteEntity  implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2287963077386351831L;

	public PedidoClienteEntity() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPedidoCliente")
	private int numPedidoCliente;
	
	@ManyToOne
	@JoinColumn(name = "idCliente")
	private ClienteEntity cliente;
	private String estado;
	private Date fechaGeneracion;
	@Column(name="fechaEstimadaDespacho")
	private Date fechaProbableDespacho;
	@Column(name="fechaRealDespacho")
	private Date fechaDespacho;
	
	@Transient
	private ArrayList<ItemPedidoClienteEntity> itemsPedidoCliente;
	
	private float precioTotal;

	public int getNumPedidoCliente() {
		return numPedidoCliente;
	}

	public void setNumPedidoCliente(int numPedidoCliente) {
		this.numPedidoCliente = numPedidoCliente;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
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

	public ArrayList<ItemPedidoClienteEntity> getItemsPedidoCliente() {
		return itemsPedidoCliente;
	}

	public void setItemsPedidoCliente(ArrayList<ItemPedidoClienteEntity> itemsPedidoCliente) {
		this.itemsPedidoCliente = itemsPedidoCliente;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

}
