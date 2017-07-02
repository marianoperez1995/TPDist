package Exception;

import java.io.Serializable;

public class MovimientosException  extends Exception implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = -6980241093069534600L;

	public MovimientosException(String mensaje){
		super(mensaje);
	}
}