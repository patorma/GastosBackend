/*Registro de gastos*/
INSERT INTO gastos (nombre,valor,tipo,descripcion,fecha_gasto) VALUES('Luz',17000,'GASTO_COMUN','Se fue a pagar la boleta de luz de frontel','2021-01-13');
INSERT INTO gastos (nombre,valor,tipo,descripcion,fecha_gasto) VALUES ('Agua',7000,'GASTO_COMUN','Se fue a pagar la boleta del agua','2021-01-10');
INSERT INTO gastos (nombre,valor,tipo,descripcion,fecha_gasto) VALUES ('Supermercado',25000,'OTROS','Se compro carne, botella de limon, sarten y bolsas de yogurt','2021-01-25');
INSERT INTO gastos (nombre,valor,tipo,descripcion,fecha_gasto) VALUES('compra notebook',450000,'OTROS','Pato fue a Santiago a comprar el notebook el dia lunes 22 de marzo','2021-03-22');
INSERT INTO gastos (nombre,valor,tipo,descripcion,fecha_gasto) VALUES('Viaje en tren a concepción',14000,'OTROS','Se fue a concepcion el lunes a comprar carne y abarrotes y cotizar precios de productos en negocio','2021-03-15');
INSERT INTO gastos (nombre,valor,tipo,descripcion,fecha_gasto) VALUES('Boleta de luz de marzon',15100,'GASTO_COMUN','se pago en la sede de frontel de laja la boleta del mes de marzo','2021-03-08');
INSERT INTO gastos (nombre,valor,tipo,descripcion,fecha_gasto) VALUES('Compra de leña',45000,'OTROS','se compro tres metros de leña de pino para tener para el invierno ','2021-03-16');
INSERT INTO gastos (nombre,valor,tipo,descripcion,fecha_gasto) VALUES('Compra crema pato',12900,'OTROS','se compro en cruz verde crema para dermatitis del patricio','2021-03-15');


/*Registro de notas*/
INSERT INTO notas (titulo,descripcion,estado,fecha_creacion) VALUES('Viaje a Santiago','fui el lunes a santiago a una entrevista de trabajo','PENDIENTE','2020-02-05');
INSERT INTO notas (titulo,descripcion,estado,fecha_creacion) VALUES('Prestamo','le preste a mauricio $5000 pesos','PENDIENTE','2021-01-31');
INSERT INTO notas (titulo,descripcion,estado,fecha_creacion) VALUES('Reunion','Debo reunir con leslie para comprar miel','PENDIENTE','2021-02-05');
INSERT INTO notas (titulo,descripcion,estado,fecha_creacion) VALUES('Viaje a Concepcion','Se viajo a Concepcion','PENDIENTE','2020-12-31');


/* Creamos algunos usuarioscon sus roles */
INSERT INTO usuarios (username, password ,enabled) VALUES ('patricio','$2a$10$gcOuVoP7r3F/Z8vQIIaqz.KEKskcuRPbGa4E7LmsSB2RG0aibxQse',1);
INSERT INTO usuarios (username, password ,enabled) VALUES ('admin','$2a$10$kjhmhmQ.Fd/pCHBvAzjMc.BLgRCz0cYoT471d/z5arSNIe5Rddbz2',1);

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id,role_id) VALUES (1,1);
INSERT INTO usuarios_roles (usuario_id,role_id) VALUES (2,2);
INSERT INTO usuarios_roles (usuario_id,role_id) VALUES (2,1);