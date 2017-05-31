package Exception;

import java.io.Serializable;

public class ComunicationException extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9200701703443804290L;
	
	public ComunicationException(String mensaje){
		super(mensaje);
	}

}
