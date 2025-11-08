CREATE DATABASE vetsys;

USE vetsys;


CREATE TABLE estado (
    id_estado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);


CREATE TABLE rol (
    id_rol INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255)
);


CREATE TABLE tipo_servicio (
    id_tipo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);


CREATE TABLE tipo_producto (
    id_tipo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);


CREATE TABLE clinica (
    id_clinica INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    nit VARCHAR(20) NOT NULL,
    direccion VARCHAR(100),
    fecha_registro DATE DEFAULT (CURRENT_DATE),
    id_estado INT NOT NULL,
    FOREIGN KEY (id_estado) REFERENCES estado(id_estado)
);


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
    FOREIGN KEY (id_clinica) REFERENCES clinica(id_clinica)
    FOREIGN KEY (id_estado) REFERENCES estado(id_estado)
);


CREATE TABLE membresia (
    id_membresia INT AUTO_INCREMENT PRIMARY KEY,
    id_clinica INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    precio DECIMAL(10,2),
    descuento DECIMAL(5,2),
    duracion INT, -- en días
    FOREIGN KEY (id_clinica) REFERENCES clinica(id_clinica)
);


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
    FOREIGN KEY (id_clinica) REFERENCES clinica(id_clinica)
    FOREIGN KEY (id_estado) REFERENCES estado(id_estado)
);


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



CREATE TABLE servicio (
    id_servicio INT AUTO_INCREMENT PRIMARY KEY,
    id_clinica INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    id_tipo INT NOT NULL,
    descripcion VARCHAR(255),
    precio DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_tipo) REFERENCES tipo_servicio(id_tipo),
    FOREIGN KEY (id_clinica) REFERENCES clinica(id_clinica)
);


CREATE TABLE producto (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    id_clinica INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    id_tipo INT NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    cantidad_stock INT DEFAULT 0,
    estado ENUM('disponible', 'agotado') DEFAULT 'disponible',
    FOREIGN KEY (id_tipo) REFERENCES tipo_producto(id_tipo),
    FOREIGN KEY (id_clinica) REFERENCES clinica(id_clinica)
);



CREATE TABLE factura (
    id_factura INT AUTO_INCREMENT PRIMARY KEY,
    id_clinica INT NOT NULL,
    id_cliente INT NOT NULL,
    fecha_emision DATETIME DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10,2),
    FOREIGN KEY (id_clinica) REFERENCES clinica(id_clinica),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

CREATE TABLE detalle_factura (
    id_detalle INT AUTO_INCREMENT PRIMARY KEY,
    id_factura INT NOT NULL,
    id_producto INT NULL,
    id_servicio INT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(10,2) GENERATED ALWAYS AS (cantidad * precio_unitario) STORED,
    FOREIGN KEY (id_factura) REFERENCES factura(id_factura),
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto),
    FOREIGN KEY (id_servicio) REFERENCES servicio(id_servicio)
);


CREATE TABLE notificacion (
    id_notificacion INT AUTO_INCREMENT PRIMARY KEY,
    id_clinica INT NOT NULL,
    id_cliente INT NOT NULL,
    mensaje VARCHAR(255) NOT NULL,
    fecha_envio DATETIME DEFAULT CURRENT_TIMESTAMP,
    estado ENUM('pendiente', 'enviada') DEFAULT 'pendiente',
    FOREIGN KEY (id_clinica) REFERENCES clinica(id_clinica),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);


