package test;

import java.util.ArrayList;

import negocio.Empleado;
import negocio.Sucursal;
import persistencia.EmpleadoDAO;
import persistencia.SucursalDAO;

public class test1 {

	public static void main(String[] args) {
	/*
		//getall de Empleados
		ArrayList<Empleado> empleados = new ArrayList<>();
		empleados = EmpleadoDAO.getInstancia().getAll();
		for (Empleado e : empleados){
			System.out.println(e.getIdEmpleado()+ " "+
					e.getNombre()+ " "+
					e.getPass()+ " "+
					e.getPermisos()+ " "+
					e.getTipo()+ " "+
					e.getUsuario()+ "       "
							);
		}*/
		
		//get de empleados
		Empleado e = EmpleadoDAO.getInstancia().getEmpleado(1);
		
		System.out.println(e.getIdEmpleado()+ " "+
				e.getNombre()+ " "+
				e.getPass()+ " "+
				e.getPermisos()+ " "+
				e.getTipo()+ " "+
				e.getUsuario()+ "    "
							);
		//insert de empleados
		/*Sucursal suc = new Sucursal();
		suc.setHorarios("1231 2 3");
		suc.setNombre("Su123ursal 1");
		suc.setUbicacion("123Hola");
		SucursalDAO.getInstancia().insert(suc);
		
		Empleado emp2 = new Empleado();
		emp2.setNombre("Aldeeasdsaddro el escamoso");
		emp2.setPermisos(1);
		emp2.setPass("123");
		emp2.setTipo("Empleado");
		emp2.setUsuario("jlopez");
		EmpleadoDAO.getInstancia().insert(emp2);*/
	}

}
