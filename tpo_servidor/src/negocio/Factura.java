package negocio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import dto.FacturaDTO;
import entities.FacturaEntity;
import persistencia.FacturaDAO;

public class Factura {
	private int idFactura;
	private float total;
	private float impuestos;
	private Date fechaGeneracion;
	private Cliente cliente;
	private PedidoCliente pedido;


	public Factura(FacturaDTO factDTO) {
		this.total = factDTO.getTotal();
		this.impuestos = factDTO.getImpuestos();
		this.fechaGeneracion = factDTO.getFechaGeneracion();
		this.cliente = new Cliente(factDTO.getCliente());
		this.idFactura = factDTO.getNumeroFact();
		this.pedido = new PedidoCliente(factDTO.getPedido());
	}
	public Factura(FacturaEntity fact) {
		this.total = fact.getTotal();
		this.impuestos = fact.getImpuestos();
		this.fechaGeneracion = fact.getFechaGeneracion();
		this.cliente = new Cliente(fact.getCliente());
		this.idFactura = fact.getNumeroFact();
		this.pedido = new PedidoCliente(fact.getPedido()); 
	}
	


	public Factura (PedidoCliente pedido){
		this.cliente = pedido.getCliente();
		
		Calendar cal = Calendar.getInstance();
		this.fechaGeneracion = cal.getTime();
		//falta el resto
	}
	
	public Factura() {
		// TODO Auto-generated constructor stub
	}
	public void insertar() {
		FacturaDAO.getInstancia().insert(this);		
	}

	public void borrar() {
		FacturaDAO.getInstancia().eliminar(this.idFactura);
	}

	
	public boolean sosLaFactura(int numero){
		return this.idFactura == numero;
	}
	
	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(float impuestos) {
		this.impuestos = impuestos;
	}

	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public PedidoCliente getPedido() {
		return pedido;
	}

	public void setPedido(PedidoCliente pedido) {
		this.pedido = pedido;
	}
	public int getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", total=" + total + ", impuestos=" + impuestos
				+ ", fechaGeneracion=" + fechaGeneracion + ", cliente=" + cliente + ", pedido=" + pedido + "]";
	}

	public FacturaDTO toDTO(){
		FacturaDTO fac= new FacturaDTO();
		fac.setCliente(cliente.toDTO());
		fac.setFechaGeneracion(fechaGeneracion);
		fac.setImpuestos(impuestos);
		fac.setNumeroFact(this.idFactura);
		fac.setPedido(pedido.toDTO(this));
		fac.setTotal(total);
		return fac;
	}
	
	public void generarPDF(int id) {
		String arch = "C:/TestPDF/Factura N° "+id+".pdf";
		Document doc = new Document();
		try {
			PdfWriter.getInstance(doc, new FileOutputStream (new File(arch)));
			doc.open();
			Font titulo = new Font(Font.FontFamily.TIMES_ROMAN, 25, Font.BOLD);			
			Paragraph p = new Paragraph("Factura N° "+ id, titulo);
	        Image logo = Image.getInstance("src/archivos/afipylogo.png");        

			
			logo.setAlignment(Element.ALIGN_CENTER);
			p.setAlignment(Element.ALIGN_LEFT);
			
			doc.add(logo);
			doc.add(p); 

			Date hoy = Calendar.getInstance().getTime();
			
			doc.add(new Paragraph("Pedido N° " + this.pedido.getIdPedidoCliente()));
			doc.add(new Paragraph("                        "));
			doc.add(new Paragraph("Nombre cliente: " + this.cliente.getNombre()));
			doc.add(new Paragraph("Fecha: " + hoy.toString()));
			doc.add(new Paragraph("Direccion cliente: " + this.cliente.getDireccion()));
			doc.add(new Paragraph("CUIT: " + this.cliente.getCuit()));
			doc.add(new Paragraph("Telefono: " + this.cliente.getTelefono()));
			doc.add(new Paragraph("Sucursal: " + this.cliente.getSucursal().getNombre()));
			
			Paragraph p2 = new Paragraph();
			doc.add(new Paragraph("                        "));
			p2.add("Items del pedido:");
			p2.setAlignment(Element.ALIGN_LEFT);
			doc.add(p2);
			doc.add(new Paragraph("                        "));
			
			PdfPTable tabla = new PdfPTable(4);
			tabla.addCell("Prenda");
			tabla.addCell("Precio Unitario");
			tabla.addCell("Cantidad");
			tabla.addCell("Subtotal");
			doc.add(tabla);
			
			float total = 0;
			for (ItemPedidoCliente item : this.pedido.getItemsPedidoCliente()){
				PdfPTable t = new PdfPTable(4);

				t.addCell(item.getPrenda().getDescripcion());			
				t.addCell(String.valueOf(item.getPrenda().getPrecio()));
				t.addCell(String.valueOf(item.getCantidad()));
				t.addCell(String.valueOf(item.getPrenda().getPrecio()*item.getCantidad()));
				
				total = total + item.getPrenda().getPrecio()*item.getCantidad();
				doc.add(t);
			}	
			//SI ES QUE MANEJABAMOS IBA/DESCUENTOS PONGO ESTO, BORRAR LOS Q NO HAGNA FALTA
			PdfPTable filaSubTotal = new PdfPTable(4);
			filaSubTotal.addCell("");
			filaSubTotal.addCell("");
			filaSubTotal.addCell("SUBTOTAL");			
			filaSubTotal.addCell(String.valueOf(total));
			doc.add(filaSubTotal);
			//////////////////
		/*	PdfPTable filaDesc = new PdfPTable(4);
			filaDesc.addCell("");
			filaDesc.addCell("");
			filaDesc.addCell("DESCUENTO");
			float tasaD = (float) 0.15;
			float descuento = tasaD*total;
			filaDesc.addCell(String.valueOf(descuento));
			doc.add(filaDesc);*/
			//////////////////
			PdfPTable filaIva = new PdfPTable(4);
			filaIva.addCell("");
			filaIva.addCell("");
			filaIva.addCell("IVA ");
			float tasaI = (float) 0.21;
			float iva = tasaI*total;
			filaIva.addCell(String.valueOf(iva));
			doc.add(filaIva);
			//////////////////
			//Total desp de descuentos e iva
			PdfPTable filaTotal = new PdfPTable(4);
			filaTotal.addCell("");
			filaTotal.addCell("");
			filaTotal.addCell("TOTAL");
		//	float totalFinal = total-descuento+iva;
			float totalFinal = total+iva;
			filaTotal.addCell(String.valueOf(totalFinal));
			doc.add(filaTotal);
			doc.close();
			

			
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	

}
