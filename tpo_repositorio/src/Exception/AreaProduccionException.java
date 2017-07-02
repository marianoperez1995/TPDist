package Exception;

import java.io.Serializable;

public class AreaProduccionException extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8958325951598483894L;

	public AreaProduccionException(String mensaje){
		super(mensaje);
	}
	

}