# VetSys – Sistema de Gestión Clínica para Veterinarias

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/Java%20Swing-007396?style=for-the-badge&logo=coffeescript&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![Scrum](https://img.shields.io/badge/Scrum-2C8EBB?style=for-the-badge&logo=agile&logoColor=white)


---

## 📋 Descripción del Proyecto
**VetSys** es un software de escritorio desarrollado en **Java Swing** con base de datos **MySQL**, diseñado para 
optimizar la gestión clínica y administrativa de clínicas veterinarias.  
Permite gestionar clientes, mascotas, citas, veterinarios, historial clínico y alertas automáticas.

---

## Objetivo
Automatizar los procesos clínicos y administrativos de una veterinaria, mejorando la organización, eficiencia y atención al cliente.

---

Este proyecto se desarrolló como trabajo académico. Su uso puede adaptarse para propósitos profesionales o personales.


---


## Características principales

### Gestión de Veterinarios
- Registro, actualización y eliminación de veterinarios.
- Listado con búsqueda y filtrado.

### Gestión de Clientes
- Almacenamiento de información de clientes.
- Relación directa con sus mascotas.

### Gestión de Mascotas
- Datos completos por mascota.
- Asociación al cliente correspondiente.
- Acceso rápido a historial clínico.

### Módulo de Citas
- Programación de citas con fecha y hora.
- Validación para evitar fechas pasadas.
- Listado y control de citas diarias.

### Historial Clínico
- Registro de consultas por mascota.
- Datos del veterinario, fecha, síntomas, diagnóstico, tratamiento y notas.
- Vista completa del historial del animal.

### Módulo de Notificaciones
- **Citas programadas para mañana**.
- **Membresías próximas a vencer en el mes**.
- Panel deslizable accesible desde el menú principal.

### Interfaz amigable
- Tarjetas informativas con estilos.
- Paneles organizados y consistentes.
- Navegación intuitiva entre módulos.

### Módulo de Reportes Gráficos
- Incluye panel de estadísticas con gráficos generados dinámicamente.
- Permite obtener una visión clara del rendimiento de la clínica y apoyar en la toma de decisiones.

---

## Dataset

Para este proyecto se generó un **dataset realista y totalmente coherente** para inicializar 
la base de datos y permite probar el flujo completo del módulo clínico.

En la carpeta `/database` se encuentra este archivo que contiene:

* Creación de tablas
* Inserción de roles y estados.
* Usuarios, incluyendo administradores, asistentes y veterinarios.
* Clientes y sus mascotas asociadas correctamente.
* Citas generadas en estados programadas, canceladas y realizadas.
* Historial clínico únicamente para las citas realizadas.
* IDs totalmente coherentes con las llaves foráneas:


### Objetivo de generar este dataset

Este conjunto de datos de prueba permite:

* Validar el módulo de citas y historial clínico.
* Probar consultas, reportes y dashboards.
Revisar el comportamiento del sistema con diferentes estados de cita.
* Evaluar integridad referencial entre tablas.