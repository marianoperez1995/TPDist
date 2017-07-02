package Exception;

import java.io.Serializable;

public class ItemOrdenProduccionException extends Exception implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2301413637101934117L;

	public ItemOrdenProduccionException(String mensaje){
		super(mensaje);
	}
	

}