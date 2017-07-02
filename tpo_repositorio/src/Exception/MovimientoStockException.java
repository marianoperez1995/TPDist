package Exception;

import java.io.Serializable;

public class MovimientoStockException  extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6732828581542227685L;

	public MovimientoStockException(String mensaje){
		super(mensaje);
	}
}