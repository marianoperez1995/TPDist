package Exception;

import java.io.Serializable;

public class ItemPrendaInsumoException extends Exception implements Serializable{

	
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -134754885304107215L;

	public ItemPrendaInsumoException(String mensaje){
		super(mensaje);
	}
	

}