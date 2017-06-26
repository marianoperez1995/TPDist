package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
@Entity
@Table(name="PedidosCliente")
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
	private Date fechaEntregaCliente;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idPedidoCliente")
	private List<ItemPedidoClienteEntity> itemsPedidoCliente;
	
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

	public List<ItemPedidoClienteEntity> getItemsPedidoCliente() {
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

	public Date getFechaEntregaCliente() {
		return fechaEntregaCliente;
	}

	public void setFechaEntregaCliente(Date fechaEntregaCliente) {
		this.fechaEntregaCliente = fechaEntregaCliente;
	}

}
