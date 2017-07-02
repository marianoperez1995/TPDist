package Exception;

import java.io.Serializable;

public class LoteInsumoException  extends Exception implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -7888190122498345171L;

	public LoteInsumoException(String mensaje){
		super(mensaje);
	}
}