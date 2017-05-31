package Exception;

import java.io.Serializable;

public class ClienteException extends Exception implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1059463244209717071L;

	public ClienteException(String mensaje){
		super(mensaje);
	}
	

}
