
package servidor;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

import objetoRemoto.ObjetoRemoto;

public class Servidor {

	public static void main(String[] args) {
		new Servidor();
	}

	public Servidor() {
		iniciar(); // Arranco el servidor
	}

	public void iniciar() {
		try {
			LocateRegistry.createRegistry(1099); // usamos el puerto 1099
			ObjetoRemoto remoto = new ObjetoRemoto(); // creo una intancia de un
														// objeto remoto
			Naming.rebind("//localhost/ObjetoRemoto", (Remote) remoto); // la
																		// direccion
																		// de
																		// local
																		// host
																		// puede
																		// ser
																		// un ip
			System.out.println("Fijado en //localhost/ObjetoRemoto");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
