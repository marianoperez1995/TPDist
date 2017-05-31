package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
@DiscriminatorValue("opp")
public class OppEntity extends  OrdenProduccionEntity implements Serializable {
	
	
	public OppEntity(int codigo, Date fecha) {
		super(codigo, fecha);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3048318319295566237L;
	


	

}
