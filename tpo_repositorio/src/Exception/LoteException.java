package Exception;

import java.io.Serializable;

public class LoteException  extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2361996647090071046L;

	public LoteException(String mensaje){
		super(mensaje);
	}
}