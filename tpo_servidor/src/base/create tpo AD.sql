create table OrdenesProduccion (
	idOrdenProduccion int not null identity (1,1),
	fecha DateTime not null,
	tipo varchar(5) not null,

	constraint pk_OrdenesP primary key (idOrdenProduccion)
)

create table ItemOrdenProduccion (
	idOrdenProduccion int not null,
	idPrenda int not null,
	idColor int not null,
	idTalle int not null,
	cantidadPedida int not null,
	cantidadRealizada int not null,

	constraint pk_ItemOrdProd primary key (idOrdenProduccion, idPrenda, idColor, idTalle),
)

create table Prendas (
	idPrenda int not null,
	idColor int not null,
	idTalle int not null,
	descripcion varchar(100) not null,
	estadoProduccion bit not null,
	costoProduccion float not null,
	costoProduccionActual float not null,
	porcentajeGanancia float not null,
	precio float not null,
	cantidadAConfeccionar int not null,
	stockMinimo int not null,
	stcokActual int not null


	constraint pk_Prendas primary key (idPrenda, idColor, idTalle)
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
	estado bit not null,
	capacidad int not null,
	horaInicio datetime not null, 
	tiempoUso DateTime not null,

	constraint pk_LineasProd primary key (idLineaProduccion)
)


create table Lotes (
	idLote int not null identity(1,1),
	idPrenda int not null,
	idColor int null,
	idTalle int null,
	cantidad int not null,
	idOrden int null,

	constraint pk_lote primary key (idLote)
)

create table Insumos (
	idInsumo int not null identity (1,1),
	nombre varchar(50) not null,
	stock float not null,
	idLote int not null,
	fechaRecepcion DateTime not null,
	precio float not null,
	stockMin float not null,
	unidad varchar(50) not null,
	cantAComprar float not null,

	constraint pk_Insumos primary key (idInsumo),
	constraint fk_Lotes foreign key (idLote) references Lotes
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
	idColor int not null,
	idTalle int not null,
	idAreaProduccion int not null,
	minutoEnArea int not null,

	constraint pk_prenda_areas primary key (idPrenda, idColor, idTalle, idAreaProduccion),
	constraint prenda_fk_area foreign key (idPrenda, idColor, idTalle) references Prendas,
	constraint prenda_fk_area1 foreign key (idAreaProduccion) references AreasProduccion
)

create table Area_lineasProduccion (
	idAreaProduccion int not null,
	idLineaProduccion int not null,
	
	constraint pk_Area_Lp primary key (idAreaProduccion, idLineaProduccion),
	constraint area_fk_lineap foreign key (idAreaProduccion) references AreasProduccion,
	constraint area_fk_lineap1 foreign key (idLineaProduccion) references LineasProduccion
)


create table prenda_insumos (
	idPrenda int not null,
	idColor int not null,
	idTalle int not null,
	idInsumo int not null,
	cantidad float not null,
	desperdicio float not null,

	constraint pk_Pren_Ins primary key (idPrenda, idColor, idTalle, idInsumo),
	constraint prenda_fk_insumo foreign key (idPrenda, idColor, idTalle) references Prendas,
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
	nombre varchar(60) not null,
	cuit varchar(30) not null,
	telefono varchar(30) not null,
	direccion varchar(40) not null,
	--categoria varchar(30) not null,
	--informacion varchar(40) not null,
	idSucursal int not null,
	idCCorriente int,
	estado varchar(40) not null,
	encargado varchar(40) not null,
	telencargado varchar(40) not null,
	mailencargado varchar(40) not null,
	generoencargado varchar(40) not null

	constraint pk_Cliente primary key (idCliente),
	constraint cliente_fk_cuentacor foreign key (idCCorriente) references CuentasCorriente,
	constraint cliente_fk_sucursal foreign key (idSucursal) references Sucursales
)

create table PedidosCliente (
	idPedidoCliente int not null identity(1,1),
	idCliente int not null,
	estado varchar(20) not null, --puede ser pendiente, aceptado, enviado
	fechaGeneracion DateTime not null,
	fechaEstimadaDespacho DateTime not null,
	fechaRealDespacho DateTime not null,
	fechaEntregaCliente DateTime not null,
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

create table Talles (
	idTalle int not null identity (1,1), 
	nombre varchar(50) not null,

	constraint pk_talle primary key (idTalle)
)

create table Colores (
	idColor int not null identity (1,1), 
	nombre varchar(50) not null,

	constraint pk_color primary key (idColor)
)

create table ItemPedidoCliente (
	idPedidoCliente int not null,
	idPrenda int not null,
	idColor int not null,
	idTalle int not null,
	cantidad int not null,
	subtotal float not null,

	constraint pk_pedidocliente_prendas primary key (idPedidoCliente, idPrenda, idColor, idTalle),
	constraint pedidoCliente_fk_Prendas foreign key (idPedidoCliente) references PedidosCliente,
	constraint pedidoCliente_fk_Prendas1 foreign key (idPrenda, idColor, idTalle) references Prendas
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
	idColor int not null,
	idTalle int not null,
	tipo varchar(100) not null, --agregar de una produccion, enviar a despacho, devolucion de prendas
	cantidad int not null,
	idCliente int null, --si no es devolucion, va NULL
	idPedido int null, --si no es enviar a despacho, va NULL
	idOrdenProduccion int null -- si no es agregar de una produccion, va NULL

	constraint pk_movimientos primary key (idMovimiento),
	constraint fk_movimiento_prenda foreign key (idPrenda, idColor, idTalle) references Prendas,
	constraint fk_movimiento_cliente foreign key (idCliente) references Clientes,
	constraint fk_movimiento_pedido foreign key (idPedido) references PedidosCliente,
	constraint fk_movimiento_orden foreign key (idOrdenProduccion) references OrdenesProduccion
)

create table Prendas_Eliminadas (
	idPrendaEliminada int identity(1,1),
	idPrenda int not null,
	idColor int not null,
	idTalle int not null,
	idEmpleadoBaja int not null,
	idGerente int not null,
	descripcion varchar(200)

	constraint pk_prendaseliminadas primary key (idPrendaEliminada),
	constraint fk_eliminada_prenda foreign key (idPrenda, idColor, idTalle) references Prendas,
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

alter table Lotes add
	constraint lotes_prenda foreign key (idPrenda, idColor, idTalle) references Prendas

alter table ItemOrdenProduccion add
	constraint ItemOrdProd_fk_Ord foreign key (idOrdenProduccion) references OrdenesProduccion,
	constraint ItemOrdProd_fk_Ord1 foreign key (idPrenda, idColor, idTalle) references Prendas

alter table Prendas add
	constraint fk_prendas_color foreign key (idColor) references Colores,
	constraint fk_prendas_talles foreign key (idTalle) references Talles

alter table Empleados add
	constraint fk_empleados_suc foreign key (idSucursal) references Sucursales