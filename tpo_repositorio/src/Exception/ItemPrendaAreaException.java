package Exception;

import java.io.Serializable;

public class ItemPrendaAreaException extends Exception implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 4720685431800676213L;

	public ItemPrendaAreaException(String mensaje){
		super(mensaje);
	}
	

}