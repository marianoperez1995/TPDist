package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
@DiscriminatorValue("opc")
public class OpcEntity extends  OrdenProduccionEntity  implements Serializable {

	public OpcEntity(int codigo, Date fecha) {
		super(codigo, fecha);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2274901070606007955L;



}
