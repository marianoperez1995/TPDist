package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="OrdenesProduccion")
public class OrdenProduccionEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2423009401608373264L;
	public OrdenProduccionEntity(int codigo, Date fecha) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
	}


	public OrdenProduccionEntity() {
		
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idOrdenProduccion")
	protected int codigo;
	
	protected Date fecha;
	protected String tipo;
	@ManyToOne
	@JoinColumn(name="idPedidoCliente")
	protected PedidoClienteEntity pedidoCliente;
	@ManyToOne
	@JoinColumn(name="idPrenda")
	protected PrendaEntity prenda;
	protected int cantidad;
	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public PedidoClienteEntity getPedidoCliente() {
		return pedidoCliente;
	}

	public void setPedidoCliente(PedidoClienteEntity pedidoCliente) {
		this.pedidoCliente = pedidoCliente;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean esParcial() {
		return (this.tipo.equals("opp"));
	}

	public PrendaEntity getPrenda() {
		// TODO Auto-generated method stub
		return prenda;
	}

	
}
