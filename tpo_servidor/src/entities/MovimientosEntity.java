package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Movimientos")
public class MovimientosEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2146241905306386039L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMovimiento;
	@JoinColumns({
		@JoinColumn(name = "idPrenda", referencedColumnName = "idPrenda"),
		@JoinColumn(name = "idColor", referencedColumnName = "idColor"),
		@JoinColumn(name = "idTalle", referencedColumnName = "idTalle") })
	private PrendaEntity prenda;
	
	private String tipo;
	private int cantidad;
	@ManyToOne
	@JoinColumn(name="idCliente")
	private ClienteEntity cliente;
	@OneToOne //ver
	@JoinColumn(name="idPedido")
	private PedidoClienteEntity pedido;
	@OneToOne  //ver
	@JoinColumn(name="idOrden")
	private OrdenProduccionEntity orden;
	
	public PrendaEntity getPrenda() {
		return prenda;
	}

	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}

	public int getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
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

	public OrdenProduccionEntity getOrden() {
		return orden;
	}

	public void setOrden(OrdenProduccionEntity orden) {
		this.orden = orden;
	}
	
	
	
	
}
