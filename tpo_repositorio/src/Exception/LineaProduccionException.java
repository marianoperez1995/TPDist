package Exception;

import java.io.Serializable;

public class LineaProduccionException extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3322122637260609723L;

	public LineaProduccionException(String mensaje){
		super(mensaje);
	}
}