package Exception;

import java.io.Serializable;

public class InsumoException extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7974078580407037343L;

	public InsumoException(String mensaje){
		super(mensaje);
	}
	

}