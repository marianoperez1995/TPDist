package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="Facturas")
public class FacturaEntity implements Serializable {
	/**
	 * 
	 */
	
	public FacturaEntity(){		
	}
	public FacturaEntity(int numeroFact, float total, float impuestos, Date fechaGeneracion, ClienteEntity cliente,
			PedidoClienteEntity pedido) {
		super();
		this.numeroFact = numeroFact;
		this.total = total;
		this.impuestos = impuestos;
		this.fechaGeneracion = fechaGeneracion;
		this.cliente = cliente;
		this.pedido = pedido;
	}
	private static final long serialVersionUID = 3629200090802997246L;

	@Id
	@Column(name="idFactura")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numeroFact;	
	private float total;
	private float subtotal;
	private float impuestos;
	private Date fechaGeneracion;
	@ManyToOne
	@JoinColumn(name="idCliente")
	private ClienteEntity cliente;
	@OneToOne( fetch = FetchType.EAGER)
	@JoinColumn(name = "idPedidoCliente", referencedColumnName = "idPedidoCliente")
	private PedidoClienteEntity pedido;

	public int getNumeroFact() {
		return numeroFact;
	}

	public void setNumeroFact(int numeroFact) {
		this.numeroFact = numeroFact;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public float getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(float impuestos) {
		this.impuestos = impuestos;
	}

	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public PedidoClienteEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoClienteEntity pedido) {
		this.pedido = pedido;
	}
}
