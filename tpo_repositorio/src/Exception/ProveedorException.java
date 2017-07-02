package Exception;

import java.io.Serializable;

public class ProveedorException  extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -819067236539957657L;

	public ProveedorException(String mensaje){
		super(mensaje);
	}
}