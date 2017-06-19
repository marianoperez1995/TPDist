--Sucursales
insert into Sucursales values ( 'Sucursal 1A', 'Independencia 122', '09:00-18:00')
insert into Sucursales values ( 'Sucursal 2B', 'Lima 123', '09:00-18:00')
insert into Sucursales values ( 'Sucursal 3C', 'CalleFalsa 453', '09:00-18:00')
insert into Sucursales values ( 'Sucursal 4D', 'Calle de asfafa 225', '09:00-18:00')

--trabajadores
insert into empleados values ('Franco', 'gerente', 'usuario1','123456', 1, 1)
insert into empleados values ('Benjamin', 'empleado','usuario2','123456', 2, 1)
insert into empleados values ('Lucas', 'empleado','usuario3','123456', 3, 1)
insert into empleados values ('Martin', 'empleado','usuario4','123456', 4, 1)
insert into empleados values ('Manuel', 'empleado','usuario5','123456', 5, 1)
insert into empleados values ('Mariano', 'empleado','usuario6','123456', 6, 1)

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