create table transmision (
	tr_id int primary key,
	tr_usuario varchar(20),
	tr_contenido int,
	tr_fechahora datetime,
	foreign key (tr_usuario) references usuario (usr_alias)
);
insert into transmision values (1,"lucky" , 1  , '2017-10-25 20:00:00' );
insert into transmision values (2,"lucky" , 4 , '2019-03-15 18:30:00');
insert into transmision values (3,"lucky" , 9 , '2019-05-20 20:30:00');
insert into transmision values (4,"malopez" , 1  , '2018-05-20 20:30:00');
insert into transmision values (5,"malopez" , 9 , '2020-01-20 20:30:00');
insert into transmision values (6,"diva" , 2 , '2019-05-20 20:30:00');
insert into transmision values (7,"diva" , 3 , '2018-06-22 21:30:00');
insert into transmision values (8,"diva" , 6 , '2020-03-17 15:30:20');
insert into transmision values (9,"dreamer" , 6 , '2020-03-17 15:30:20');
insert into transmision values (10,"dreamer" , 7 , '2020-04-10 18:30:20');
insert into transmision values (11,"ninja" , 8 , '2020-02-17 20:30:20');
insert into transmision values (12,"ninja" , 9 , '2020-02-20 16:30:20');
insert into transmision values (13,"ninja" , 11 , '2020-03-27 18:30:20');
insert into transmision values (14,"rose" , 10 , '2020-03-20 21:30:20');
insert into transmision values (15,"green" , 2 , '2020-01-10 17:30:20');
insert into transmision values (16,"green" , 4 ,  '2020-02-15 20:30:20');
insert into transmision values (17,"green" , 5 , '2020-03-17 18:30:20');