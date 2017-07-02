package Exception;

import java.io.Serializable;

public class EmpleadoException extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2815175543632587374L;

	public EmpleadoException(String mensaje){
		super(mensaje);
	}
	

}