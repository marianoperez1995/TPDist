package Exception;

import java.io.Serializable;

public class PedidoClienteException  extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 567624912435668440L;

	public PedidoClienteException(String mensaje){
		super(mensaje);
	}
}