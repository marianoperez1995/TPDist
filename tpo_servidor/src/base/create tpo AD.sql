create table Prendas (
	idPrenda int not null identity(1,1),
	color varchar(100) not null,
	talle varchar(100) not null,
	descripcion varchar(100) not null,
	estadoProduccion bit not null,
	costoProduccion float not null,
	costoProduccionActual float not null,
	porcentajeGanancia float not null,
	precio float not null,
	cantidadAConfeccionar int not null,
	stockMinimo int not null,
	stockActual int not null
	constraint pk_Prendas primary key (idPrenda)
)

create table Sucursales (
	idSucursal int not null identity(1,1),
	nombre varchar(50) not null,
	direccion varchar(80) not null,
	horarios varchar(50)not null,


	constraint pk_Sucursal primary key (idSucursal)
)

create table Empleados (
	idempleado int not null identity(1,1),
	nombre varchar(50) not null,
	tipo varchar(50) not null,
	usuario varchar(50) not null,
	pass varchar(50) not null,
	permisos int not null,
	idSucursal int not null,

	constraint pk_Trabajadores primary key (idEmpleado)
)

create table AreasProduccion (
	idAreaProduccion int not null identity(1,1),
	nombre varchar(50) not null,
	
	constraint pk_Areas primary key (idAreaProduccion)
)

create table LineasProduccion (
	idLineaProduccion int not null identity(1,1),
	idAreaProduccion int not null,
	estado bit not null,
	capacidad int not null,
	horaInicio datetime null, 
	tiempoUso float null,

	constraint pk_LineasProd primary key (idLineaProduccion),
		constraint area_fk_lineap foreign key (idAreaProduccion) references AreasProduccion,
)


create table Lotes (
	idLote int not null identity(1,1),
	idPrenda int not null,
	cantidad int not null,
	idOrden int null,

	constraint pk_lote primary key (idLote)
)

create table Insumos (
	idInsumo int not null identity (1,1),
	nombre varchar(50) not null,
	stock float not null,
	fechaRecepcion DateTime not null,
	precio float not null,
	stockMin float not null,
	unidad varchar(50) not null,
	cantAComprar float not null,

	constraint pk_Insumos primary key (idInsumo)
)

create table Proveedores(
	idproveedor int not null identity(1,1),
	nombre varchar(50) not null,
	cuit varchar(30) not null

	constraint pk_proveedor primary key (idProveedor)
	)

create table Proveedor_Insumos(
	idproveedor int not null,
	idinsumo int not null,
	precio float not null,

	constraint pk_proveedor_insumo primary key (idProveedor, idinsumo),
	constraint fk_proveedor_ins foreign key	(idProveedor) references Proveedores,
	constraint fk_proveedor_ins1 foreign key (idinsumo) references Insumos
)

create table LotesInsumo (
	idLoteInsumo int not null identity(1,1),
	cantidad float not null,
	fechaRecepcion DateTime not null,
	idInsumo int not null,
	idProveedor int not null,

	constraint pk_Lotes primary key (idLoteInsumo),
	constraint fk_LotesIns_proveedor foreign key (idProveedor) references Proveedores,
	constraint fk_LotesIns_insumo foreign key (idInsumo) references insumos
)

create table Prenda_Areas (
	idPrenda int not null,
	idAreaProduccion int not null,
	minutoEnArea int not null,

	constraint pk_prenda_areas primary key (idPrenda, idAreaProduccion),
	constraint prenda_fk_area foreign key (idPrenda) references Prendas,
	constraint prenda_fk_area1 foreign key (idAreaProduccion) references AreasProduccion
)




create table prenda_insumos (
	idPrenda int not null,
	idInsumo int not null,
	cantidad float not null,
	desperdicio float not null,

	constraint pk_Pren_Ins primary key (idPrenda, idInsumo),
	constraint prenda_fk_insumo foreign key (idPrenda) references Prendas,
	constraint prenda_fk_insumo1 foreign key (idInsumo) references Insumos
)

create table CuentasCorriente(
	idCuentaCorriente int not null identity(1,1),
	limite float not null,
	condicionesPago varchar(50) not null,
	fecha varchar(50) not null,
	estado varchar(50) not null,
	balanceActual float not null,

	constraint pk_CuentaCorriente primary key (idCuentaCorriente)
)

create table Clientes (
	idCliente int not null identity(1,1),
	fechaRegistro Datetime not null,
	nombre varchar(60) not null,
	cuit varchar(30) not null,
	telefono varchar(30) not null,
	direccion varchar(40) not null,
	idSucursal int not null,
	idCCorriente int,
	estado varchar(40) not null,
	encargado varchar(40) not null,
	telencargado varchar(40) not null,
	mailencargado varchar(40) not null,
	generoencargado varchar(40) not null,
	usuario varchar(50) null, 
	pass varchar(50) null,
	
	constraint pk_Cliente primary key (idCliente),
	constraint cliente_fk_cuentacor foreign key (idCCorriente) references CuentasCorriente,
	constraint cliente_fk_sucursal foreign key (idSucursal) references Sucursales
)


create table Pagos (
	idPago int not null identity (1,1),
	monto float,
	montoAnterior float,
	idCliente int not null,
	fechaPago datetime not null,
	
	constraint pk_Pago primary key (idPago),
	constraint pago_fk_cliente foreign key (idCliente) references Clientes
)
	
create table PedidosCliente (
	idPedidoCliente int not null identity(1,1),
	idCliente int not null,
	estado varchar(20) not null, --puede ser pendiente, aceptado, enviado
	fechaGeneracion DateTime not null,
	fechaEstimadaDespacho DateTime null,
	fechaRealDespacho DateTime  null,
	fechaEntregaCliente DateTime  null,
	precioTotal float not null,


	constraint pk_Pedido primary key (idPedidoCliente),
	constraint pedido_fk_cliente foreign key (idCliente) references Clientes
)

create table PedidoInsumos (
	idPedidoInsumos int not null identity(1,1),
	idProveedor int not null,
	fechaPedido DateTime not null,
	fechaEntrega DateTime not null

	constraint pk_Pedido2 primary key (idPedidoInsumos),
	constraint pedidoins_fk_proveedor foreign key (idProveedor) references Proveedores
)



create table ItemPedidoCliente (
	idPedidoCliente int not null,
	idPrenda int not null,
	cantidad int not null,
	subtotal float not null,

	
	constraint pedidoCliente_fk_Prendas foreign key (idPedidoCliente) references PedidosCliente,
	constraint pedidoCliente_fk_Prendas1 foreign key (idPrenda) references Prendas
)

create table Transportes (
	idTransporte int not null identity (1,1),
	descripcion varchar(500) not null,
	
	constraint pk_transp primary key (idTransporte)
)

create table Pedido_Transporte (
	idPedido int not null,
	idTransporte int not null
	
	constraint pk_pedido_transporte primary key (idPedido, idTransporte),
	constraint pedido_fk_transporte foreign key (idPedido) references PedidosCliente,
	constraint pedido_fk_transporte1 foreign key (idTransporte) references Transportes
)

create table Facturas (
	idFactura int identity (1,1),
	subtotal float not null,
	total float not null,
	impuestos float null,
	fechaGeneracion datetime not null,
	idCliente int null,
	idPedidoCliente int null,

	constraint pk_facturas primary key (idFactura),
	constraint cli_fk_fact foreign key (idCliente) references Clientes,
	constraint ped_fk_fact foreign key (idPedidoCliente) references PedidosCliente
)

create table ItemPedidoInsumos (
	idPedidoInsumos int not null,
	idInsumo int not null,
	cantidad int not null

	constraint pk_pedido_insumo primary key (idPedidoInsumos, idInsumo),
	constraint pedido_fk_insumo foreign key (idPedidoInsumos) references PedidoInsumos,
	constraint pedido_fk_insumo1 foreign key (idInsumo) references Insumos
)

create table Movimientos (
	idMovimiento int identity(1,1),
	idPrenda int not null,
	detalle varchar(100) not null, --agregar de una produccion, enviar a despacho, devolucion de prendas
	cantidad int not null,
	

	constraint pk_movimientos primary key (idMovimiento),
	constraint fk_movimiento_prenda foreign key (idPrenda) references Prendas,
	
)

create table Prendas_Eliminadas (
	idPrendaEliminada int identity(1,1),
	idPrenda int not null,
	idEmpleadoBaja int not null,
	idGerente int not null,
	descripcion varchar(200)

	constraint pk_prendaseliminadas primary key (idPrendaEliminada),
	constraint fk_eliminada_prenda foreign key (idPrenda) references Prendas,
	constraint fk_eliminada_empleado foreign key (idEmpleadoBaja) references Empleados,
	constraint fk_eliminada_gerente foreign key (idGerente) references Empleados
)

create table Reclamos (
	idReclamo int identity(1,1),
	idCliente int not null,
	fechaReclamo DateTime not null,
	reclamo varchar(200),
	
	constraint pk_reclamos primary key (idReclamo),
	constraint fk_idCliente foreign key (idCliente) references Clientes
)

create table OrdenesProduccion (
	idOrdenProduccion int not null identity (1,1),
	idPrenda int not null,
	cantidad int not null,
	idPedidoCliente int not null,
	fecha DateTime not null,
	tipo varchar(20) not null,
	constraint pk_OrdenesP primary key (idOrdenProduccion),
	constraint fk_Prendas foreign key (idPrenda) references Prendas,
	constraint fk_PedidosCliente foreign key (idPedidoCliente) references PedidosCliente
)



create table ItemOrdenProduccion (
	idOrdenProduccion int not null,
	idPrenda int not null,
	cantidadPedida int not null,
	cantidadRealizada int not null,

	constraint pk_ItemOrdProd primary key (idOrdenProduccion, idPrenda),
)

create table Ubicaciones (
 codigo varchar(40),
 estado varchar(40),
 
 constraint pk_ubic primary key (codigo)
)

create table Bultos (
 idBulto int identity (1,1),
 idPrenda int not null,
 fechaGeneracion datetime,
 cantidad int,
 codigo varchar(40),

 constraint pk_bulto primary key (idBulto),
 constraint ub_fk_bu foreign key (codigo) references Ubicaciones,
 constraint pr_fk_bu foreign key (idPrenda) references Prendas
)


alter table Lotes add
	constraint lotes_prenda foreign key (idPrenda) references Prendas

alter table ItemOrdenProduccion add
	constraint ItemOrdProd_fk_Ord foreign key (idOrdenProduccion) references OrdenesProduccion,
	constraint ItemOrdProd_fk_Ord1 foreign key (idPrenda) references Prendas

alter table Empleados add
	constraint fk_empleados_suc foreign key (idSucursal) references Sucursales