INSERT INTO status (name) VALUES ('Activo'), ('Inactivo');


INSERT INTO role (name, description) VALUES 
('Administrador', 'acceso total al sistema'),
('Asistente', 'gestion administrativa'),
('Veterinario', 'gestion clinica');



INSERT INTO clinic (name, nit, address, phone, status_id) 
VALUES ("AnimalCare", "901234567", "Calle 10 #30", "3215558990", 1);


INSERT INTO users (clinic_id, role_id, status_id, username, password) 
VALUES (1, 1, 1, "admin", "1234")