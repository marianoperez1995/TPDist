package businessDelegate;

import interfaces.InterfazRemota;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.ClienteDTO;
import dto.CuentaCorrienteDTO;
import dto.EmpleadoDTO;

public class BusinessDelegate {
	private static BusinessDelegate instancia;
	private InterfazRemota objetoRemoto;
	
	private BusinessDelegate() {
		
	}
	public static BusinessDelegate getInstancia(){
		if (instancia==null){
			instancia= new BusinessDelegate();
			instancia.getStub();
		}
		return instancia;
	}
    public void getStub() {
    	  
			try {
				

				objetoRemoto = (InterfazRemota)Naming.lookup ("//localhost/ObjetoRemoto");
				
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //obtiene la refencia del ojeto remoto

    }
    
    public boolean estoyConectado(){
		if(objetoRemoto != null){
			return true;
		}
    	return false;
    }
    
    /*public void altaEmpleado(EmpleadoDTO empleado) throws RemoteException{
    	
    	objetoRemoto.altaEmpleado(empleado);
   
    }*/
    
    public EmpleadoDTO buscarLogin(EmpleadoDTO env) throws RemoteException{
    	
		return objetoRemoto.buscarLogin(env);
    }
    
	public void altaCliente(ClienteDTO cli) throws RemoteException {
		// TODO Auto-generated method stub
		objetoRemoto.altaCliente(cli);
		return;
	}
	
	public ArrayList<ClienteDTO> listadoClientes() throws RemoteException {
		// TODO Auto-generated method stub
		return objetoRemoto.listadoClientes();
	}
	
	public ClienteDTO buscarCliente(ClienteDTO b) throws RemoteException {
		// TODO Auto-generated method stub
		return objetoRemoto.obtenerCliente(b);
	}
	
	public CuentaCorrienteDTO buscarCuenta(CuentaCorrienteDTO cuenta) throws RemoteException {
		// TODO Auto-generated method stu
		return objetoRemoto.buscarCuenta(cuenta);
	}
	public void modificarCliente(ClienteDTO cliente) throws RemoteException {
		objetoRemoto.modificarCliente(cliente);
	}
}
