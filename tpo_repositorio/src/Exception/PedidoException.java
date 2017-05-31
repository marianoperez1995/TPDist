package Exception;

import java.io.Serializable;

public class PedidoException extends Exception implements Serializable{
	public PedidoException(String mensaje){
		super(mensaje);
	}
}
