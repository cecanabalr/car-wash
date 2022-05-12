create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table servicio (
  id int(11) not null auto_increment,
  nombre varchar(100) not null,
  valor int(11) not null,
  primary key (id)
);

create table agenda (
  id int(11) not null auto_increment,
  fecha_inicio datetime not null,
  fecha_fin datetime not null,
  fecha_creacion datetime not null,
  disponibilidad bit not null,
  primary key (id)
);

create table reserva (
  id int(11) not null auto_increment,
  nombre varchar(10) not null,
  placa varchar(10) not null,
  fecha_creacion datetime not null,
  total int(11) not null,
  id_servicio int(11) not null,
  id_agenda int(11) not null,
  primary key (id),
  foreign key (id_servicio) references servicio(id),
  foreign key (id_agenda) references agenda(id)
);
create table cantidad (
  id int(11) not null auto_increment,
  placa varchar(10) not null,
  cantidad int(11) not null,
  fecha_actualizacion datetime not null,
  primary key (id)
);
