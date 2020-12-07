USE redflix;
-- 5.1 Mostrar la información del título de todas las películas y series ordenadas alfabéticamente.
SELECT distinct pelicula.titulo AS Datos FROM pelicula 
UNION
SELECT distinct serie.titulo AS Datos FROM serie
ORDER BY datos;
-- 5.2 Mostrar la información de las películas (título, resumen, año) que se han estrenado posteriormente al año 2000, ordenadas por título
SELECT * FROM pelicula
WHERE año > 2000;
-- 5.3 Mostrar los títulos de películas dirigidas por el director Vincent Ward 
SELECT titulo FROM pelicula
WHERE Director_idDirector = (
	SELECT idDirector FROM director
    WHERE nombre = "Vincent"
    AND apeliido ="Ward"
    );
-- 5.4 Mostrar la información de las series y películas ( solo los títulos) que ha visto un usuario con alias "lucky", ordenadas por título
SELECT distinct pelicula.titulo AS Datos FROM pelicula 
WHERE idPelicula IN (
	SELECT DISTINCT Pelicula_idPelicula FROM contenido
    WHERE idcontenido IN (
		SELECT Contenido_idcontenido from transmision
        WHERE Usuario_idUsuario = (
			SELECT idUsuario from usuario
            WHERE alias = "lucky")
            )
            )
UNION
SELECT distinct serie.titulo AS Datos FROM serie
WHERE idSerie IN (
	SELECT DISTINCT Serie_idSerie FROM contenido
    WHERE idcontenido IN (
		SELECT Contenido_idcontenido from transmision
        WHERE Usuario_idUsuario = (
			SELECT idUsuario from usuario
            WHERE alias = "lucky")
            )
            )
ORDER BY datos; 
-- 5.5 Mostrar la información de los usuarios (alias y nombre y apellidos) que han visto la película "Interestelar" ordenados alfabéticamente
SELECT alias, nombre, apellido FROM Usuario
WHERE idUsuario IN (
	SELECT Usuario_idUsuario FROM Transmision
    WHERE Contenido_idcontenido IN (
		SELECT idcontenido FROM Contenido
        WHERE Pelicula_idPelicula = (
			SELECT idPelicula from Pelicula
            WHERE titulo = "Interestelar")
            )
		)
-- 5.6 Mostrar cuantas películas se han estrenado después del año 2000
SELECT COUNT(*) FROM pelicula
WHERE año > 2000;