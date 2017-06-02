package test;

import java.util.ArrayList;
import java.util.Calendar;

import dto.PrendaDTO;
import negocio.Opp;
import negocio.Prenda;
import persistencia.ColorDAO;
import persistencia.TalleDAO;

public class testToDTO {
	public static void main(String[] args) {

		
		
		
		
		
		
		
		
		/*
		PrendaDTO prendaDTO = new PrendaDTO();
		Prenda p = new Prenda();
		p.setIdPrenda(3);
		p.setCantidadAConfeccionar(4);
		p.setColor("Negro");
		p.setCostoProduccionActual(123);
		p.setDescripcion("Pantalon");
		p.setEstadoProduccion(true);		
		p.setPorcentajeGanancia(2);
		p.setPrecio(50);
		p.setTalle("M");
		p.setStockActual(588);
		p.setStockMinimo(10);
		p.insertar();*/
/*
		ColorDAO.getInstancia().insert("Rojo");
		ColorDAO.getInstancia().insert("Azul");
		ColorDAO.getInstancia().insert("Celeste");
		ColorDAO.getInstancia().insert("Negro");
		ColorDAO.getInstancia().insert("Blanco");
		
		TalleDAO.getInstancia().insert("S");
		TalleDAO.getInstancia().insert("M");
		TalleDAO.getInstancia().insert("L");		
		TalleDAO.getInstancia().insert("XL");
		TalleDAO.getInstancia().insert("XXL");*/
		
		
		
		/*	
		Cliente cliente = new Cliente();
		CuentaCorriente cta = new CuentaCorriente();
		ArrayList<PedidoCliente> pedidos = new ArrayList<>();
		Sucursal sucu = new Sucursal();*/

		/*cliente.setCuentaCorriente(CuentaCorrienteDAO.getInstancia().getCuentaCorriente(2));
		cliente.setCuit("cuit");
		cliente.setDireccion("DIRECCION");
		cliente.setEncargado("ENC");
		cliente.setEstado("ESTA");
		cliente.setGeneroEncargado("M");
		cliente.setIdCliente(2);
		cliente.setMailEncargado("ASDASD");
		cliente.setNombre("NOMB");
		cliente.setPedidosCliente(pedidos);	
		cliente.setSucursal(SucursalDAO.getInstancia().getSucursal(1));
		cliente.setTelefono("cuit");
		cliente.setTelEncargado("cuit");
		cliente.insertar();*/
	/*	ClienteDTO clienteDTO = ClienteDAO.getInstancia().getCliente(2).toDTO();	
		System.out.println(clienteDTO.toString());*/
		
		
	/*	AreaProduccionDTO areaDTO = new AreaProduccionDTO();
		BultoDTO bultoDTO = new BultoDTO();
		CuentaCorrienteDTO cuentaDTO = new CuentaCorrienteDTO();
		EmpleadoDTO empDTO = new EmpleadoDTO();
		FacturaDTO factDTO = new FacturaDTO();
		InsumoDTO insDTO = new InsumoDTO();
		ItemPedidoClienteDTO itempcDTO = new ItemPedidoClienteDTO();
		ItemPrendaAreaDTO itempaDTO = new ItemPrendaAreaDTO();
		ItemPrendaInsumoDTO itempiDTO = new ItemPrendaInsumoDTO();
		ItemProveedorInsumoDTO itempriDTO = new ItemProveedorInsumoDTO();
		LineaProduccionDTO lineaDTO = new LineaProduccionDTO();
		LoteDTO loteDTO = new LoteDTO();
		LoteInsumoDTO loteiDTO = new LoteInsumoDTO();
		MovimientosDTO movDTO = new MovimientosDTO();
	//	MovimientoStockDTO movStockDTO(); esta clase creo q esta de mas
		OpcDTO opcDTO = new OpcDTO();
		OppDTO oppDTO = new OppDTO();
		PedidoClienteDTO pedDTO= new PedidoClienteDTO();
		PrendaDTO prendaDTO = new PrendaDTO();
		PrendasEliminadasDTO pelimDTO = new PrendasEliminadasDTO();
		ProveedorDTO provDTO = new ProveedorDTO();
		SucursalDTO sucuDTO = new SucursalDTO();
		TransporteDTO tranDTO = new TransporteDTO();
		UbicacionBultoDTO ubicbDTO = new UbicacionBultoDTO();
		UbicacionDTO ubicDTO = new UbicacionDTO();*/
		
	/*	Cliente cliente = new Cliente();
		AreaProduccion area = new AreaProduccion();
		Bulto bulto = new Bulto();
		CuentaCorriente cuenta = new CuentaCorriente();
		Empleado emp = new Empleado();
		Factura fact = new Factura();
		Insumo ins = new Insumo();
		ItemPedidoCliente itempc = new ItemPedidoCliente();
		ItemPrendaArea itempa = new ItemPrendaArea();
		ItemPrendaInsumo itempi = new ItemPrendaInsumo();
		ItemProveedorInsumo itempri = new ItemProveedorInsumo();
		LineaProduccion linea = new LineaProduccion();
		LoteDTO lote = new Lote();
		LoteInsumo lotei = new LoteInsumo();
		Movimientos movD= new Movimientos();
	//	MovimientoStockDTO movStockDTO(); esta clase creo q esta de mas
		Opc opc = new Opc();
		Opp opp = new Opp();
		PedidoCliente ped= new PedidoCliente();
		Prenda prenda = new Prenda();
		PrendasEliminadas pelim = new PrendasEliminadas();
		Proveedor prov = new Proveedor();
		Sucursal sucu = new Sucursal();
		Transporte tran = new Transporte();
		UbicacionBulto ubicb = new UbicacionBulto();
		Ubicacion ubic = new Ubicacion();*/
		
		
	}
}
