package Exception;

import java.io.Serializable;

public class UbicacionException  extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3997987619702781561L;

	public UbicacionException(String mensaje){
		super(mensaje);
	}
}