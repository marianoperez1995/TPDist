package Exception;

import java.io.Serializable;

public class ItemPedidoClienteException extends Exception implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4604287542471220877L;

	public ItemPedidoClienteException(String mensaje){
		super(mensaje);
	}
	

}