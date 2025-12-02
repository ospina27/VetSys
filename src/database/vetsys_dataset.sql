CREATE DATABASE vetsys;

USE vetsys;


CREATE TABLE estado (
    id_estado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

INSERT INTO estado (nombre) VALUES ('Activo'), ('Inactivo');



CREATE TABLE rol (
    id_rol INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255)
);


INSERT INTO rol (nombre, descripcion) VALUES 
('Administrador', 'gestion total del sistema y usuarios'),
('Veterinario', 'atiende citas, gestion historial clinico'),
('Asistente', 'gestion de citas y clientes');


CREATE TABLE clinica (
    id_clinica INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    nit VARCHAR(20) NOT NULL,
    direccion VARCHAR(100),
    fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP,
    id_estado INT NOT NULL,
    FOREIGN KEY (id_estado) REFERENCES estado(id_estado)
);


INSERT INTO clinica (nombre, nit, direccion, fecha_registro, id_estado)
VALUES ('AnimalCare', '901234567', 'Carrera 10 #25', '2025-11-01', 1),



CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    id_clinica INT NOT NULL,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    documento VARCHAR(20) NOT NULL,
    telefono VARCHAR(20),
    correo VARCHAR(100),
    username VARCHAR(50) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    id_rol INT NOT NULL,
    id_estado INT NOT NULL,
    FOREIGN KEY (id_rol) REFERENCES rol(id_rol),
    FOREIGN KEY (id_clinica) REFERENCES clinica(id_clinica),
    FOREIGN KEY (id_estado) REFERENCES estado(id_estado)
);


INSERT INTO usuario (id_clinica, nombres, apellidos, documento, telefono, correo, username, contrasena, id_rol, id_estado)
VALUES
(1,'Laura','Gomez','10001','3001112233','laura@animalcare.com','adminVet','admin123',1,1),
(1,'Carlos','Ruiz','10002','3012223344','carlos@animalcare.com','vetCarlos','vet123',2,1),
(1,'María','López','10003','3009998877','maria@animalcare.com','vetMaria','vet123',2,1),
(1,'Andrés','Soto','10004','3018887766','andres@animalcare.com','auxAndres','aux123',3,1),
(1,'Luis Jose','Ramirez','10005','3018887766','joseluis@animalcare.com',vetLuis','vet123',2,1);



CREATE TABLE membresia (
    id_membresia INT AUTO_INCREMENT PRIMARY KEY,
    id_clinica INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    precio DECIMAL(10,2),
    descuento DECIMAL(5,2),
    duracion INT, -- meses
    FOREIGN KEY (id_clinica) REFERENCES clinica(id_clinica)
);

INSERT INTO membresia (id_clinica, nombre, descripcion, precio, descuento, duracion)
VALUES 
(1, 'Basica', 'Descuento del 5% en servicios', 100000, 5, 12),
(1,'Intermedia','Descuento del 10% en consultas',150000.00,10.00,12),
(1,'Gold','Descuento del 20% y revisión semestral gratuita',300000.00,20.00,12),
(1, 'Premium', 'Incluye vacunación anual gratuita', 250000, 15, 12),



CREATE TABLE cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    id_clinica INT NOT NULL,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    documento VARCHAR(20) NOT NULL,
    telefono VARCHAR(20),
    correo VARCHAR(100),
    direccion VARCHAR(100),
    id_membresia INT,
    fecha_inicio DATE,
    fecha_vigencia DATE,
    id_estado_membresia INT NOT NULL,
    FOREIGN KEY (id_membresia) REFERENCES membresia(id_membresia),
    FOREIGN KEY (id_clinica) REFERENCES clinica(id_clinica),
    FOREIGN KEY (id_estado_membresia) REFERENCES estado(id_estado)
);


INSERT INTO cliente (id_clinica, nombres, apellidos, documento, telefono, correo, direccion, id_membresia, fecha_inicio, fecha_vigencia, id_estado_membresia)
VALUES 
(1,'Alejandro','Ospina','1010129136','3106409524','ospinalopez2705@gmail.com','Progresar cra 18 Tuluá, Valle del Cauca',1,'2025-11-27','2026-11-27',1),
(1, 'Camila', 'Martinez', '1020001111', '3101230001', 'camila.martinez@example.com', 'Calle 1 #10', 2, '2025-10-05', '2026-10-05', 1),
(1, 'Diego', 'Fernandez', '1020002222', '3101230002', 'diego.fernandez@example.com', 'Calle 2 #20', 1, '2025-10-08', '2026-10-08', 1),
(1, 'Sofía', 'Ramirez', '1020003333', '3101230003', 'sofia.ramirez@example.com', 'Calle 3 #30', NULL,NULL,NULL, 1),
(1, 'Mateo', 'Gonzalez', '1020004444', '3101230004', 'mateo.gonzalez@example.com', 'Calle 4 #40', 1, '2025-10-18', '2026-10-18', 1),
(1, 'Valentina', 'Lopez', '1020005555', '3101230005', 'valentina.lopez@example.com', 'Calle 5 #50', 4, '2025-11-02', '2026-11-02', 1),
(1, 'Andrés', 'Martínez', '1020006666', '3101230006', 'andres.martinez@example.com', 'Calle 6 #60', 2, '2025-11-06', '2026-11-06', 1),
(1, 'Paula', 'Torres', '1020007777', '3101230007', 'paula.torres@example.com', 'Calle 7 #70', 1, '2025-11-10', '2026-11-10', 1),
(1, 'Juan', 'Castro', '1020008888', '3101230008', 'juan.castro@example.com', 'Calle 8 #80', NULL,NULL,NULL, 1),
(1, 'Laura', 'Vargas', '1020009999', '3101230009', 'laura.vargas@example.com', 'Calle 9 #90', 1, '2025-11-20', '2026-11-20', 1),
(1, 'Ricardo', 'Paredes', '1020010000', '3101230010', 'ricardo.paredes@example.com', 'Calle 10 #100', NULL,NULL,NULL, 1),
(1, 'Natalia', 'Suarez', '1020011111', '3101230011', 'natalia.suarez@example.com', 'Calle 11 #110', 2, NULL,NULL,NULL, 1),
(1, 'Camilo', 'Herrera', '1020012222', '3101230012', 'camilo.herrera@example.com', 'Calle 12 #120', 3, '2025-11-01', '2026-11-01', 1),
(1, 'Marcela', 'Ruano', '1020013333', '3101230013', 'marcela.ruano@example.com', 'Calle 13 #130', 4, '2025-10-30', '2026-10-30', 1),
(1, 'Fernando', 'Rios', '1020014444', '3101230014', 'fernando.rios@example.com', 'Calle 14 #140', NULL,NULL,NULL, 1);



CREATE TABLE mascota (
    id_mascota INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    id_clinica INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    especie VARCHAR(50) NOT NULL,
    raza VARCHAR(50),
    color VARCHAR(50),
    sexo ENUM('macho', 'hembra') NOT NULL,
    fecha_nacimiento DATE,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
    FOREIGN KEY (id_clinica) REFERENCES clinica(id_clinica)
);


INSERT INTO mascota (id_cliente, id_clinica, nombre, especie, raza, color, sexo, fecha_nacimiento)
VALUES 
-- Cliente 1: Alejandro Ospina
(1,1,'Mateo','Canino','Pastor Alemán','negro','macho','2022-06-08'),
(1, 1, 'Max', 'Canino', 'Pastor Alemán', 'negro', 'macho', '2022-06-08'),
(1, 1, 'Luna', 'Felino', 'Siamés', 'crema', 'hembra', '2023-01-14'),
-- Cliente 2: Camila Martínez
(2, 1, 'Rocky', 'Canino', 'Beagle', 'tricolor', 'macho', '2021-09-20'),
(2, 1, 'Misu', 'Felino', 'Persa', 'blanco', 'hembra', '2022-04-12'),
-- Cliente 3: Diego Fernandez
(3, 1, 'Toby', 'Canino', 'Labrador Retriever', 'amarillo', 'macho', '2020-11-10'),
-- Cliente 4: Sofía Ramírez
(4, 1, 'Nala', 'Felino', 'Maine Coon', 'gris', 'hembra', '2023-02-02'),
(4, 1, 'Simba', 'Felino', 'Bengalí', 'atigrado', 'macho', '2022-09-18'),
-- Cliente 5: Mateo Gonzalez
(5, 1, 'Bruno', 'Canino', 'Pitbull', 'café', 'macho', '2021-07-07'),
-- Cliente 6: Valentina Lopez
(6, 1, 'Kira', 'Canino', 'Golden Retriever', 'dorado', 'hembra', '2020-05-25'),
(6, 1, 'Tom', 'Felino', 'Azul ruso', 'gris', 'macho', '2021-03-03'),
-- Cliente 7: Andrés Martínez
(7, 1, 'Dante', 'Canino', 'Rottweiler', 'negro y fuego', 'macho', '2022-10-10'),
-- Cliente 8: Paula Torres
(8, 1, 'Chispas', 'Canino', 'Pug', 'beige', 'macho', '2023-04-08'),
(8, 1, 'Pelusa', 'Felino', 'Angora turco', 'blanco', 'hembra', '2022-06-21'),
-- Cliente 9: Juan Castro
(9, 1, 'Zeus', 'Canino', 'Bulldog Francés', 'gris', 'macho', '2021-12-12'),
-- Cliente 10: Laura Vargas
(10, 1, 'Molly', 'Felino', 'Siberiano', 'gris claro', 'hembra', '2023-03-10'),
-- Cliente 11: Ricardo Paredes
(11, 1, 'Apolo', 'Canino', 'Cocker Spaniel', 'dorado', 'macho', '2020-08-19'),
(11, 1, 'Kiwi', 'Felino', 'Persa', 'blanco', 'hembra', '2021-11-01'),
-- Cliente 12: Natalia Suarez
(12, 1, 'Nico', 'Canino', 'Chihuahua', 'crema', 'macho', '2022-08-22'),
-- Cliente 13: Camilo Herrera
(13, 1, 'Sol', 'Felino', 'Siamés', 'crema', 'hembra', '2021-02-15'),
-- Cliente 14: Marcela Ruano
(14, 1, 'Iron', 'Canino', 'Pitbull', 'negro', 'macho', '2020-03-28'),
(14, 1, 'Cleo', 'Felino', 'Angora turco', 'blanco', 'hembra', '2021-07-17'),
(14, 1, 'Nieve', 'Felino', 'Persa', 'gris', 'hembra', '2023-01-01'),
-- Cliente 15: Fernando Rios
(15, 1, 'Sasha', 'Canino', 'Golden Retriever', 'dorado', 'hembra', '2019-12-10'),
(15, 1, 'Tiger', 'Felino', 'Siberiano', 'atigrado', 'macho', '2022-09-09');




CREATE TABLE cita (
    id_cita INT AUTO_INCREMENT PRIMARY KEY,
    id_clinica INT NOT NULL,
    id_cliente INT NOT NULL,
    id_mascota INT NOT NULL,
    id_veterinario INT NOT NULL,
    fecha_cita DATETIME NOT NULL,
    estado ENUM('programada', 'realizada', 'cancelada') DEFAULT 'programada',
    FOREIGN KEY (id_clinica) REFERENCES clinica(id_clinica),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
    FOREIGN KEY (id_mascota) REFERENCES mascota(id_mascota),
    FOREIGN KEY (id_veterinario) REFERENCES usuario(id_usuario)
);


INSERT INTO cita (id_clinica, id_cliente, id_mascota, id_veterinario, fecha_cita, estado) VALUES
-- OCTUBRE 2025 (15 citas: ~11 realizadas, 4 canceladas)
(1,1,1,2,'2025-10-05 09:00:00','realizada'),   -- mascota 1 (Mateo) -> cliente 1
(1,1,2,3,'2025-10-06 10:00:00','realizada'),   -- mascota 2 (Max) -> cliente 1
(1,1,3,5,'2025-10-06 14:00:00','cancelada'),   -- mascota 3 (Luna) -> cliente 1
(1,2,4,2,'2025-10-08 08:00:00','realizada'),   -- mascota 4 (Rocky) -> cliente 2
(1,2,5,3,'2025-10-09 11:00:00','realizada'),   -- mascota 5 (Misu) -> cliente 2
(1,3,6,5,'2025-10-12 15:00:00','realizada'),   -- mascota 6 (Toby) -> cliente 3
(1,4,7,2,'2025-10-14 10:00:00','cancelada'),   -- mascota 7 (Nala) -> cliente 4
(1,4,8,3,'2025-10-15 09:00:00','realizada'),   -- mascota 8 (Simba) -> cliente 4
(1,5,9,5,'2025-10-18 16:00:00','realizada'),   -- mascota 9 (Bruno) -> cliente 5
(1,6,10,2,'2025-10-20 14:00:00','realizada'),  -- mascota 10 (Kira) -> cliente 6
(1,6,11,3,'2025-10-22 08:00:00','cancelada'),  -- mascota 11 (Tom) -> cliente 6
(1,7,12,5,'2025-10-23 09:00:00','realizada'),  -- mascota 12 (Dante) -> cliente 7
(1,8,13,2,'2025-10-25 11:00:00','realizada'),  -- mascota 13 (Chispas) -> cliente 8
(1,8,14,3,'2025-10-26 10:00:00','realizada'),  -- mascota 14 (Pelusa) -> cliente 8
(1,9,15,5,'2025-10-28 15:00:00','cancelada'),  -- mascota 15 (Zeus) -> cliente 9

-- NOVIEMBRE 2025 (15 citas: ~11 realizadas, 4 canceladas)
(1,10,16,2,'2025-11-02 09:00:00','realizada'),  -- mascota 16 (Molly) -> cliente 10
(1,11,17,3,'2025-11-04 10:00:00','realizada'),  -- mascota 17 (Apolo) -> cliente 11
(1,11,18,5,'2025-11-05 08:00:00','cancelada'),  -- mascota 18 (Kiwi) -> cliente 11
(1,12,19,2,'2025-11-07 14:00:00','realizada'),  -- mascota 19 (Nico) -> cliente 12
(1,13,20,3,'2025-11-08 11:00:00','realizada'),  -- mascota 20 (Sol) -> cliente 13
(1,14,21,5,'2025-11-10 15:00:00','realizada'),  -- mascota 21 (Iron) -> client 14
(1,14,22,2,'2025-11-12 10:00:00','realizada'),  -- mascota 22 (Cleo) -> client 14
(1,14,23,3,'2025-11-13 09:00:00','cancelada'),  -- mascota 23 (Nieve) -> client 14
(1,15,24,5,'2025-11-15 16:00:00','realizada'),  -- mascota 24 (Sasha) -> client 15
(1,15,25,2,'2025-11-17 08:00:00','realizada'),  -- mascota 25 (Tiger) -> client 15
(1,1,1,3,'2025-11-18 14:00:00','realizada'),    -- mascota 1 (Mateo) additional consult
(1,2,4,5,'2025-11-20 11:00:00','cancelada'),    -- mascota 4 (Rocky) -> client 2
(1,3,6,2,'2025-11-21 09:00:00','realizada'),    -- mascota 6 (Toby) -> client 3
(1,4,8,3,'2025-11-22 10:00:00','realizada'),    -- mascota 8 (Simba) -> client 4
(1,5,9,5,'2025-11-25 15:00:00','realizada'),    -- mascota 9 (Bruno) -> client 5

-- DICIEMBRE 2025 (15 citas: 80% programadas, 20% canceladas) (fechas >= 2025-12-03)
(1,6,10,2,'2025-12-03 08:00:00','programada'),  -- mascota 10 (Kira) -> client 6
(1,6,11,3,'2025-12-04 09:00:00','programada'),  -- mascota 11 (Tom) -> client 6
(1,7,12,5,'2025-12-04 10:00:00','programada'),  -- mascota 12 (Dante) -> client 7
(1,8,13,2,'2025-12-05 11:00:00','programada'),  -- mascota 13 (Chispas) -> client 8
(1,8,14,3,'2025-12-06 14:00:00','cancelada'),   -- mascota 14 (Pelusa) -> client 8
(1,9,15,5,'2025-12-07 15:00:00','programada'),  -- mascota 15 (Zeus) -> client 9
(1,10,16,2,'2025-12-08 16:00:00','programada'), -- mascota 16 (Molly) -> client 10
(1,11,17,3,'2025-12-09 08:00:00','programada'), -- mascota 17 (Apolo) -> client 11
(1,11,18,5,'2025-12-10 09:00:00','programada'), -- mascota 18 (Kiwi) -> client 11
(1,12,19,2,'2025-12-11 10:00:00','programada'), -- mascota 19 (Nico) -> client 12
(1,13,20,3,'2025-12-12 11:00:00','programada'), -- mascota 20 (Sol) -> client 13
(1,14,21,5,'2025-12-15 14:00:00','programada'), -- mascota 21 (Iron) -> client 14
(1,14,22,2,'2025-12-16 15:00:00','cancelada'),  -- mascota 22 (Cleo) -> client 14
(1,14,23,3,'2025-12-18 16:00:00','programada'), -- mascota 23 (Nieve) -> client 14
(1,15,24,5,'2025-12-19 09:00:00','programada'); -- mascota 24 (Sasha) -> client 15



CREATE TABLE historial_clinico (
    id_historia INT AUTO_INCREMENT PRIMARY KEY,
    id_clinica INT NOT NULL,
    id_mascota INT NOT NULL,
    id_veterinario INT NOT NULL,
    id_cita INT NOT NULL,
    fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP,
    motivo_consulta VARCHAR(255),
    diagnostico TEXT,
    tratamiento TEXT,
    peso DECIMAL(5,2),
    FOREIGN KEY (id_clinica) REFERENCES clinica(id_clinica),
    FOREIGN KEY (id_mascota) REFERENCES mascota(id_mascota),
    FOREIGN KEY (id_veterinario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_cita) REFERENCES cita(id_cita)
);


INSERT INTO historial_clinico 
(id_clinica, id_mascota, id_veterinario, id_cita, fecha_registro, motivo_consulta, diagnostico, tratamiento, peso) VALUES

-- OCTUBRE (11 realizadas)
(1,1,2,3,'2025-10-05 09:00:00','Control general','Mascota en buen estado, sin hallazgos relevantes','Continuar cuidados habituales',28.5),
(1,2,3,4,'2025-10-06 10:10:00','Revisión por caída','Leve contusión en miembro anterior derecho','Reposo y antiinflamatorio por 3 días',30.1),
(1,4,2,6,'2025-10-08 08:00:00','Consulta por vómito','Gastritis leve por alimento en mal estado','Omeprazol 1 semana y dieta blanda',12.4),
(1,5,3,7,'2025-10-09 11:10:00','Ojos llorosos','Conjuntivitis alérgica','Lágrimas artificiales y limpieza diaria',4.2),
(1,6,5,8,'2025-10-12 15:20:00','Chequeo anual','Salud óptima, vacunación al día','Refuerzo de vacunas aplicado',32.8),
(1,8,3,10,'2025-10-15 09:30:00','Pelo opaco','Dermatitis leve','Shampoo medicado 2 veces por semana',6.9),
(1,9,5,11,'2025-10-18 16:12:00','Dolor en extremidad posterior','Esguince leve','Antiinflamatorio 5 días y reposo',21.3),
(1,10,2,12,'2025-10-20 14:33:00','Falta de apetito','Indigestión leve','Procinético por 3 días',29.7),
(1,12,5,14,'2025-10-23 09:20:00','Control general','Mascota en excelente condición','Sin tratamiento necesario',40.2),
(1,13,2,15,'2025-10-25 11:02:00','Caída del pelo','Dermatitis por pulgas','Antipulgas + shampoo medicado',7.1),
(1,14,3,16,'2025-10-26 10:12:00','Revisión respiratoria','Resfriado leve','Antibiótico 5 días',4.9),

-- NOVIEMBRE (12 realizadas)
(1,16,2,18,'2025-11-02 09:18:00','Chequeo anual','Examen físico normal','Vacunas aplicadas',5.4),
(1,17,3,19,'2025-11-04 10:31:00','Orejas inflamadas','Otitis externa','Limpieza y gotas óticas por 7 días',14.1),
(1,19,2,21,'2025-11-07 14:01:00','Diarrea','Colitis leve','Dieta blanda + probióticos 5 días',3.3),
(1,20,3,22,'2025-11-08 11:00:00','Inquietud y maullido constante','Celo activo','Observación y control',4.0),
(1,21,5,23,'2025-11-10 15:01:00','Cojeo esporádico','Artrosis temprana','Condroprotectores diarios',22.2),
(1,22,2,24,'2025-11-12 10:09:00','Ojo rojo','Conjuntivitis infecciosa','Antibiótico oftálmico 7 días',3.6),
(1,24,5,26,'2025-11-15 16:00:00','Chequeo de rutina','Sin hallazgos relevantes','Recomendaciones generales',27.8),
(1,25,2,27,'2025-11-17 08:08:00','Herida pequeña','Corte superficial','Limpieza y crema antibiótica',6.2),
(1,1,3,28,'2025-11-18 14:16:00','Seguimiento post consulta','Recuperación satisfactoria','Completar tratamiento',28.7),
(1,6,2,30,'2025-11-21 09:00:00','Dolor abdominal','Indigestión por cambio de dieta','Dieta suave + protector gástrico',32.5),
(1,8,3,31,'2025-11-22 10:00:00','Pérdida de peso','Parásitos intestinales','Desparasitación completa',6.7),
(1,9,5,32,'2025-11-25 15:30:00','Aumento de sed','Posible inicio de diabetes','Exámenes solicitados',21.0);




