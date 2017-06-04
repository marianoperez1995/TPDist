package test;

import java.util.ArrayList;

import negocio.AreaProduccion;
import negocio.LineaProduccion;
import persistencia.LineaProduccionDAO;

public class testAreasLineas {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		AreaProduccion area = new AreaProduccion();
		LineaProduccion linea = new LineaProduccion();
	/*	
		linea.setCapacidad(54);
		linea.setEstado(true);
		linea.setHoraInicio(Calendar.getInstance().getTime());
		Date d = new Date();
		d.setMinutes(323);
		linea.setTiempoDeUso(d);
		linea.insertar();*/
		
		ArrayList<LineaProduccion> lineas = new ArrayList<>();
		lineas.add(LineaProduccionDAO.getInstancia().getLineaProduccion(2));
		lineas.add(LineaProduccionDAO.getInstancia().getLineaProduccion(3));
		area.setNombre("Area de tejidos");
		area.setLineasProduccion(lineas);
		area.insertar();
		
		
		
	}
}
