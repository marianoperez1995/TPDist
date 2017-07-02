package Exception;

import java.io.Serializable;

public class ReclamoException  extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4258293437543063407L;

	public ReclamoException(String mensaje){
		super(mensaje);
	}
}