/*Registro de locales*/
INSERT INTO locales (nombre_local,ciudad) VALUES('Fruteria Talca','Laja');
INSERT INTO locales (nombre_local,ciudad) VALUES('Supermercado Unico','Laja');
INSERT INTO locales (nombre_local,ciudad) VALUES('Unimarc','Laja');
INSERT INTO locales (nombre_local,ciudad) VALUES('Santa Isabel','Los Angeles');
INSERT INTO locales (nombre_local,ciudad) VALUES('Supermercado Lider','Los Angeles');
INSERT INTO locales (nombre_local,ciudad) VALUES('PC Factory','Concepcion');
INSERT INTO locales (nombre_local,ciudad) VALUES('ABCDIN','Concepcion');
INSERT INTO locales (nombre_local,ciudad) VALUES('Sucursal de Frontel','Laja');
INSERT INTO locales (nombre_local,ciudad) VALUES('Almacenes Paris','Santiago');
INSERT INTO locales (nombre_local,ciudad) VALUES('Super 10','Concepcion');
INSERT INTO locales (nombre_local,ciudad) VALUES('camioneta','Laja');
INSERT INTO locales (nombre_local,ciudad) VALUES('cruz verde','Laja');

/*Registro de tipos*/
INSERT INTO tipos_gastos (tipo) VALUES('agua');
INSERT INTO tipos_gastos (tipo) VALUES('luz');
INSERT INTO tipos_gastos (tipo) VALUES('ferreteria');
INSERT INTO tipos_gastos (tipo) VALUES('supermercado');
INSERT INTO tipos_gastos (tipo) VALUES('gas');
INSERT INTO tipos_gastos (tipo) VALUES('vestimenta');
INSERT INTO tipos_gastos (tipo) VALUES('tecnologia');
INSERT INTO tipos_gastos (tipo) VALUES('leña');
INSERT INTO tipos_gastos (tipo) VALUES('farmacia');

/*Registro de gastos*/
INSERT INTO gastos (nombre,valor,descripcion,fecha_gasto,tipo_gasto_id,local_id) VALUES('Boleta de la lus de enero del 2021',17000,'Se fue a pagar la boleta de luz de frontel','2021-01-13',2,8);
INSERT INTO gastos (nombre,valor,descripcion,fecha_gasto,tipo_gasto_id,local_id) VALUES ('Pago boleta del agua',7000,'Se fue a pagar la boleta del agua','2021-01-10',1,2);
INSERT INTO gastos (nombre,valor,descripcion,fecha_gasto,tipo_gasto_id,local_id) VALUES ('Compras en el supermercado ',25000,'Se compro carne, botella de limon, sarten y bolsas de yogurt','2021-01-25',4,3);
INSERT INTO gastos (nombre,valor,descripcion,fecha_gasto,tipo_gasto_id,local_id) VALUES('compra notebook',450000,'Pato fue a Santiago a comprar el notebook el dia lunes 22 de marzo','2021-03-22',7,9);
INSERT INTO gastos (nombre,valor,descripcion,fecha_gasto,tipo_gasto_id,local_id) VALUES('Viaje en tren a concepción',14000,'Se fue a concepcion el lunes a comprar carne y abarrotes y cotizar precios de productos en negocio','2021-03-15',4,10);
INSERT INTO gastos (nombre,valor,descripcion,fecha_gasto,tipo_gasto_id,local_id) VALUES('Boleta de luz de marzo',15100,'se pago en la sede de frontel de laja la boleta del mes de marzo','2021-03-08',2,8);
INSERT INTO gastos (nombre,valor,descripcion,fecha_gasto,tipo_gasto_id,local_id) VALUES('Compra de leña',45000,'se compro tres metros de leña de pino para tener para el invierno ','2021-03-16',8,11);
INSERT INTO gastos (nombre,valor,descripcion,fecha_gasto,tipo_gasto_id,local_id) VALUES('Compra crema pato',12900,'se compro en cruz verde crema para dermatitis del patricio','2021-03-15',9,12);


/*Registro de notas*/
INSERT INTO notas (titulo,descripcion,estado,fecha_creacion) VALUES('Viaje a Santiago','fui el lunes a santiago a una entrevista de trabajo','PENDIENTE','2020-02-05');
INSERT INTO notas (titulo,descripcion,estado,fecha_creacion) VALUES('Prestamo','le preste a mauricio $5000 pesos','PENDIENTE','2021-01-31');
INSERT INTO notas (titulo,descripcion,estado,fecha_creacion) VALUES('Reunion','Debo reunir con leslie para comprar miel','PENDIENTE','2021-02-05');
INSERT INTO notas (titulo,descripcion,estado,fecha_creacion) VALUES('Viaje a Concepcion','Se viajo a Concepcion','PENDIENTE','2020-12-31');


/* Creamos algunos usuarioscon sus roles */
INSERT INTO usuarios (username, password ,enabled,nombre,apellido,email) VALUES ('patricio','$2a$10$gcOuVoP7r3F/Z8vQIIaqz.KEKskcuRPbGa4E7LmsSB2RG0aibxQse',1,'Patricio','Contreras','patorma@yahoo.com');
INSERT INTO usuarios (username, password ,enabled,nombre,apellido,email) VALUES ('admin','$2a$10$kjhmhmQ.Fd/pCHBvAzjMc.BLgRCz0cYoT471d/z5arSNIe5Rddbz2',1,'John','Doe','john.doe@gmail.com');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id,role_id) VALUES (1,1);
INSERT INTO usuarios_roles (usuario_id,role_id) VALUES (2,2);
INSERT INTO usuarios_roles (usuario_id,role_id) VALUES (2,1);