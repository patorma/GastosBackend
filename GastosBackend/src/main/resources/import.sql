/*Registro de tipos de gastos*/
INSERT INTO tipo_gastos (nombre) VALUES ('Gastos Comunes');
INSERT INTO tipo_gastos (nombre) VALUES ('Ferreteria');
INSERT INTO tipo_gastos (nombre) VALUES ('Supermercado');
INSERT INTO tipo_gastos (nombre) VALUES ('Transporte');
INSERT INTO tipo_gastos (nombre) VALUES ('Carniceria');
INSERT INTO tipo_gastos (nombre) VALUES ('Otros');


/*Registro de ciudades*/
INSERT INTO ciudades (nombre) VALUES('Laja');
INSERT INTO ciudades (nombre) VALUES('Los Angeles');
INSERT INTO ciudades (nombre) VALUES ('Concepcion');
INSERT INTO ciudades (nombre) VALUES ('Santiago');
INSERT INTO ciudades (nombre) VALUES('Chillan');
INSERT INTO ciudades (nombre) VALUES ('Talcahuano');
INSERT INTO ciudades (nombre) VALUES('Temuco');

/*Registro de gastos*/
INSERT INTO gastos (nombre,descripcion,valor,fecha_gasto,tipo_id,local,ciudad_id) VALUES('Luz','se pago la cuenta de la luz',13100,'2019-05-06',1,'frontel',1);
INSERT INTO gastos (nombre,descripcion,valor,fecha_gasto,tipo_id,local,ciudad_id) VALUES('Agua','se pago la cuenta del agua',7900,'2019-05-06',1,'sencillito',1);
INSERT INTO gastos (nombre,descripcion,valor,fecha_gasto,tipo_id,local,ciudad_id) VALUES('Telefono','se pago la cuenta del telefono',36456,'2019-05-06',1,'sencillito del unico',1);
INSERT INTO gastos (nombre,descripcion,valor,fecha_gasto,tipo_id,local,ciudad_id) VALUES('cemento','se compro 2 bolsas de cemento en la ferreteria gran fe',25000,'2019-05-06',2,'ferreteria gran fe',1);
INSERT INTO gastos (nombre,descripcion,valor,fecha_gasto,tipo_id,local,ciudad_id) VALUES('Rueda de carretilla','se compro en los rios una rueda de la carretilla',12900,'2019-05-06',2,'ferreteria los rios',1);
INSERT INTO gastos (nombre,descripcion,valor,fecha_gasto,tipo_id,local,ciudad_id) VALUES('Viaje a los angeles','se compro dos pasajes a los angeles',2000,'2019-05-06',4,'boleteria buses laja',7);
INSERT INTO gastos (nombre,descripcion,valor,fecha_gasto,tipo_id,local,ciudad_id) VALUES('pasaje de tren','se viajo el lunes en tren a conce',6000,'2019-05-06',4,'boleteria estacion de trenes de laja',1);
INSERT INTO gastos (nombre,descripcion,valor,fecha_gasto,tipo_id,local,ciudad_id) VALUES('Viaje a Santiago','se viajo el martes en la noche a santiago y se volvio el miercoles',11100,'2019-05-06',4,'boleteria terminal rodoviario de laja',1);
INSERT INTO gastos (nombre,descripcion,valor,fecha_gasto,tipo_id,local,ciudad_id) VALUES('aletilla','se compro aletilla en el unico',6590,'2019-05-06',3,'Supermercado unico',1);
INSERT INTO gastos (nombre,descripcion,valor,fecha_gasto,tipo_id,local,ciudad_id) VALUES('Longaniza','se compro 2 tiras de longaniza en el unico',3000,'2019-05-06',3,'Supermercado unico',2);
INSERT INTO gastos (nombre,descripcion,valor,fecha_gasto,tipo_id,local,ciudad_id) VALUES('Chuleta','se compro 2 kilos de chuleta en los chavez',5000,'2019-05-06',5,'carniceria chavez',1);
INSERT INTO gastos (nombre,descripcion,valor,fecha_gasto,tipo_id,local,ciudad_id) VALUES('cazuela de vacuno','se compro un kilo de cazuela de vacuno en los chavez',2500,'2019-05-06',5,'carniceria los chavez',1);

/*Registro de notas*/
INSERT INTO notas (titulo,descripcion,fecha_creacion) VALUES('Viaje a Santiago','fui el lunes a santiago a una entrevista de trabajo','2020-02-05');