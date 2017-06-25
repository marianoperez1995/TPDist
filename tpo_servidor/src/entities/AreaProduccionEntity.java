package entities;

import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AreasProduccion")
public class AreaProduccionEntity implements Serializable {// ya esta bien

	/**
	 * 
	 */
	public AreaProduccionEntity() {
		
	}
	
	private static final long serialVersionUID = -6316137714510017688L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAreaProduccion")
	private int idAreaP;
	private List<LineaProduccionEntity> lineas;
	private String nombre;
/*
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinTable(name = "Area_lineasProduccion", joinColumns = {
			@JoinColumn(name = "idAreaProduccion") }, inverseJoinColumns = { @JoinColumn(name = "idLineaProduccion") })
	private List<LineaProduccionEntity> lineas;

	@OneToMany
	@JoinColumn(name="idAreaProduccion")	
	private List<ItemPrendaAreaEntity> prendas;*/

	
	public int getIdAreaP() {
		return idAreaP;
	}

	public void setIdAreaP(int idAreaP) {
		this.idAreaP = idAreaP;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




}
