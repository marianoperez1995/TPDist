package test;

import negocio.Factura;
import persistencia.FacturaDAO;

public class testGenerarFacturaPDF {

	public static void main(String[] args) {
		
		//Tiene que haber valores en itemPedidoCliente, cambiar el numero en ambas lineas..
		Factura f = FacturaDAO.getInstancia().getFactura(9);
		f.generarPDF(9);
	}

}
