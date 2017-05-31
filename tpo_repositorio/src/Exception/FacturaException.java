package Exception;

import java.io.Serializable;

public class FacturaException extends Exception implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6115117044853390753L;

	public FacturaException(String mensaje){
		super(mensaje);
	}
	

}
