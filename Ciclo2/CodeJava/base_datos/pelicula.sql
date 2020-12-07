create table pelicula(
    peli_titulo varchar(50) primary key,
    peli_resumen varchar(250),
    peli_anno int,
    peli_director int,
    foreign key (peli_director) references director (dir_id)
);
insert into pelicula values ("Los Vengadores", "Pelicula de superheroes basada en Marvel Comics. Nick Fury director de SHIELD recluta a Tony Stark, Steve Rogers, Bruce Banner y Thor para forma un equipo y evitar que Loki, hermano de Thor, se apodere de la tierra.",1990, 102);
insert into pelicula values ("Interestelar","Pelicula de ciencia ficción, donde la humanidad lucha por sobrevivir. La pelicula cuenta una historia de un grupo de astronautas que viajan a traves de un agujero de gusano en busca de un nuevo hogar.",2014,103);
insert into pelicula values ("El viaje de Chihiro","Pelicula de animación japonesa. Es la historia de una niña de 12 años, quien se ve atrapada por un mundo mágico y sobrenatural, teniendo como misión buscar su libertad y la de sus padres y regresar al mundo real.",2001,101);
insert into pelicula values ("Parasitos","Pelicula de drama, suspenso y humor negro. Toca temas como las diferencias sociales y vulnerabilidad del espiritu humano",2019,104);
insert into pelicula values ("Mas alla de los sueños","Pelicula de drama, narra una historia trágica de una familia, donde el padre va en busca de sus esposa al mas allá para recuperarla.",1998,105);