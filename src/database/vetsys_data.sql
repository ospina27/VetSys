use vetsys;

INSERT INTO estado (nombre) VALUES ('Activo'), ('Inactivo');


INSERT INTO rol (nombre, descripcion) VALUES 
('Administrador', 'gestion total del sistema y usuarios'),
('Veterinario', 'atiende citas, gestion historial clinico'),
('Asistente', 'gestion de citas, clientes, facturacion');


INSERT INTO clinica (nombre, nit, direccion, fecha_registro, id_estado)
VALUES ('AnimalCare', '901234567', 'Carrera 10 #25', '2025-11-01', 1),
('CatDog', '902345678-2', 'Calle 10 #123', '2025-10-15', 1);


INSERT INTO usuario (id_clinica, nombres, apellidos, documento, telefono, correo, username, contrasena, id_rol, id_estado)
VALUES 
(1, 'Laura', 'Gomez', '10203040', '3001112233', 'laura@animalcare.com', 'adminVet', '12345', 1, 1),
(1, 'Carlos', 'Ruiz', '10987654', '3012223344', 'carlos@animalcare.com', 'vetCarlos', 'abc123', 2, 1),
(2, 'María', 'López', '10304050', '3009998877', 'maria@catdog.com', 'admin', 'admin123', 1, 1),
(2, 'Andrés', 'Soto', '11223344', '3018887766', 'andres@catdog.com', 'auxAndres', 'auxpass', 3, 1);

INSERT INTO usuario (id_clinica, nombres, apellidos, documento, telefono, correo, username, contrasena, id_rol, id_estado)
VALUES 
(1, 'Alejandro', 'Ospina', '1010129136', '3106409524', 'alejo@animalcare.com', 'alejoVet', '12345', 1, 1);

INSERT INTO membresia (id_clinica, nombre, descripcion, precio, descuento, duracion)
VALUES 
(1, 'Basica', 'Descuento del 5% en servicios', 100000, 5, 12),
(2, 'Premium', 'Incluye vacunación anual gratuita', 250000, 15, 12);


INSERT INTO cliente (id_clinica, nombres, apellidos, documento, telefono, correo, direccion, id_membresia, fecha_inicio, fecha_vigencia, id_estado_membresia)
VALUES (1, 'Ana', 'Perez', '100200300', '3205556677', 'ana.perez@email.com', 'Calle 45 #20', 1, '2025-11-01', '2026-11-01', 1), (2, 'Jorge', 'Ramírez', '10505060', '3112223344', 'jorge@mail.com', 'Cl. 80 #45-20', 2, '2025-10-20', '2026-10-20', 1);
;


INSERT INTO mascota (id_cliente, id_clinica, nombre, especie, raza, color, sexo, fecha_nacimiento)
VALUES 
(1, 1, 'Luna', 'Canino', 'pitbull', 'blanco', 'hembra', '2020-03-10'),
(1, 1, 'Rocky', 'Felino', 'Persa', 'Blanco', 'macho', '2021-08-22'),
(2, 2, 'Toby', 'Canino', 'Beagle', 'Tricolor', 'macho', '2022-04-01');


INSERT INTO tipo_servicio (nombre) VALUES ('Consulta'), ('Vacunación'), ('Cirugia');


INSERT INTO servicio (id_clinica, nombre, id_tipo, descripcion, precio)
VALUES 
(1, 'Consulta general', 1, 'Revisión médica básica', 40000),
(1, 'Vacunación antirrábica', 2, 'Aplicación de vacuna anual', 50000);


INSERT INTO tipo_producto (nombre) VALUES ('Vacuna'), ('Medicamento'), ('Higiene'), ('Desparasitante');


INSERT INTO producto (id_clinica, nombre, id_tipo, precio, cantidad_stock, estado)
VALUES 
(1, 'Vacuna Rabia', 1, 30000, 50, 'disponible'),
(1, 'Desparasitante Canino', 4, 15000, 30, 'disponible'),
(1, 'Crema cicatrizante', 2, 18000, 50, 'disponible'),
(2, 'Spray antipulgas', 2, 20000, 40, 'disponible');


INSERT INTO cita (id_clinica, id_cliente, id_mascota, id_veterinario, fecha_cita, estado)
VALUES 
(1, 1, 1, 2, '2025-11-03 10:00:00', 'programada'),
(2, 2, 2, 4, '2025-11-05 09:30:00', 'programada');


INSERT INTO historial_clinico (id_clinica, id_mascota, id_veterinario, id_cita, fecha_registro, motivo_consulta, diagnostico, tratamiento, peso)
VALUES 
(1, 1, 2, 1, '2025-11-03', 'Control anual', 'Salud estable', 'Refuerzo de vacuna', 25.5),
(2, 2, 4, 2, '2025-11-05', 'Chequeo general', 'Salud estable', 'Desparasitación preventiva', 12.3);


INSERT INTO factura (id_clinica, id_cliente, fecha_emision, total)
VALUES 
(1, 1, '2025-11-03', 95000),
(2, 2, '2025-11-05', 65000);


INSERT INTO detalle_factura (id_factura, id_servicio, cantidad, precio_unitario)
VALUES 
(1, 1, 1, 40000),
(1, 2, 1, 25000),
(2, 1, 1, 45000);


INSERT INTO detalle_factura (id_factura, id_producto, cantidad, precio_unitario)
VALUES 
(1, 1, 1, 30000),
(2, 2, 1, 45000);



UPDATE factura
SET total = (SELECT SUM(subtotal) FROM detalle_factura WHERE id_factura = 1)
WHERE id_factura = 1;


UPDATE factura
SET total = (SELECT SUM(subtotal) FROM detalle_factura WHERE id_factura = 2)
WHERE id_factura = 2;
