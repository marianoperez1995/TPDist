package test;

public class testToDTO {
	public static void main(String[] args) {
		
	/*	ItemProveedorInsumo i = new ItemProveedorInsumo();
		//Proveedor prov = new Proveedor();
		Insumo ins = new Insumo();
		//prov.setCuit("12345");
		//prov.setNombre("Tela SA");
		//prov.insertar();
		ItemPedidoCliente it = new ItemPedidoCliente();
		it.setCantidad(45);
		it.setPrecio(54);
		it.setPrenda(PrendaDAO.getInstancia().getPrenda(2,3,1));
		it.insertar(5);*/
		
		/*Cliente cli = ClienteDAO.getInstancia().getCliente(2);
		cli.borrarPedido(5);
		PedidoClienteDAO.getInstancia().eliminar(5);
		PedidoClienteDAO.getInstancia().eliminar(6);
	

		PedidoClienteDAO.getInstancia().eliminar(7);*/
		//Opp orden = new Opp();
	
		
	//	orden.setFecha(Calendar.getInstance().getTime());
	//	orden.setPedidoCliente(ped);
	
	/*	ins.setCantAComprar(45);
		ins.setNombre("Carton");
		ins.setPrecioFinal(55);
		ins.setStockActual(123);
		ins.setUnidad("Cajas");
		ins.setStockMinimo(40);
		ins.setFechaRecepcion(Calendar.getInstance().getTime());	
		/*ArrayList <Lote> lotes = new ArrayList<>();
		Lote l = new Lote();
		l.setCantidadTotal(10);
		l.setColor("Rojo");
		l.setBultos(bultos);
		Bulto bulto = new Bulto();
		bulto.setCantidad(3);;
		bulto.setPrenda(PrendaDAO.getInstancia().getPrenda(1));
		l.setOrden(orden);
		l.setTalle("M");
		lotes.add(l);
		l.insertar();
		ins.setLotes(lotes);
		ins.insertar();*/
		//FALTA INSERTAR UN LOTE, UNA ORDEN, BULTOS, ETC... PARA PODER PROBAR Insumo...
		
		
		
		
		
		
		
		//PrendaDTO prendaDTO = new PrendaDTO();
	/*	Prenda p = new Prenda();
		p.setIdPrenda(2);
		p.setCantidadAConfeccionar(55);
		p.setColor("Celeste");
		p.setCostoProduccionActual(2123);
		p.setDescripcion("Pantalon");
		p.setEstadoProduccion(true);		
		p.setPorcentajeGanancia(244);
		p.setPrecio(504);
		p.setTalle("S");
		p.setStockActual(133);
		p.setStockMinimo(11);
		p.insertar();*/

		/*ColorDAO.getInstancia().insert("Rojo");
		ColorDAO.getInstancia().insert("Azul");
		ColorDAO.getInstancia().insert("Celeste");
		ColorDAO.getInstancia().insert("Negro");
		ColorDAO.getInstancia().insert("Blanco");
		
		TalleDAO.getInstancia().insert("S");
		TalleDAO.getInstancia().insert("M");
		TalleDAO.getInstancia().insert("L");		
		TalleDAO.getInstancia().insert("XL");
		TalleDAO.getInstancia().insert("XXL");
		
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
