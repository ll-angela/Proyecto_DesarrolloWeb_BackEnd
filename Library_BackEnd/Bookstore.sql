drop table if exists book;
drop table if exists editorial;
drop table if exists user;

create table editorial (
    id int primary key auto_increment,
    name varchar(200) not null,
    web_site varchar(500)
);

insert into editorial
(id,    name,                           web_site) values
(1,     'Ballard & Tighe, Publishers',  'https://ballard-tighe.com/home/'),
(2,     'Bilingual Review Press',       'https://bilingualpress.clas.asu.edu/'),
(3,     'Ediciones Baquiana',           'https://baquiana.com/'),
(4,     'Unknown',                      null);

create table book (
    id int primary key auto_increment,
    name varchar(200) not null,
    description varchar(3000),
    image_url varchar(500),
    editorial_id int not null,
    amount int,
    edit_date varchar(45),
    foreign key (editorial_id) references editorial(id)
);

insert into book 
(id,    name,                    description,                                                                                                                                                                                                                           image_url, editorial_id, amount, edit_date) values
(1,     'El Siconalista',       'Frederick Starks, psicoanalista de larga experiencia y vida tranquila, recibe una amenaza anónima. Tendrá que emplear toda su astucia para averiguar quién es el autor de esa misiva que promete hacerle la existencia imposible.',    'https://images-na.ssl-images-amazon.com/images/I/41Zc7DRsnoL._SX327_BO1,204,203,200_.jpg', 1, 4, '11/03/2000'),
(2,     'Billy Summers',        'Novela sobre un buen tipo con un trabajo muy malo.',                                                                                                                                                                                   'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1618151020l/56852407.jpg', 1, 2, '23/11/1999'),
(3,     'Los Ilusionistas',     'Cuenta la historia de un golpe militar en Chile.',                                                                                                                                                                                     'https://images-na.ssl-images-amazon.com/images/I/61887EOsA0L.jpg', 2, 6, '02/12/2001'),
(4,     'Cien Años de Soledad', 'El único premio novel de literatura de Colombia.',                                                                                                                                                                                     'https://images.cdn2.buscalibre.com/fit-in/360x360/52/6b/526bb938f7613f31e3e42272df5463e1.jpg', 3, 5, '15/05/2002');

ALTER TABLE book AUTO_INCREMENT=1;

create table user (
	id int primary key auto_increment,
    name varchar(45),
    last_name varchar(45),
    birth_date varchar(45),
    position varchar(45),
    active boolean default true,
    username varchar(45),
    password varchar(45),
    token varchar(300)
);

insert into user
(id,    name, last_name, birth_date, position, active, username, password) values
(1,     'Maria',  'Perez', '02/09/1989', 'Administrador', true, 'mariap', '09876');