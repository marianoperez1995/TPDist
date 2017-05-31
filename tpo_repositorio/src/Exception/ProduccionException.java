package Exception;

import java.io.Serializable;

public class ProduccionException extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -246355992528399604L;
	
	public ProduccionException(String mensaje){
		super(mensaje);
	}
	

}
