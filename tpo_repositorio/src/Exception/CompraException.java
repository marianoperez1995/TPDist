package Exception;

import java.io.Serializable;

public class CompraException extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8755949094583148811L;
	
	public CompraException(String mensaje){
		super(mensaje);
	}
}


