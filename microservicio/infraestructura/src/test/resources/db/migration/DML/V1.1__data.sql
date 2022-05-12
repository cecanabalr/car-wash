insert into usuario(id, nombre,clave,fecha_creacion) values(1,'test','1234',now());
INSERT INTO servicio(id, nombre, valor) VALUES (1, 'lavado', 30000);
INSERT INTO agenda(id, fecha_inicio, fecha_fin, fecha_creacion, disponibilidad) VALUES (1, '2050-12-18 13:00:00','2050-12-18 13:00:00', now(), 1);
INSERT INTO reserva (id, nombre, placa, fecha_creacion, total, id_servicio, id_agenda) VALUES (1, 'carlos', 'ZXC123', now(), 30000, 1, 1);