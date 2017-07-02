package Exception;

import java.io.Serializable;

public class PedidoException extends Exception implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7931764663581285130L;

	public PedidoException(String mensaje){
		super(mensaje);
	}
}
