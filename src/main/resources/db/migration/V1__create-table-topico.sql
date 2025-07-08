create table topicos(
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(300) not null,
    fechaCreacion varchar(12) not null,
    estado varchar(100) not null,
    autor varchar(100) not null,
    barrio varchar(100) not null,
    codigo_postal varchar(12) not null,
    complemento varchar(100),
    numero varchar(20),
    provincia varchar(100) not null,
    ciudad varchar(100) not null,

    primary key(id)

)