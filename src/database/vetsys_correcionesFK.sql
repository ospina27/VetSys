USE vetsys;

###alterar las tablas donde id_mascosta es llave foranea para poder eliminarla
ALTER TABLE cita
DROP FOREIGN KEY cita_ibfk_3;
ALTER TABLE cita
ADD CONSTRAINT cita_ibfk_3
FOREIGN KEY (id_mascota) REFERENCES mascota(id_mascota)
ON DELETE CASCADE;

ALTER TABLE historial_clinico 
DROP FOREIGN KEY historial_clinico_ibfk_2;
ALTER TABLE historial_clinico
ADD CONSTRAINT historial_clinico_ibfk_2
FOREIGN KEY (id_mascota) REFERENCES mascota(id_mascota)
ON DELETE CASCADE;

###alterar tablas donde id_cita es FK para poder eliminarlas
ALTER TABLE historial_clinico 
DROP FOREIGN KEY historial_clinico_ibfk_4;
ALTER TABLE historial_clinico
ADD CONSTRAINT historial_clinico_ibfk_4
FOREIGN KEY (id_cita) REFERENCES cita(id_cita)
ON DELETE CASCADE;


##alterar las tablas donde id_usuario es llave foranea, para poder eliminarlo
ALTER TABLE cita
DROP FOREIGN KEY cita_ibfk_4;
ALTER TABLE cita
ADD constraint cita_ibfk_4
foreign key (id_veterinario) references usuario(id_usuario)
ON DELETE CASCADE; 

ALTER TABLE historial_clinico
DROP FOREIGN KEY historial_clinico_ibfk_3;
ALTER TABLE historial_clinico
ADD constraint historial_clinico_ibfk_3
foreign key (id_veterinario) references usuario(id_usuario)
ON DELETE CASCADE;
