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
insert into CuentasCorriente values (10000, 'Pago completo', '02 de cada mes', 'Alta', 1000)
insert into CuentasCorriente values (200000, 'Pago parcial', '03 de cada mes', 'Alta', 1000)
insert into CuentasCorriente values (30000, 'Pago completo', '05 de cada mes', 'Alta', 1000)
insert into CuentasCorriente values (45000, 'Pago parcial', '07 de cada mes', 'Pendiente', 1000)
insert into CuentasCorriente values (15000, 'Pago completo', '09 de cada mes', 'Pendiente', 1000)
insert into CuentasCorriente values (13000, 'Pago completo', '12 de cada mes', 'Pendiente', 1000)
insert into CuentasCorriente values (9000, 'Pago completo', '17 de cada mes', 'Pendiente', 1000)

--clientes
insert into Clientes values ('02/06/2017 10:30', 'Cliente 1', '1234321', '46663333', 'Jose Bonifacio 1700 2A', 1, 1, 'Alta', 'German', '44223312', 'german@ejemplo.com', 'Masculino', 'cliente1', '123456')
insert into Clientes values ('02/06/2017 10:30', 'Cliente 2', '21241424', '46663333', 'Jose Ptiosn 1750 2A', 1, 2, 'Alta', 'Micaela', '44223312', 'Micaela@ejemplo.com', 'Femenino', 'cliente2', '123456')
insert into Clientes values ('02/06/2017 10:30', 'Cliente 3', '1232145', '46663333', 'Jose Alsekd 1730 2A', 1, 3, 'Alta', 'Pedro', '44223312', 'Pedro@ejemplo.com', 'Masculino', 'cliente3', '123456')
insert into Clientes values ('02/06/2017 10:30', 'Cliente 4', '7657512312', '46663333', 'Maria Bonifacio 1710 2A', 1, 4, 'Pendiente', 'Juan', '44223312', 'Juan@ejemplo.com', 'Masculino', 'cliente4', '123456')
insert into Clientes values ('02/06/2017 10:30', 'Cliente 5', '3255212', '46663333', 'Pedro Bonifacio 1600 2A', 1, 5, 'Pendiente', 'Fernando', '44223312', 'Fernando@ejemplo.com', 'Masculino', 'cliente5', '123456')
insert into Clientes values ('02/06/2017 10:30', 'Cliente 6', '5223421', '46663333', 'Jose Pedro 1500 2A', 1, 6, 'Pendiente', 'Piter', '44223312', 'Piter@ejemplo.com', 'Masculino', 'cliente6', '123456')
insert into Clientes values ('02/06/2017 10:30', 'Cliente 7', '67432123', '46663333', 'Jose Eduardo 1500 2A', 1, 7, 'Pendiente', 'German', '44223312', 'german@ejemplo.com', 'Masculino', 'cliente7', '123456')

--prendas
insert into Prendas values ( 'Azul', 'S', 'Pantalon', 1, 200, 200, 0.15, 230, 50, 20, 5)
insert into Prendas values ( 'Rojo', 'S', 'Pantalon', 1, 200, 200, 0.15, 230, 50, 20, 5)
insert into Prendas values ( 'Verde', 'S', 'Pantalon', 1, 200, 200, 0.15, 230, 50, 20, 5)
insert into Prendas values ( 'Azul', 'L', 'Pantalon', 1, 200, 200, 0.15, 230, 50, 20, 5)
insert into Prendas values ( 'Rojo', 'L', 'Pantalon', 1, 200, 200, 0.15, 230, 50, 20, 5)
insert into Prendas values ( 'Verde', 'L', 'Pantalon', 1, 200, 200, 0.15, 230, 50, 20, 5)

insert into Prendas values ( 'Azul', 'S', 'Remera', 1, 200, 200, 0.15, 230, 50, 20, 5)
insert into Prendas values ( 'Verde', 'S', 'Remera', 1, 200, 200, 0.15, 230, 50, 20, 5)
insert into Prendas values ( 'Violeta', 'S', 'Remera', 1, 200, 200, 0.15, 230, 50, 20, 5)
insert into Prendas values ( 'Azul', 'M', 'Remera', 1, 200, 200, 0.15, 230, 50, 20, 5)
insert into Prendas values ( 'Verde', 'M', 'Remera', 1, 200, 200, 0.15, 230, 50, 20, 5)
insert into Prendas values ( 'Violeta', 'M', 'Remera', 1, 200, 200, 0.15, 230, 50, 20, 5)

insert into Prendas values ( 'Violeta', 'M', 'Pollera', 1, 200, 200, 0.15, 230, 50, 20, 5)
insert into Prendas values ( 'Negra', 'M', 'Pollera', 1, 200, 200, 0.15, 230, 50, 20, 5)
insert into Prendas values ( 'Dorado', 'M', 'Pollera', 1, 200, 200, 0.15, 230, 50, 20, 5)
insert into Prendas values ( 'Violeta', 'S', 'Pollera', 1, 200, 200, 0.15, 230, 50, 20, 5)
insert into Prendas values ( 'Negra', 'S', 'Pollera', 1, 200, 200, 0.15, 230, 50, 20, 5)
insert into Prendas values ( 'Dorado', 'S', 'Pollera', 1, 200, 200, 0.15, 230, 50, 20, 5)

insert into Prendas values ( 'Azul', 'S', 'Jean', 1, 200, 200, 0.15, 230, 50, 20, 5)
insert into Prendas values ( 'Negro', 'S', 'Jean', 1, 200, 200, 0.15, 230, 50, 20, 5)
insert into Prendas values ( 'Azul', 'M', 'Jean', 1, 200, 200, 0.15, 230, 50, 20, 5)
insert into Prendas values ( 'Negro', 'M', 'Jean', 1, 200, 200, 0.15, 230, 50, 20, 5)

insert into Prendas values ( 'Azul', 'S', 'Bufanda', 1, 200, 200, 0.15, 230, 50, 20, 5)
insert into Prendas values ( 'Negro', 'S', 'Bufanda', 1, 200, 200, 0.15, 230, 50, 20, 5)


--proveedor
insert into Proveedores values ( 'Insumos SRL', '123112312')
insert into Proveedores values ( 'ParaPrendas SA', '1542433')


--insumos
insert into Insumos values ( 'Tela Negra', 0, '25/05/2017 08:20', 5, 200, 'm2', 600)
insert into Insumos values ( 'Tela Jean', 0, '25/05/2017 08:20', 5, 200, 'm2', 600 )
insert into Insumos values ( 'Botones', 0, '25/05/2017 08:20', 1, 100, 'unidades', 400 )
insert into Insumos values ( 'Hilo blanco', 0, '25/05/2017 08:20', 5, 400, 'm', 800)
insert into Insumos values ('cuero', 10000, 2017-05-25, 5, 200, 'm2', 600)
insert into Insumos values ('cordone', 10000, 2017-05-25, 5, 200, 'unidades', 600)
insert into Insumos values ('suela', 10000, 2017-05-25, 5, 200, 'unidades', 600)
insert into Insumos values ('abrojos', 10000, 2017-05-25, 5, 200, 'unidades', 600)
insert into Insumos values ('Inusmo1', 10000, 2017-05-25, 5, 200, 'm2', 600)
insert into Insumos values ('Inusmo2', 10000, 2017-05-25, 5, 200, 'm2', 600)
insert into Insumos values ('Inusmo3', 10000, 2017-05-25, 5, 200, 'm2', 600)
insert into Insumos values ('Inusmo4', 10000, 2017-05-25, 5, 200, 'm2', 600)
insert into Insumos values ('Inusmo5', 10000, 2017-05-25, 5, 200, 'm2', 600)

--Areas produccion

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
insert into pedidosCLiente values (1, 'Pendiente', '02/06/2017 10:30','02/06/2017 10:30','02/06/2017 10:30','02/06/2017 10:30',193200,null)
insert into pedidosCLiente values (2, 'Pendiente', '04/06/2017 10:30','04/06/2017 10:30','04/06/2017 10:30','04/06/2017 10:30',13800,null)
insert into pedidosCLiente values (3, 'Pendiente', '04/06/2017 10:30','04/06/2017 10:30','04/06/2017 10:30','04/06/2017 10:30',39100,null)

--itempedido
--idpedido, prenda, cantidad, subtotal
insert into itempedidocliente values (1, 1, 800, 184000)
insert into itempedidocliente values (1, 2, 20, 4600)
insert into itempedidocliente values (1, 3, 20, 4600)
insert into itempedidocliente values (2, 1, 20, 4600)
insert into itempedidocliente values (2, 2, 20, 4600)
insert into itempedidocliente values (2, 3, 20, 4600)
insert into itempedidocliente values (3, 3, 150, 34500)
insert into itempedidocliente values (3, 4, 20, 4600)

--iteminsumo
insert into prenda_insumos values (1, 1, 10, 2)
insert into prenda_insumos values (1, 2, 10, 2)
insert into prenda_insumos values (1, 3, 10, 2)

insert into prenda_insumos values (2, 1, 10, 2)
insert into prenda_insumos values (2, 2, 10, 2)
insert into prenda_insumos values (2, 3, 10, 2)
insert into prenda_insumos values (2, 4, 10, 2)
insert into prenda_insumos values (2, 5, 10, 2)
insert into prenda_insumos values (2, 6, 10, 2)
insert into prenda_insumos values (3, 7, 10, 2)
insert into prenda_insumos values (3, 1, 10, 2)
insert into prenda_insumos values (3, 2, 10, 2)
insert into prenda_insumos values (3, 3, 10, 2)
insert into prenda_insumos values (3, 4, 10, 2)
insert into prenda_insumos values (3, 5, 10, 2)
insert into prenda_insumos values (3, 6, 10, 2)
insert into prenda_insumos values (3, 7, 10, 2)
insert into prenda_insumos values (3, 8, 10, 2)
insert into prenda_insumos values (4, 1, 10, 2)
insert into prenda_insumos values (4, 2, 10, 2)
insert into prenda_insumos values (4, 3, 10, 2)
insert into prenda_insumos values (4, 4, 10, 2)
insert into prenda_insumos values (4, 5, 10, 2)
insert into prenda_insumos values (4, 6, 10, 2)
insert into prenda_insumos values (4, 7, 10, 2)
insert into prenda_insumos values (4, 8, 10, 2)

insert into prenda_insumos values (5, 1, 10, 2)
insert into prenda_insumos values (5, 2, 10, 2)
insert into prenda_insumos values (5, 3, 10, 2)
insert into prenda_insumos values (5, 4, 10, 2)
insert into prenda_insumos values (5, 5, 10, 2)
insert into prenda_insumos values (5, 6, 10, 2)
insert into prenda_insumos values (5, 7, 10, 2)
insert into prenda_insumos values (5, 8, 10, 2)

insert into prenda_insumos values (6, 1, 10, 2)
insert into prenda_insumos values (6, 2, 10, 2)
insert into prenda_insumos values (6, 3, 10, 2)
insert into prenda_insumos values (6, 4, 10, 2)
insert into prenda_insumos values (6, 5, 10, 2)
insert into prenda_insumos values (6, 6, 10, 2)
insert into prenda_insumos values (6, 7, 10, 2)
insert into prenda_insumos values (6, 8, 10, 2)

insert into prenda_insumos values (7, 1, 10, 2)
insert into prenda_insumos values (7, 2, 10, 2)
insert into prenda_insumos values (7, 3, 10, 2)
insert into prenda_insumos values (7, 4, 10, 2)
insert into prenda_insumos values (7, 5, 10, 2)
insert into prenda_insumos values (7, 6, 10, 2)
insert into prenda_insumos values (7, 7, 10, 2)
insert into prenda_insumos values (7, 8, 10, 2)

insert into prenda_insumos values (8, 1, 10, 2)
insert into prenda_insumos values (8, 2, 10, 2)
insert into prenda_insumos values (8, 3, 10, 2)
insert into prenda_insumos values (8, 4, 10, 2)
insert into prenda_insumos values (8, 5, 10, 2)
insert into prenda_insumos values (8, 6, 10, 2)
insert into prenda_insumos values (8, 7, 10, 2)
insert into prenda_insumos values (8, 8, 10, 2)

insert into prenda_insumos values (9, 1, 10, 2)
insert into prenda_insumos values (9, 2, 10, 2)
insert into prenda_insumos values (9, 3, 10, 2)
insert into prenda_insumos values (9, 4, 10, 2)
insert into prenda_insumos values (9, 5, 10, 2)
insert into prenda_insumos values (9, 6, 10, 2)
insert into prenda_insumos values (9, 7, 10, 2)
insert into prenda_insumos values (9, 8, 10, 2)

insert into prenda_insumos values (10, 1, 10, 2)
insert into prenda_insumos values (10, 2, 10, 2)
insert into prenda_insumos values (10, 3, 10, 2)
insert into prenda_insumos values (10, 4, 10, 2)
insert into prenda_insumos values (10, 5, 10, 2)
insert into prenda_insumos values (10, 6, 10, 2)
insert into prenda_insumos values (10, 7, 10, 2)
insert into prenda_insumos values (10, 8, 10, 2)

insert into prenda_insumos values (11, 1, 10, 2)
insert into prenda_insumos values (11, 2, 10, 2)
insert into prenda_insumos values (11, 3, 10, 2)
insert into prenda_insumos values (11, 4, 10, 2)
insert into prenda_insumos values (11, 5, 10, 2)
insert into prenda_insumos values (11, 6, 10, 2)
insert into prenda_insumos values (11, 7, 10, 2)
insert into prenda_insumos values (11, 8, 10, 2)


insert into prenda_insumos values (12, 1, 10, 2)
insert into prenda_insumos values (12, 2, 10, 2)
insert into prenda_insumos values (12, 3, 10, 2)
insert into prenda_insumos values (12, 4, 10, 2)
insert into prenda_insumos values (12, 5, 10, 2)
insert into prenda_insumos values (12, 6, 10, 2)
insert into prenda_insumos values (12, 7, 10, 2)
insert into prenda_insumos values (12, 8, 10, 2)

insert into prenda_insumos values (13, 1, 10, 2)
insert into prenda_insumos values (13, 2, 10, 2)
insert into prenda_insumos values (13, 3, 10, 2)
insert into prenda_insumos values (13, 4, 10, 2)
insert into prenda_insumos values (13, 5, 10, 2)
insert into prenda_insumos values (13, 6, 10, 2)
insert into prenda_insumos values (13, 7, 10, 2)
insert into prenda_insumos values (13, 8, 10, 2)

insert into prenda_insumos values (14, 1, 10, 2)
insert into prenda_insumos values (14, 2, 10, 2)
insert into prenda_insumos values (14, 3, 10, 2)
insert into prenda_insumos values (14, 4, 10, 2)
insert into prenda_insumos values (14, 5, 10, 2)
insert into prenda_insumos values (14, 6, 10, 2)
insert into prenda_insumos values (14, 7, 10, 2)
insert into prenda_insumos values (14, 8, 10, 2)

insert into prenda_insumos values (15, 1, 10, 2)
insert into prenda_insumos values (15, 2, 10, 2)
insert into prenda_insumos values (15, 3, 10, 2)
insert into prenda_insumos values (15, 4, 10, 2)
insert into prenda_insumos values (15, 5, 10, 2)
insert into prenda_insumos values (15, 6, 10, 2)
insert into prenda_insumos values (15, 7, 10, 2)
insert into prenda_insumos values (15, 8, 10, 2)

insert into prenda_insumos values (16, 1, 10, 2)
insert into prenda_insumos values (16, 2, 10, 2)
insert into prenda_insumos values (16, 3, 10, 2)
insert into prenda_insumos values (16, 4, 10, 2)
insert into prenda_insumos values (16, 5, 10, 2)
insert into prenda_insumos values (16, 6, 10, 2)
insert into prenda_insumos values (16, 7, 10, 2)
insert into prenda_insumos values (16, 8, 10, 2)

insert into prenda_insumos values (17, 1, 10, 2)
insert into prenda_insumos values (17, 2, 10, 2)
insert into prenda_insumos values (17, 3, 10, 2)
insert into prenda_insumos values (17, 4, 10, 2)
insert into prenda_insumos values (17, 5, 10, 2)
insert into prenda_insumos values (17, 6, 10, 2)
insert into prenda_insumos values (17, 7, 10, 2)
insert into prenda_insumos values (17, 8, 10, 2)

insert into prenda_insumos values (18, 1, 10, 2)
insert into prenda_insumos values (18, 2, 10, 2)
insert into prenda_insumos values (18, 3, 10, 2)
insert into prenda_insumos values (18, 4, 10, 2)
insert into prenda_insumos values (18, 5, 10, 2)
insert into prenda_insumos values (18, 6, 10, 2)
insert into prenda_insumos values (18, 7, 10, 2)
insert into prenda_insumos values (18, 8, 10, 2)

insert into prenda_insumos values (19, 1, 10, 2)
insert into prenda_insumos values (19, 2, 10, 2)
insert into prenda_insumos values (19, 3, 10, 2)
insert into prenda_insumos values (19, 4, 10, 2)
insert into prenda_insumos values (19, 5, 10, 2)
insert into prenda_insumos values (19, 6, 10, 2)
insert into prenda_insumos values (19, 7, 10, 2)
insert into prenda_insumos values (19, 8, 10, 2)

insert into prenda_insumos values (20, 1, 10, 2)
insert into prenda_insumos values (20, 2, 10, 2)
insert into prenda_insumos values (20, 3, 10, 2)
insert into prenda_insumos values (20, 4, 10, 2)
insert into prenda_insumos values (20, 5, 10, 2)
insert into prenda_insumos values (20, 6, 10, 2)
insert into prenda_insumos values (20, 7, 10, 2)
insert into prenda_insumos values (20, 8, 10, 2)

insert into prenda_insumos values (21, 1, 10, 2)
insert into prenda_insumos values (21, 2, 10, 2)
insert into prenda_insumos values (21, 3, 10, 2)
insert into prenda_insumos values (21, 4, 10, 2)
insert into prenda_insumos values (21, 5, 10, 2)
insert into prenda_insumos values (21, 6, 10, 2)
insert into prenda_insumos values (21, 7, 10, 2)
insert into prenda_insumos values (21, 8, 10, 2)

insert into prenda_insumos values (22, 1, 10, 2)
insert into prenda_insumos values (22, 2, 10, 2)
insert into prenda_insumos values (22, 3, 10, 2)
insert into prenda_insumos values (22, 4, 10, 2)
insert into prenda_insumos values (22, 5, 10, 2)
insert into prenda_insumos values (22, 6, 10, 2)
insert into prenda_insumos values (22, 7, 10, 2)
insert into prenda_insumos values (22, 8, 10, 2)

insert into prenda_insumos values (23, 1, 10, 2)
insert into prenda_insumos values (23, 2, 10, 2)
insert into prenda_insumos values (23, 3, 10, 2)
insert into prenda_insumos values (23, 4, 10, 2)
insert into prenda_insumos values (23, 5, 10, 2)
insert into prenda_insumos values (23, 6, 10, 2)
insert into prenda_insumos values (23, 7, 10, 2)
insert into prenda_insumos values (23, 8, 10, 2)

insert into prenda_insumos values (24, 1, 10, 2)
insert into prenda_insumos values (24, 2, 10, 2)
insert into prenda_insumos values (24, 3, 10, 2)
insert into prenda_insumos values (24, 4, 10, 2)
insert into prenda_insumos values (24, 5, 10, 2)
insert into prenda_insumos values (24, 6, 10, 2)
insert into prenda_insumos values (24, 7, 10, 2)
insert into prenda_insumos values (24, 8, 10, 2)

--ordenProd
--insert into OrdenesProduccion values (1, 10, 1, '04/06/2017 10:30', 'OPP')




--lineas de produccion

insert into lineasproduccion values (1,0, 10, null, 0)
insert into lineasproduccion values (1,0, 10, null, 0)
insert into lineasproduccion values (1,0, 10, null, 0)
insert into lineasproduccion values (2,0, 10, null, 0)
insert into lineasproduccion values (2,0, 10, null, 0)
insert into lineasproduccion values (2,0, 10, null, 0)
insert into lineasproduccion values (3,0, 10, null, 0)
insert into lineasproduccion values (3,0, 10, null, 0)
insert into lineasproduccion values (3,0, 10, null, 0)
insert into lineasproduccion values (4,0, 10, null, 0)
insert into lineasproduccion values (4,0, 10, null, 0)
insert into lineasproduccion values (4,0, 10, null, 0)
insert into lineasproduccion values (5,0, 10, null, 0)
insert into lineasproduccion values (5,0, 10, null, 0)
insert into lineasproduccion values (5,0, 10, null, 0)
insert into lineasproduccion values (6,0, 10, null, 0)
insert into lineasproduccion values (6,0, 10, null, 0)
insert into lineasproduccion values (6,0, 10, null, 0)
insert into lineasproduccion values (7,0, 10, null, 0)
insert into lineasproduccion values (7,0, 10, null, 0)
insert into lineasproduccion values (7,0, 10, null, 0)
insert into lineasproduccion values (8,0, 10, null, 0)
insert into lineasproduccion values (8,0, 10, null, 0)
insert into lineasproduccion values (8,0, 10, null, 0)