package test;

import dto.AreaProduccionDTO;
import dto.BultoDTO;
import dto.ClienteDTO;
import dto.CuentaCorrienteDTO;
import dto.EmpleadoDTO;
import dto.FacturaDTO;
import dto.InsumoDTO;
import dto.ItemListaPrecioDTO;
import dto.ItemPedidoClienteDTO;
import dto.ItemPrendaAreaDTO;
import dto.ItemPrendaInsumoDTO;
import dto.ItemProveedorInsumoDTO;
import dto.LineaProduccionDTO;
import dto.LoteDTO;
import dto.LoteInsumoDTO;
import dto.MovimientosDTO;
import dto.OpcDTO;
import dto.OppDTO;
import dto.PedidoClienteDTO;
import dto.PrendaDTO;
import dto.PrendasEliminadasDTO;
import dto.ProveedorDTO;
import dto.SucursalDTO;
import dto.TransporteDTO;
import dto.UbicacionBultoDTO;
import dto.UbicacionDTO;
import negocio.AreaProduccion;
import negocio.Bulto;
import negocio.Cliente;
import negocio.CuentaCorriente;
import negocio.Empleado;
import negocio.Factura;
import negocio.Insumo;
import negocio.ItemPedidoCliente;
import negocio.ItemPrendaArea;
import negocio.ItemPrendaInsumo;
import negocio.ItemProveedorInsumo;
import negocio.LineaProduccion;
import negocio.LoteInsumo;
import negocio.Movimientos;
import negocio.Opc;
import negocio.Opp;
import negocio.PedidoCliente;
import negocio.Prenda;
import negocio.PrendasEliminadas;
import negocio.Proveedor;
import negocio.Sucursal;
import negocio.Transporte;
import negocio.Ubicacion;
import negocio.UbicacionBulto;

public class testToDTO {
	public static void main(String[] args) {
		ClienteDTO clienteDTO = new ClienteDTO();
		AreaProduccionDTO areaDTO = new AreaProduccionDTO();
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
		UbicacionDTO ubicDTO = new UbicacionDTO();
		
		Cliente cliente = new Cliente();
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
		Ubicacion ubic = new Ubicacion();
		
		
	}
}
