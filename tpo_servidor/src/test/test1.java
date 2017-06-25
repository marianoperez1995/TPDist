package test;

import java.rmi.RemoteException;

import businessDelegate.BusinessDelegate;
import dto.EmpleadoDTO;

public class test1 {

	public static void main(String[] args) {
		EmpleadoDTO emp= new EmpleadoDTO();
		emp.setUsuario("usuario1");
		emp.setPass("123456");
		try {
			System.out.println(BusinessDelegate.getInstancia().buscarLogin(emp));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
