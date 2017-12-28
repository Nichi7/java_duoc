create table video.categoria(
	id int(11) not null primary key,
    descripcion varchar(50)

);


create table video.pelicula(
	codigo int not null primary key,
    precio int(11) null,
    categoria int(11) null,
    formato4k varchar(1) null,
    nombre varchar(50) null,
    FOREIGN KEY (categoria) references categoria(id)

);



insert into video.categoria(id,descripcion)
values(-1,'Seleccione'),(1,'Acción'),
(2,'Romance'),(3,'Terror'),(4,'Comedia')