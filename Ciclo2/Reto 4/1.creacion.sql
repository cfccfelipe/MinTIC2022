-- Reto 4 creando BD REDFLIX 
CREATE SCHEMA IF NOT EXISTS `redflix` DEFAULT CHARACTER SET utf8 ;
USE `redflix` ;
-- 3 Código SQL para generar tablas e inserción de datos:
-- -----------------------------------------------------
-- Table `redflix`.`Director`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `redflix`.`Director` (
  `idDirector` INT NOT NULL,
  `nombre` VARCHAR(100) NOT NULL,
  `apeliido` VARCHAR(100) NOT NULL,
  `nacionalidad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDirector`)
  );
INSERT INTO Director VALUES (101, "Hayo","Miyazaki", "japones");
INSERT INTO Director VALUES (102, "Joss", "Whedon", "estadounidense");
INSERT INTO Director VALUES (103, "Christopher", "Nolan", "estadounidense");
INSERT INTO Director VALUES (104, "Bong", "Joon-ho", "coreano");
INSERT INTO Director VALUES (105, "Vincent", "Ward", "neozelandes");
-- -----------------------------------------------------
-- Table `redflix`.`Pelicula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `redflix`.`Pelicula` (
  `idPelicula` INT NOT NULL,
  `titulo` VARCHAR(100) NOT NULL,
  `resumen` VARCHAR(255) NOT NULL,
  `año` INT(4) NOT NULL,
  `Director_idDirector` INT NOT NULL,
  PRIMARY KEY (`idPelicula`),
  INDEX `fk_Pelicula_Director_idx` (`Director_idDirector` ASC) VISIBLE,
  CONSTRAINT `fk_Pelicula_Director`
    FOREIGN KEY (`Director_idDirector`)
    REFERENCES `redflix`.`Director` (`idDirector`)
);
INSERT INTO Pelicula (idPelicula, titulo, resumen, año, Director_idDirector) VALUES (201,"Los Vengadores", "Pelicula de superheroes basada en Marvel Comics. Nick Fury director de SHIELD recluta a Tony Stark, Steve Rogers, Bruce Banner y Thor para forma un equipo y evitar que Loki, hermano de Thor, se apodere de la tierra.",1990, 102);
INSERT INTO Pelicula (idPelicula, titulo, resumen, año, Director_idDirector) VALUES (202, "Interestelar", "Pelicula de ciencia ficción, donde la humanidad lucha por sobrevivir. La pelicula cuenta una historia de un grupo de astronautas que viajan a traves de un agujero de gusano en busca de un nuevo hogar.",2014, 103);
INSERT INTO Pelicula (idPelicula, titulo, resumen, año, Director_idDirector) VALUES (203, "El viaje de Chihiro", "Pelicula de animación japonesa. Es la historia de una niña de 12 años, quien se ve atrapada por un mundo mágico y sobrenatural, teniendo como misión buscar su libertad y la de sus padres y regresar al mundo real.", 2001, 101);
INSERT INTO Pelicula (idPelicula, titulo, resumen, año, Director_idDirector) VALUES (204, "Parasitos", "Pelicula de drama, suspenso y humor negro. Toca temas como las diferencias sociales y vulnerabilidad del espiritu humano.", 2019, 104);
INSERT INTO Pelicula (idPelicula, titulo, resumen, año, Director_idDirector) VALUES (205, "Mas alla de los sueños", "Pelicula de drama, narra una historia trágica de una familia, donde el padre va en busca de sus esposa al mas allá para recuperarla.", 1998, 105);
-- -----------------------------------------------------
-- Table `redflix`.`Serie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `redflix`.`Serie` (
  `idSerie` INT NOT NULL,
  `titulo` VARCHAR(100) NOT NULL,
  `numeroTemporadas` INT(2) NULL,
  `numeroEpisodios` INT(4) NULL,
  PRIMARY KEY (`idSerie`)
  );
INSERT INTO Serie (idSerie, titulo, numeroTemporadas,numeroEpisodios) VALUES (301, "The walking dead", 153, 11);
INSERT INTO Serie (idSerie, titulo, numeroTemporadas,numeroEpisodios) VALUES (302, "Viaje a las estrellas: la serie original", 80, 3);
INSERT INTO Serie (idSerie, titulo, numeroTemporadas,numeroEpisodios) VALUES (303, "Glow", 30, 3);
INSERT INTO Serie (idSerie, titulo, numeroTemporadas,numeroEpisodios) VALUES (304, "La casa de papel", 31, 4);
INSERT INTO Serie (idSerie, titulo, numeroTemporadas,numeroEpisodios) VALUES (305, "Friends", 236, 10);
INSERT INTO Serie (idSerie, titulo, numeroTemporadas,numeroEpisodios) VALUES (306, "Arrow", 170, 8);
INSERT INTO Serie (idSerie, titulo, numeroTemporadas,numeroEpisodios) VALUES (307, "The big bang theory", 279, 12);
INSERT INTO Serie (idSerie, titulo, numeroTemporadas,numeroEpisodios) VALUES (308, "Vikingos", 79, 6);
-- -----------------------------------------------------
-- Table `redflix`.`Contenido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `redflix`.`Contenido` (
  `idcontenido` INT NOT NULL,
  `Pelicula_idPelicula` INT,
  `Serie_idSerie` INT,
  PRIMARY KEY (`idcontenido`),
  INDEX `fk_Contenido_Pelicula1_idx` (`Pelicula_idPelicula` ASC) VISIBLE,
  INDEX `fk_Contenido_Serie1_idx` (`Serie_idSerie` ASC) VISIBLE,
  CONSTRAINT `fk_Contenido_Pelicula1`
    FOREIGN KEY (`Pelicula_idPelicula`)
    REFERENCES `redflix`.`Pelicula` (`idPelicula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Contenido_Serie1`
    FOREIGN KEY (`Serie_idSerie`)
    REFERENCES `redflix`.`Serie` (`idSerie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    );
INSERT INTO Contenido (idcontenido, Pelicula_idPelicula) VALUES (1000, 201);
INSERT INTO Contenido (idcontenido, Pelicula_idPelicula) VALUES (1001, 202);
INSERT INTO Contenido (idcontenido, Pelicula_idPelicula) VALUES (1002, 203);
INSERT INTO Contenido (idcontenido, Pelicula_idPelicula) VALUES (1003, 204);
INSERT INTO Contenido (idcontenido, Pelicula_idPelicula) VALUES (1004, 205);
INSERT INTO Contenido (idcontenido, Serie_idSerie) VALUES (1005, 301);
INSERT INTO Contenido (idcontenido, Serie_idSerie) VALUES (1006, 302);
INSERT INTO Contenido (idcontenido, Serie_idSerie) VALUES (1007, 303);
INSERT INTO Contenido (idcontenido, Serie_idSerie) VALUES (1008, 304);
INSERT INTO Contenido (idcontenido, Serie_idSerie) VALUES (1009, 305);
INSERT INTO Contenido (idcontenido, Serie_idSerie) VALUES (1010, 306);
INSERT INTO Contenido (idcontenido, Serie_idSerie) VALUES (1011, 307);
INSERT INTO Contenido (idcontenido, Serie_idSerie) VALUES (1012, 308);
-- -----------------------------------------------------
-- Table `redflix`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `redflix`.`Usuario` (
  `idUsuario` INT NOT NULL,
  `nombre` VARCHAR(100) NOT NULL,
  `apellido` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `celular` INT(20) NOT NULL,
  `alias` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(100) NOT NULL,
  `fechaNacimiento` DATE NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `alias_UNIQUE` (`alias` ASC) VISIBLE
  );
INSERT INTO Usuario VALUES (1, "Pedro", "Perez", "pedroperez@gmail.com", 301000000, "lucky", "lucky1", "1990-10-15");
INSERT INTO Usuario VALUES (2, "Maria", "Lopez", "marialopez@gmail.com", 301000001, "malopez", "lucky1", "1990-10-15");
INSERT INTO Usuario VALUES (3, "Ana", "Diaz", "anadiaz@gmail.com", 301000002, "diva", "lucky1", "1990-10-15");
INSERT INTO Usuario VALUES (4, "Luis", "Rojas", "luisrojas@gmail.com", 301000003, "dreamer", "lucky1", "1990-10-15");
INSERT INTO Usuario VALUES (5, "Andres", "Cruz", "andrescruz@gmail.com", 301000004, "ninja", "lucky1", "1990-10-15");
INSERT INTO Usuario VALUES (6, "Nelson", "Ruiz", "nelsonruiz@gmail.com", 301000005, "neon", "lucky1", "1990-10-15");
INSERT INTO Usuario VALUES (7, "Claudia", "Mendez", "claudiamendez@gmail.com", 301000006, "rose", "lucky1", "1990-10-15");
INSERT INTO Usuario VALUES (8, "Jorge", "Rodriguez", "jorgerodriguez@gmail.com", 301000007, "green", "lucky1", "1990-10-15");
-- -----------------------------------------------------
-- Table `redflix`.`Transmision`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `redflix`.`Transmision` (
  `idTransmision` INT NOT NULL AUTO_INCREMENT,
  `Usuario_idUsuario` INT NOT NULL,
  `Contenido_idcontenido` INT NOT NULL,
  `fechaTransmision` DATETIME NOT NULL,
  PRIMARY KEY (`idTransmision`),
  INDEX `fk_Transmision_Usuario1_idx` (`Usuario_idUsuario` ASC) VISIBLE,
  INDEX `fk_Transmision_Contenido1_idx` (`Contenido_idcontenido` ASC) VISIBLE,
  CONSTRAINT `fk_Transmision_Usuario1`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `redflix`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Transmision_Contenido1`
    FOREIGN KEY (`Contenido_idcontenido`)
    REFERENCES `redflix`.`Contenido` (`idcontenido`)
    );
INSERT INTO Transmision (Usuario_idUsuario, Contenido_idcontenido, fechaTransmision) VALUES (1,1000,"2017-10-25 20:00:00");
INSERT INTO Transmision (Usuario_idUsuario, Contenido_idcontenido, fechaTransmision) VALUES (1,1003,"2019-03-15 18:30:00");
INSERT INTO Transmision (Usuario_idUsuario, Contenido_idcontenido, fechaTransmision) VALUES (1,1008,"2019-05-20 20:30:00");
INSERT INTO Transmision (Usuario_idUsuario, Contenido_idcontenido, fechaTransmision) VALUES (2,1000,"2018-05-20 20:30:00");
INSERT INTO Transmision (Usuario_idUsuario, Contenido_idcontenido, fechaTransmision) VALUES (2,1008,"2020-01-20 20:30:00");
INSERT INTO Transmision (Usuario_idUsuario, Contenido_idcontenido, fechaTransmision) VALUES (3,1001,"2019-05-20 20:30:00");
INSERT INTO Transmision (Usuario_idUsuario, Contenido_idcontenido, fechaTransmision) VALUES (3, 1002,"2018-06-22 21:30:00");
INSERT INTO Transmision (Usuario_idUsuario, Contenido_idcontenido, fechaTransmision) VALUES (3,1005,"2020-03-17 15:30:20");
INSERT INTO Transmision (Usuario_idUsuario, Contenido_idcontenido, fechaTransmision) VALUES (4,1005,"2020-03-17 15:30:20");
INSERT INTO Transmision (Usuario_idUsuario, Contenido_idcontenido, fechaTransmision) VALUES (4,1006,"2020-04-10 18:30:20");
INSERT INTO Transmision (Usuario_idUsuario, Contenido_idcontenido, fechaTransmision) VALUES (5,1007, "2020-02-17 20:30:20");
INSERT INTO Transmision (Usuario_idUsuario, Contenido_idcontenido, fechaTransmision) VALUES (5,1008, "2020-02-20 16:30:20");
INSERT INTO Transmision (Usuario_idUsuario, Contenido_idcontenido, fechaTransmision) VALUES (5,1010, "2020-03-27 18:30:20");
INSERT INTO Transmision (Usuario_idUsuario, Contenido_idcontenido, fechaTransmision) VALUES (7,1009, "2020-03-20 21:30:20");
INSERT INTO Transmision (Usuario_idUsuario, Contenido_idcontenido, fechaTransmision) VALUES (8,1001, "2020-01-10 17:30:20");
INSERT INTO Transmision (Usuario_idUsuario, Contenido_idcontenido, fechaTransmision) VALUES (8,1003, "2020-02-15 20:30:20");
INSERT INTO Transmision (Usuario_idUsuario, Contenido_idcontenido, fechaTransmision) VALUES (8,1004, "2020-03-17 18:30:20");
