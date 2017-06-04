package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import negocio.Cliente;
import negocio.CuentaCorriente;
import negocio.Empleado;
import negocio.PedidoCliente;
import negocio.Sucursal;
import persistencia.ClienteDAO;
import persistencia.EmpleadoDAO;
import persistencia.SucursalDAO;

public class test1 {

	public static void main(String[] args) {
	//	ClienteDAO.getInstancia().eliminar(2);
		
		
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
					e.getUsuario()+ "       "+
					e.getSucursal().getIdSucursal()+ " "+
					e.getSucursal().getHorarios()+" "+
					e.getSucursal().getNombre()+" "+
					e.getSucursal().getUbicacion());					
		}
		
		//get de empleados
		//Empleado emp = EmpleadoDAO.getInstancia().getEmpleado(1);
		//insert de empleados
		Sucursal suc = new Sucursal();
		suc.setHorarios("1231 2 3");
		suc.setNombre("Su123ursal 1");
		suc.setUbicacion("123Hola");
		SucursalDAO.getInstancia().insert(suc);
		
		Empleado emp2 = new Empleado();
		emp2.setNombre("Aldeeasdsaddro el escamoso");
		emp2.setPermisos(1);
		emp2.setSucursal(SucursalDAO.getInstancia().getSucursal(1)); //verq pasa si metes una sucursal null
		emp2.setPass("123");
		emp2.setTipo("Empleado");
		emp2.setUsuario("jlopez");
		EmpleadoDAO.getInstancia().insert(emp2);*/
		
		
		/*
		Cliente cli = new Cliente();
		Sucursal suc = SucursalDAO.getInstancia().getSucursal(1);
		//cli no tiene pedidos
		CuentaCorriente cta = new CuentaCorriente();
		cta.setEstado("Pendiente");
		cta.setFechaPago("30 del mes");
		cta.setBalanceActual(5000);
		cta.setCondiciones("Condicion de pago buena");
		cta.setLimite(43230);
		cli.setCuentaCorriente(cta);
		cli.setTelefono("4444444");
		cli.setCuit("20293248232");
		cli.setDireccion("Lima 733");
		cli.setEncargado("Juan Perez");
		cli.setTelEncargado("4242412");
		cli.setMailEncargado("asdas@mail.com");
		cli.setGeneroEncargado("Masculino");
		cli.setEstado("Pendiente");
		cli.setNombre("Cliente nuevo");
		cli.setSucursal(suc);
		System.out.println("llega");
		ClienteDAO.getInstancia().insert(cli);*/
		
		/*
		//getAll se Clientes
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clientes = ClienteDAO.getInstancia().getAll();
		for (Cliente e : clientes){
			System.out.println(e.toString());		
		}*/
		
		
		//get de clientes
		/*Cliente pedro = ClienteDAO.getInstancia().getCliente(1);
		System.out.println(pedro.toString());*/
		
	}

}
