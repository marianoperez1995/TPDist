package Exception;

import java.io.Serializable;

public class PrendaException extends Exception implements Serializable{ /**
	 * 
	 */
	private static final long serialVersionUID = -1866549649791963832L;

	

	public PrendaException(String mensaje){
		super(mensaje);
	}
}
