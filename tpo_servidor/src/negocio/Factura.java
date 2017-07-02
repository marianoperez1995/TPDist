package negocio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import dto.FacturaDTO;
import entities.FacturaEntity;
import persistencia.FacturaDAO;

public class Factura {
	private int idFactura;
	private float total;
	private float subtotal;
	private float impuestos;
	private Date fechaGeneracion;
	private Cliente cliente;
	private PedidoCliente pedido;

	public Factura(FacturaDTO factDTO) {
		this.total = factDTO.getTotal();
		this.subtotal = factDTO.getSubtotal();
		this.impuestos = factDTO.getImpuestos();
		this.fechaGeneracion = factDTO.getFechaGeneracion();
		this.cliente = new Cliente(factDTO.getCliente());
		this.idFactura = factDTO.getNumeroFact();
		this.pedido = new PedidoCliente(factDTO.getPedido());
	}

	public Factura(FacturaEntity fact) {
		this.total = fact.getTotal();
		this.impuestos = fact.getImpuestos();
		this.subtotal = fact.getSubtotal();
		this.fechaGeneracion = fact.getFechaGeneracion();
		this.cliente = new Cliente(fact.getCliente());
		this.idFactura = fact.getNumeroFact();
		this.pedido = new PedidoCliente(fact.getPedido());
	}

	public Factura(PedidoCliente pedido) {
		this.cliente = pedido.getCliente();

		Calendar cal = Calendar.getInstance();
		this.fechaGeneracion = cal.getTime();
		// falta el resto
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

	public boolean sosLaFactura(int numero) {
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

	public FacturaDTO toDTO() {
		FacturaDTO fac = new FacturaDTO();
		fac.setCliente(cliente.toDTO());
		fac.setFechaGeneracion(fechaGeneracion);
		fac.setImpuestos(impuestos);
		fac.setNumeroFact(this.idFactura);
		fac.setPedido(pedido.toDTO(this));
		fac.setTotal(total);
		return fac;
	}

	public void generarPDF(int id) {
		String arch = "Factura NÂ° " + id + ".pdf";
		Document doc = new Document();
		try {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm");
			
			PdfWriter.getInstance(doc, new FileOutputStream(new File(arch)));
			doc.open();
			Font titulo = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);
			Font titulo2 = new Font(Font.FontFamily.HELVETICA, 17, Font.BOLD);
			Paragraph p = new Paragraph("FACTURA NÂ° 0001-0000" + id, titulo);
			p.setAlignment(Element.ALIGN_RIGHT);
			Image logo = Image.getInstance("src/archivos/afipylogo.png");
			
			logo.setAlignment(Element.ALIGN_CENTER);
			logo.scaleToFit(550f, 550f);
			Date hoy = Calendar.getInstance().getTime();
			Paragraph p3 = new Paragraph("Fecha: " + df.format(hoy));
			doc.add(logo);
			doc.add(p);
			p3.setAlignment(Element.ALIGN_RIGHT);
			doc.add(p3);
			
			doc.add(new Paragraph("Datos del cliente", titulo2));
			doc.add(new Paragraph("Nombre cliente: " + this.cliente.getNombre()));
			doc.add(new Paragraph("Direccion cliente: " + this.cliente.getDireccion()));
			doc.add(new Paragraph("CUIT: " + this.cliente.getCuit()));
			doc.add(new Paragraph("Telefono: " + this.cliente.getTelefono()));
			doc.add(new Paragraph("Sucursal: " + this.cliente.getSucursal().getNombre()));
			doc.add(new Paragraph("                        "));
			Paragraph p2 = new Paragraph();
			doc.add(new Paragraph("Detalle de la compra", titulo2));
			doc.add(new Paragraph("DescripciÃ³n: Pedido NÂ° " + this.pedido.getIdPedidoCliente()));

			p2.add("Items del pedido:");
			p2.setAlignment(Element.ALIGN_LEFT);
			doc.add(p2);
			doc.add(new Paragraph("                        "));

			PdfPTable tabla = new PdfPTable(6);
			tabla.setWidthPercentage(100);
			tabla.addCell("Prenda");
			tabla.addCell("Color");
			tabla.addCell("Talle");
			tabla.addCell("Precio Unitario");
			tabla.addCell("Cantidad");
			tabla.addCell("Subtotal");
			doc.add(tabla);

			float total = 0;
			for (ItemPedidoCliente item : this.pedido.getItemsPedidoCliente()) {
				PdfPTable t = new PdfPTable(6);
				t.setWidthPercentage(100);
				t.addCell(item.getPrenda().getDescripcion());
				t.addCell(item.getPrenda().getColor());
				t.addCell(item.getPrenda().getTalle());
				t.addCell(String.valueOf(item.getPrenda().getPrecio()));
				t.addCell(String.valueOf(item.getCantidad()));
				t.addCell(String.valueOf(item.getPrenda().getPrecio() * item.getCantidad()));

				total = total + item.getPrenda().getPrecio() * item.getCantidad();
				doc.add(t);
			}
			// SI ES QUE MANEJABAMOS IBA/DESCUENTOS PONGO ESTO, BORRAR LOS Q NO
			// HAGNA FALTA
			PdfPCell cell = new PdfPCell(new Phrase(""));
			cell.setBackgroundColor(BaseColor.GRAY);
			
			PdfPTable filaSubTotal = new PdfPTable(4);
			filaSubTotal.setWidthPercentage(100);
			filaSubTotal.addCell(cell);
			filaSubTotal.addCell(cell);
			filaSubTotal.addCell("SUBTOTAL");
			filaSubTotal.addCell(String.valueOf(total));
			doc.add(filaSubTotal);
			//////////////////
			/*
			 * PdfPTable filaDesc = new PdfPTable(4); filaDesc.addCell("");
			 * filaDesc.addCell(""); filaDesc.addCell("DESCUENTO"); float tasaD
			 * = (float) 0.15; float descuento = tasaD*total;
			 * filaDesc.addCell(String.valueOf(descuento)); doc.add(filaDesc);
			 */
			//////////////////
			PdfPTable filaIva = new PdfPTable(4);
			filaIva.setWidthPercentage(100);
			filaIva.addCell(cell);
			filaIva.addCell(cell);
			filaIva.addCell("IVA (21%)");
			float tasaI = (float) 0.21;
			float iva = tasaI * total;
			filaIva.addCell(String.valueOf(iva));
			doc.add(filaIva);
			//////////////////
			// Total desp de descuentos e iva
			PdfPTable filaTotal = new PdfPTable(4);
			filaTotal.setWidthPercentage(100);
			filaTotal.addCell(cell);
			filaTotal.addCell(cell);
			filaTotal.addCell("TOTAL");
			// float totalFinal = total-descuento+iva;
			float totalFinal = total + iva;
			filaTotal.addCell(String.valueOf(totalFinal));
			doc.add(filaTotal);
			Image fin = Image.getInstance("src/archivos/fondo.png");
			fin.setAlignment(Element.ALIGN_CENTER);
			fin.scaleToFit(550f, 550f);
			doc.add(fin);
			doc.close();

		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setSubtotal(float subtotal) {
		this.subtotal=subtotal;
	}

	public float getSubtotal() {
		return subtotal;
	}
	

}
