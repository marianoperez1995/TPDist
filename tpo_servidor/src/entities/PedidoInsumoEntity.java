package entities;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PedidoInsumos")
public class PedidoInsumoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPedidoInsumos")	
	private int idPedidoInsumo;
	@ManyToOne
	@JoinColumn(name="idProveedor")
	private ProveedorEntity proveedor;
	
	private Date fechaPedido;
	private Date fechaEntrega;
	@OneToMany
	@JoinColumn(name="idPedidoInsumos")	
	private ArrayList<ItemPedidoInsumoEntity> itemsPedidoInsumo;

	
	
	
	public int getIdPedidoInsumo() {
		return idPedidoInsumo;
	}

	public void setIdPedidoInsumo(int idPedidoInsumo) {
		this.idPedidoInsumo = idPedidoInsumo;
	}

	public ProveedorEntity getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorEntity proveedor) {
		this.proveedor = proveedor;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public ArrayList<ItemPedidoInsumoEntity> getItemsPedidoInsumo() {
		return itemsPedidoInsumo;
	}

	public void setItemsPedidoInsumo(ArrayList<ItemPedidoInsumoEntity> itemsPedidoInsumo) {
		this.itemsPedidoInsumo = itemsPedidoInsumo;
	}
	
	

}
