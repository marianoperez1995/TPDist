package Exception;

import java.io.Serializable;

public class SucursalException extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3108306025083917383L;
	
	
	public SucursalException(String mensaje){
		super(mensaje);
	}
	
}
