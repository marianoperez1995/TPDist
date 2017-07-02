package Exception;

import java.io.Serializable;

public class ItemPedidoInsumoException extends Exception implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = -4753439402538243913L;

	public ItemPedidoInsumoException(String mensaje){
		super(mensaje);
	}
	

}