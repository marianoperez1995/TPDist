package Exception;

import java.io.Serializable;

public class OrdenProduccionException  extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9145267408597439066L;

	public OrdenProduccionException(String mensaje){
		super(mensaje);
	}
}