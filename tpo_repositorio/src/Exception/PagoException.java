package Exception;

import java.io.Serializable;

public class PagoException  extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3626683850215572257L;

	public PagoException(String mensaje){
		super(mensaje);
	}
}