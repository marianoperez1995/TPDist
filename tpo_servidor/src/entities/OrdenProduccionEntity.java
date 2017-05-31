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
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@Entity
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo",discriminatorType=DiscriminatorType.STRING)
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
	@Transient
	protected String tipo;
	@Transient
	protected PedidoClienteEntity pedidoCliente;
	@Transient
	protected PrendaEntity prenda;
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
