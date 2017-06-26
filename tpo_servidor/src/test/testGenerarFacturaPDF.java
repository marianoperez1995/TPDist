package test;

import negocio.Factura;
import persistencia.FacturaDAO;

public class testGenerarFacturaPDF {

	public static void main(String[] args) {
		
		//Tiene que haber valores en itemPedidoCliente
		Factura f = FacturaDAO.getInstancia().getFactura(2);
		f.generarPDF();
	}

}
