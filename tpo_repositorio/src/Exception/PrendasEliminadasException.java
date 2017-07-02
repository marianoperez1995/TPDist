package Exception;

import java.io.Serializable;

public class PrendasEliminadasException  extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4938444282234737315L;

	public PrendasEliminadasException(String mensaje){
		super(mensaje);
	}
}