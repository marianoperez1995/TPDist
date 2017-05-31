package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="Insumos")
public class InsumoEntity implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3454179299445920384L;
	public InsumoEntity(int codigo, String nombre, float stockActual, float precioFinal, float stockMinimo,
			String unidad, float cantAComprar, Date fechaRecepcion, List<LoteEntity> lotes) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.stockActual = stockActual;
		this.precioFinal = precioFinal;
		this.stockMinimo = stockMinimo;
		this.unidad = unidad;
		this.cantAComprar = cantAComprar;
		this.fechaRecepcion = fechaRecepcion;
		this.lotes = lotes;
	}
	public InsumoEntity(){
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idInsumo")
	private int codigo;
	private String nombre;
	@Column(name="stock")
	private float stockActual;
	@Column(name="precio")
	private float precioFinal;
	@Column(name="stockMin")
	private float stockMinimo;
	private String unidad;
	private float cantAComprar;

	//Faltaba en esta clase la fechaRecepcion
	
	private Date fechaRecepcion;	
	/*
	//falta manejar el precio de proveedor_insumos
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinTable(name = "Proveedor_Insumos", joinColumns = {
	@JoinColumn(name = "idinsumo") }, inverseJoinColumns = { @JoinColumn(name = "idproveedor") })
	private List<ProveedorEntity> proveedores;	
	
	//falta manejar la cantidad y desperdicio de prenda_insumos
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinTable(name = "prenda_insumos", joinColumns = {
	@JoinColumn(name = "idInsumo") }, inverseJoinColumns = { @JoinColumn(name = "idPrenda") })
	private List<PrendaEntity> prendas;
	*/
	//REVISAR QUE ESTE MANEJANDO BIEN EL DESPERDICIO/CANTIDAD SIN GUARDAR LOS ITEMS ACA
	//osea, con entities aparte, que son los Item....
	
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinTable(name = "Lote_Insumo", joinColumns = {
	@JoinColumn(name = "idInsumo") }, inverseJoinColumns = { @JoinColumn(name = "idLote") })
	private List<LoteEntity> lotes;


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public float getStockActual() {
		return stockActual;
	}


	public void setStockActual(float stockActual) {
		this.stockActual = stockActual;
	}


	public float getPrecioFinal() {
		return precioFinal;
	}


	public void setPrecioFinal(float precioFinal) {
		this.precioFinal = precioFinal;
	}


	public float getStockMinimo() {
		return stockMinimo;
	}


	public void setStockMinimo(float stockMinimo) {
		this.stockMinimo = stockMinimo;
	}


	public String getUnidad() {
		return unidad;
	}


	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}


	public float getCantAComprar() {
		return cantAComprar;
	}


	public void setCantAComprar(float cantAComprar) {
		this.cantAComprar = cantAComprar;
	}


	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}


	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public List<LoteEntity> getLotes() {
		return lotes;
	}


	public void setLotes(List<LoteEntity> lotes) {
		this.lotes = lotes;
	}
	

}
