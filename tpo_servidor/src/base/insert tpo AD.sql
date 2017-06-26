--Sucursales
insert into Sucursales values ( 'Sucursal 1A', 'Independencia 122', '09:00-18:00')
insert into Sucursales values ( 'Sucursal 2B', 'Lima 123', '09:00-18:00')
insert into Sucursales values ( 'Sucursal 3C', 'CalleFalsa 453', '09:00-18:00')
insert into Sucursales values ( 'Sucursal 4D', 'Calle de asfafa 225', '09:00-18:00')

--trabajadores
insert into empleados values ('Franco', 'Gerente', 'usuario1','123456', 1, 1)
insert into empleados values ('Benjamin', 'Empleado','usuario2','123456', 2, 1)
insert into empleados values ('Lucas', 'Empleado','usuario3','123456', 3, 1)
insert into empleados values ('Martin', 'Empleado','usuario4','123456', 4, 1)
insert into empleados values ('Manuel', 'Empleado','usuario5','123456', 5, 1)
insert into empleados values ('Mariano', 'Empleado','usuario6','123456', 6, 1)

--cuenta corriente
insert into CuentasCorriente values (10000, 'Pago completo', '02 de cada mes', 'Pendiente', 1000)
insert into CuentasCorriente values (20000, 'Pago parcial', '03 de cada mes', 'Pendiente', 1000)
insert into CuentasCorriente values (30000, 'Pago completo', '05 de cada mes', 'Pendiente', 1000)
insert into CuentasCorriente values (45000, 'Pago parcial', '07 de cada mes', 'Pendiente', 1000)
insert into CuentasCorriente values (15000, 'Pago completo', '09 de cada mes', 'Pendiente', 1000)
insert into CuentasCorriente values (13000, 'Pago completo', '12 de cada mes', 'Pendiente', 1000)
insert into CuentasCorriente values (9000, 'Pago completo', '17 de cada mes', 'Pendiente', 1000)

--clientes
insert into Clientes values ('02/06/2017 10:30', 'Cliente 1', '1234321', '46663333', 'Jose Bonifacio 1700 2A', 1, 1, 'Pendiente', 'German', '44223312', 'german@ejemplo.com', 'Masculino')
insert into Clientes values ('02/06/2017 10:30', 'Cliente 2', '21241424', '46663333', 'Jose Ptiosn 1750 2A', 1, 2, 'Pendiente', 'Micaela', '44223312', 'Micaela@ejemplo.com', 'Femenino')
insert into Clientes values ('02/06/2017 10:30', 'Cliente 3', '1232145', '46663333', 'Jose Alsekd 1730 2A', 1, 3, 'Pendiente', 'Pedro', '44223312', 'Pedro@ejemplo.com', 'Masculino')
insert into Clientes values ('02/06/2017 10:30', 'Cliente 4', '7657512312', '46663333', 'Maria Bonifacio 1710 2A', 1, 4, 'Pendiente', 'Juan', '44223312', 'Juan@ejemplo.com', 'Masculino')
insert into Clientes values ('02/06/2017 10:30', 'Cliente 5', '3255212', '46663333', 'Pedro Bonifacio 1600 2A', 1, 5, 'Pendiente', 'Fernando', '44223312', 'Fernando@ejemplo.com', 'Masculino')
insert into Clientes values ('02/06/2017 10:30', 'Cliente 6', '5223421', '46663333', 'Jose Pedro 1500 2A', 1, 6, 'Pendiente', 'Piter', '44223312', 'Piter@ejemplo.com', 'Masculino')
insert into Clientes values ('02/06/2017 10:30', 'Cliente 7', '67432123', '46663333', 'Jose Eduardo 1500 2A', 1, 7, 'Pendiente', 'German', '44223312', 'german@ejemplo.com', 'Masculino')

--prendas
insert into Prendas values ( 'Azul', 'S', 'Pantalon Azul', 1, 200, 200, 0.15, 230, 50, 20, 50)
insert into Prendas values ( 'Rojo', 'S', 'Pantalon Rojo', 1, 200, 200, 0.15, 230, 50, 20, 50)
insert into Prendas values ( 'Verde', 'S', 'Pantalon Verde', 1, 200, 200, 0.15, 230, 50, 20, 50)
insert into Prendas values ( 'Azul', 'L', 'Pantalon Azul', 1, 200, 200, 0.15, 230, 50, 20, 50)
insert into Prendas values ( 'Rojo', 'L', 'Pantalon Rojo', 1, 200, 200, 0.15, 230, 50, 20, 50)
insert into Prendas values ( 'Verde', 'L', 'Pantalon Verde', 1, 200, 200, 0.15, 230, 50, 20, 50)

insert into Prendas values ( 'Azul', 'S', 'Remera Azul', 1, 200, 200, 0.15, 230, 50, 20, 50)
insert into Prendas values ( 'Verde', 'S', 'Remera Verde', 1, 200, 200, 0.15, 230, 50, 20, 50)
insert into Prendas values ( 'Violeta', 'S', 'Remera Violeta', 1, 200, 200, 0.15, 230, 50, 20, 50)
insert into Prendas values ( 'Azul', 'M', 'Remera Azul', 1, 200, 200, 0.15, 230, 50, 20, 50)
insert into Prendas values ( 'Verde', 'M', 'Remera Verde', 1, 200, 200, 0.15, 230, 50, 20, 50)
insert into Prendas values ( 'Violeta', 'M', 'Remera Violeta', 1, 200, 200, 0.15, 230, 50, 20, 50)

insert into Prendas values ( 'Violeta', 'M', 'Pollera Violeta', 1, 200, 200, 0.15, 230, 50, 20, 50)
insert into Prendas values ( 'Negra', 'M', 'Pollera Negra', 1, 200, 200, 0.15, 230, 50, 20, 50)
insert into Prendas values ( 'Dorado', 'M', 'Pollera Dorada', 1, 200, 200, 0.15, 230, 50, 20, 50)
insert into Prendas values ( 'Violeta', 'S', 'Pollera Violeta', 1, 200, 200, 0.15, 230, 50, 20, 50)
insert into Prendas values ( 'Negra', 'S', 'Pollera Negra', 1, 200, 200, 0.15, 230, 50, 20, 50)
insert into Prendas values ( 'Dorado', 'S', 'Pollera Dorada', 1, 200, 200, 0.15, 230, 50, 20, 50)

insert into Prendas values ( 'Azul', 'S', 'Jean Azul', 1, 200, 200, 0.15, 230, 50, 20, 50)
insert into Prendas values ( 'Negro', 'S', 'Jean Negro', 1, 200, 200, 0.15, 230, 50, 20, 50)
insert into Prendas values ( 'Azul', 'M', 'Jean Azul', 1, 200, 200, 0.15, 230, 50, 20, 50)
insert into Prendas values ( 'Negro', 'M', 'Jean Negro', 1, 200, 200, 0.15, 230, 50, 20, 50)

insert into Prendas values ( 'Azul', 'S', 'Bufanda Azul', 1, 200, 200, 0.15, 230, 50, 20, 50)
insert into Prendas values ( 'Negro', 'S', 'Bufanda Negra y roja', 1, 200, 200, 0.15, 230, 50, 20, 50)


--proveedor
insert into Proveedores values ( 'Insumos SRL', '123112312')
insert into Proveedores values ( 'ParaPrendas SA', '1542433')


--insumos
insert into Insumos values ( 'Tela Negra', 0, '25/05/2017 08:20', 5, 200, 'm2', 600)
insert into Insumos values ( 'Tela Jean', 0, '25/05/2017 08:20', 5, 200, 'm2', 600 )
insert into Insumos values ( 'Botones', 0, '25/05/2017 08:20', 1, 100, 'unidades', 400 )
insert into Insumos values ( 'Hilo blanco', 0, '25/05/2017 08:20', 5, 400, 'm', 800)

--Areas produccion

insert into areasPRoduccion values ('Marcado')
insert into areasPRoduccion values ('Corte')
insert into areasPRoduccion values ('Habilitado')
insert into areasPRoduccion values ('Costura')
insert into areasPRoduccion values ('Estampado')
insert into areasPRoduccion values ('Acabado')
insert into areasPRoduccion values ('Planchado')
insert into areasPRoduccion values ('Empacado')
insert into areasPRoduccion values ('Marcado')
insert into areasPRoduccion values ('Corte')
insert into areasPRoduccion values ('Habilitado')
insert into areasPRoduccion values ('Costura')
insert into areasPRoduccion values ('Estampado')
insert into areasPRoduccion values ('Acabado')
insert into areasPRoduccion values ('Planchado')
insert into areasPRoduccion values ('Empacado')

insert into prenda_areas values(1,1, 5)
insert into prenda_areas values(1,2, 5)
insert into prenda_areas values(1,3, 5)
insert into prenda_areas values(1,4, 5)
insert into prenda_areas values(1,5, 5)
insert into prenda_areas values(1,6, 5)
insert into prenda_areas values(1,7, 5)
insert into prenda_areas values(1,8, 5)

insert into prenda_areas values(2,1, 3)
insert into prenda_areas values(2,2, 3)
insert into prenda_areas values(2,3, 3)
insert into prenda_areas values(2,4, 3)
insert into prenda_areas values(2,5, 3)
insert into prenda_areas values(2,6, 3)
insert into prenda_areas values(2,7, 3)
insert into prenda_areas values(2,8, 3)

--pedidos
insert into pedidosCLiente values (1, 'Pendiente', '02/06/2017 10:30','02/06/2017 10:30','02/06/2017 10:30','02/06/2017 10:30',400000)
insert into pedidosCLiente values (2, 'Pendiente', '04/06/2017 10:30','04/06/2017 10:30','04/06/2017 10:30','04/06/2017 10:30',45)
insert into pedidosCLiente values (3, 'Pendiente', '04/06/2017 10:30','04/06/2017 10:30','04/06/2017 10:30','04/06/2017 10:30',4500)
--itempedido
insert into itempedidocliente values (1, 1, 800, 55)
insert into itempedidocliente values (1, 2, 20, 55)
insert into itempedidocliente values (1, 3, 20, 55)
insert into itempedidocliente values (2, 1, 20, 55)
insert into itempedidocliente values (2, 2, 20, 55)
insert into itempedidocliente values (2, 3, 20, 55)
insert into itempedidocliente values (3, 3, 800, 55)
insert into itempedidocliente values (3, 4, 20, 55)

--iteminsumo
insert into prenda_insumos values (1, 1, 10, 2)
insert into prenda_insumos values (1, 2, 10, 2)
insert into prenda_insumos values (1, 3, 10, 2)

--ordenProd
--insert into OrdenesProduccion values (1, 10, 1, '04/06/2017 10:30', 'OPP')


