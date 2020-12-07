-- 4. Código SQL para Modificar  los siguientes datos:
USE redflix;
UPDATE pelicula
SET año = 2012
WHERE titulo = "Los Vengadores";
UPDATE usuario
SET celular = (3115678432)
WHERE "alias" = "ninja";
DELETE
FROM transmision
WHERE Usuario_idUsuario = 8;
SELECT * FROM Usuario;
