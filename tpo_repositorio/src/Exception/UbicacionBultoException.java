package Exception;

import java.io.Serializable;

public class UbicacionBultoException  extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6511798813627998897L;

	public UbicacionBultoException(String mensaje){
		super(mensaje);
	}
}