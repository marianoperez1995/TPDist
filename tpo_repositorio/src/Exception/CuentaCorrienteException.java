package Exception;

import java.io.Serializable;

public class CuentaCorrienteException extends Exception implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -7098323949958566401L;

	public CuentaCorrienteException(String mensaje){
		super(mensaje);
	}
	

}