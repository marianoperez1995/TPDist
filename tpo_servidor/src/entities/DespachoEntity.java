package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Despacho")
public class DespachoEntity implements Serializable {

	public DespachoEntity(){
		
	}
	
	public DespachoEntity(int idDespacho, String descripcion, List<PedidoClienteEntity> pedidosCliente,
			List<TransporteEntity> transportes) {
		super();
		this.idDespacho = idDespacho;
		this.descripcion = descripcion;
		this.pedidosCliente = pedidosCliente;
		this.transportes = transportes;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4244361380913636251L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idDespacho;
	private String descripcion;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinTable(name = "Despacho_PedidosCliente", joinColumns = {
	@JoinColumn(name = "idDespacho") }, inverseJoinColumns = { @JoinColumn(name = "idPedidoCliente") })
	private List<PedidoClienteEntity> pedidosCliente;
	

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinTable(name = "Despacho_Transporte", joinColumns = {
	@JoinColumn(name = "idDespacho") }, inverseJoinColumns = { @JoinColumn(name = "idTransporte") })
	private List<TransporteEntity> transportes;


	public int getIdDespacho() {
		return idDespacho;
	}


	public void setIdDespacho(int idDespacho) {
		this.idDespacho = idDespacho;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public List<PedidoClienteEntity> getPedidosCliente() {
		return pedidosCliente;
	}


	public void setPedidosCliente(List<PedidoClienteEntity> pedidosCliente) {
		this.pedidosCliente = pedidosCliente;
	}


	public List<TransporteEntity> getTransportes() {
		return transportes;
	}


	public void setTransportes(List<TransporteEntity> transportes) {
		this.transportes = transportes;
	}
	
	
	
}
