package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
	//@Transient
	//private List<LineaProduccionEntity> lineas;
	private String nombre;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany
	@JoinColumn(name="idAreaProduccion")
	private List<LineaProduccionEntity> lineas;

	@OneToMany
	@JoinColumn(name="idAreaProduccion")	
	private List<ItemPrendaAreaEntity> prendas;

	
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


	public void setLineas(List<LineaProduccionEntity> lineas) {
		this.lineas = lineas;
	}

	public List<LineaProduccionEntity>getLineas() {
		// TODO Auto-generated method stub
		return lineas;
	}




}
