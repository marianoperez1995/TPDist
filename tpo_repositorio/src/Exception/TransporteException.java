package Exception;

import java.io.Serializable;

public class TransporteException  extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1417027377483481571L;

	public TransporteException(String mensaje){
		super(mensaje);
	}
}