package Exception;

import java.io.Serializable;

public class BultoException extends Exception implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = -6338705129492475051L;

	public BultoException(String mensaje){
		super(mensaje);
	}
	

}