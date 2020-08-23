/*Registro de tipos de gastos*/
INSERT INTO tipo_gastos (tipo) VALUES ('Gastos Comunes');
INSERT INTO tipo_gastos (tipo) VALUES ('Ferreteria');
INSERT INTO tipo_gastos (tipo) VALUES ('Supermercado');
INSERT INTO tipo_gastos (tipo) VALUES ('Transporte');
INSERT INTO tipo_gastos (tipo) VALUES ('Carniceria');

/*Registro de gastos*/
INSERT INTO gastos (nombre,descripcion,cantidad,valor,fecha_gasto,tipo_id) VALUES('Luz','se pago la cuenta de la luz',1,13100,'2019-05-06',1);
INSERT INTO gastos (nombre,descripcion,cantidad,valor,fecha_gasto,tipo_id) VALUES('Agua','se pago la cuenta del agua',1,7900,'2019-05-06',1);
INSERT INTO gastos (nombre,descripcion,cantidad,valor,fecha_gasto,tipo_id) VALUES('Telefono','se pago la cuenta del telefono',1,36456,'2019-05-06',1);
INSERT INTO gastos (nombre,descripcion,cantidad,valor,fecha_gasto,tipo_id) VALUES('cemento','se compro 2 bolsas de cemento en la ferreteria gran fe',2,25000,'2019-05-06',2);
INSERT INTO gastos (nombre,descripcion,cantidad,valor,fecha_gasto,tipo_id) VALUES('Rueda de carretilla','se compro en los rios una rueda de la carretilla',1,12900,'2019-05-06',2);
INSERT INTO gastos (nombre,descripcion,cantidad,valor,fecha_gasto,tipo_id) VALUES('Viaje a los angeles','se compro dos pasajes a los angeles',2,2000,'2019-05-06',4);
INSERT INTO gastos (nombre,descripcion,cantidad,valor,fecha_gasto,tipo_id) VALUES('pasaje de tren','se viajo el lunes en tren a conce',2,6000,'2019-05-06',4);
INSERT INTO gastos (nombre,descripcion,cantidad,valor,fecha_gasto,tipo_id) VALUES('Viaje a Santiago','se viajo el martes en la noche a santiago y se volvio el miercoles',1,11100,'2019-05-06',4);
INSERT INTO gastos (nombre,descripcion,cantidad,valor,fecha_gasto,tipo_id) VALUES('aletilla','se compro aletilla en el unico',2,6590,'2019-05-06',3);
INSERT INTO gastos (nombre,descripcion,cantidad,valor,fecha_gasto,tipo_id) VALUES('Longaniza','se compro 2 tiras de longaniza en el unico',2,3000,'2019-05-06',3);
INSERT INTO gastos (nombre,descripcion,cantidad,valor,fecha_gasto,tipo_id) VALUES('Chuleta','se compro 2 kilos de chuleta en los chavez',2,5000,'2019-05-06',5);
INSERT INTO gastos (nombre,descripcion,cantidad,valor,fecha_gasto,tipo_id) VALUES('cazuela de vacuno','se compro un kilo de cazuela de vacuno en los chavez',1,2500,'2019-05-06',5);

/*Registro de notas*/
INSERT INTO notas (titulo,descripcion,fecha_creacion) VALUES('Viaje a Santiago','fui el lunes a santiago a una entrevista de trabajo','2020-02-05');