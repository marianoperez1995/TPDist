package Exception;

import java.io.Serializable;

public class ItemProveedorInsumoException extends Exception implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -1068781482196275942L;

	public ItemProveedorInsumoException(String mensaje){
		super(mensaje);
	}
	

}