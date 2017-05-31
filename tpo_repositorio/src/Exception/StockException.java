package Exception;

import java.io.Serializable;

public class StockException extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5365611933387962236L;
	
	public StockException(String mensaje){
		super(mensaje);
	}
	

}
