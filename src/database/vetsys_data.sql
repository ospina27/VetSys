#Usar la base de datos del servidor
use railway;

#Agregar estados
INSERT INTO estado (nombre) VALUES ('Activo'), ('Inactivo');

#Agregar rol
INSERT INTO rol (nombre, descripcion) VALUES 
('Administrador', 'gestion total del sistema y usuarios'),
('Veterinario', 'atiende citas, gestion historial clinico'),
('Asistente', 'gestion de citas, clientes, facturacion');

#Agregar clinicas
INSERT INTO clinica (nombre, nit, direccion, fecha_registro, id_estado)
VALUES ('AnimalCare', '901234567', 'Carrera 10 #25', '2025-11-01', 1),
('CatDog', '902345678-2', 'Calle 10 #123', '2025-10-15', 1);

#Agregar lo usurios iniciales
INSERT INTO usuario (id_clinica, nombres, apellidos, documento, telefono, correo, username, contrasena, id_rol, id_estado)
VALUES 
(1, 'Laura', 'Gomez', '10203040', '3001112233', 'laura@animalcare.com', 'adminVet', '12345', 1, 1),
(1, 'Carlos', 'Ruiz', '10987654', '3012223344', 'carlos@animalcare.com', 'vetCarlos', 'abc123', 2, 1),
(2, 'María', 'López', '10304050', '3009998877', 'maria@catdog.com', 'admin', 'admin123', 1, 1),
(2, 'Andrés', 'Soto', '11223344', '3018887766', 'andres@catdog.com', 'auxAndres', 'auxpass', 3, 1);

INSERT INTO usuario (id_clinica, nombres, apellidos, documento, telefono, correo, username, contrasena, id_rol, id_estado)
VALUES 
(1, 'Alejandro', 'Ospina', '1010129136', '3106409524', 'alejo@animalcare.com', 'alejoVet', '12345', 1, 1);

#Agregar clientes

INSERT INTO cliente (id_clinica, nombres, apellidos, documento, telefono, correo, direccion, id_membresia, fecha_inicio, fecha_vigencia, id_estado_membresia)
VALUES 
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
(1, 'Natalia', 'Suarez', '1020011111', '3101230011', 'natalia.suarez@example.com', 'Calle 11 #110', NULL,NULL,NULL, 1),
(1, 'Camilo', 'Herrera', '1020012222', '3101230012', 'camilo.herrera@example.com', 'Calle 12 #120', 3, '2025-11-01', '2026-11-01', 1),
(1, 'Marcela', 'Ruano', '1020013333', '3101230013', 'marcela.ruano@example.com', 'Calle 13 #130', 4, '2025-10-30', '2026-10-30', 1),
(1, 'Fernando', 'Rios', '1020014444', '3101230014', 'fernando.rios@example.com', 'Calle 14 #140', NULL,NULL,NULL, 1);

#Agregar membresías
INSERT INTO membresia (id_clinica, nombre, descripcion, precio, descuento, duracion)
VALUES 
(1, 'Basica', 'Descuento del 5% en servicios', 100000, 5, 12),
(1, 'Premium', 'Incluye vacunación anual gratuita', 250000, 15, 12),
(1,'Intermedia','Descuento del 10% en consultas',150000.00,10.00,12),
(1,'Gold','Descuento del 20% y revisión semestral gratuita',300000.00,20.00,12);

#Agregar mascotas
INSERT INTO mascota (id_cliente, id_clinica, nombre, especie, raza, color, sexo, fecha_nacimiento)
VALUES
-- Cliente 1: Alejandro Ospina
(1, 1, 'Max', 'Canino', 'Pastor Alemán', 'negro', 'macho', '2025-06-08'),
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



