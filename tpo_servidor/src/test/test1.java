package test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import negocio.Insumo;
import negocio.Lote;
import negocio.Prenda;

public class test1 {

	public static void main(String[] args) {
		//Prenda pre =PrendaDAO.getInstancia().getPrenda(5);
		Prenda p = new Prenda();
		p.setCantidadAConfeccionar(4);
		p.setColor("Rojo");
		p.setCostoProduccionActual(44);
		p.setCostoProduccionReal(23);
		p.setDescripcion("descrr");
		p.setEstadoProduccion(false);
		ArrayList<Insumo> insumos = new ArrayList<>();
		Insumo ins = new Insumo();
		ins.setCantAComprar(4);
		Date d = Calendar.getInstance().getTime();
		ins.setFechaRecepcion(d);
		ins.setPrecioFinal(424);
		ArrayList<Lote> lotes = new ArrayList<>();
		Lote l = new Lote();
		l.setBultos(bultos);
		ins.setLotes(null);
		insumos.add(new Insumo());
		p.setInsumos(null);
			//System.out.println(pre.toString());
	
	
	}

}
