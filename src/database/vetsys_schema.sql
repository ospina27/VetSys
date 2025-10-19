CREATE DATABASE vetsys;

use vetsys;

create table status(
id int auto_increment not null primary key,
name varchar(20)
);

create table role(
id int not null auto_increment primary key,
name varchar(100),
description varchar(255)
);

create table clinic(
id int not null auto_increment primary key,
name varchar(100) not null,
nit varchar(20) not null,
address varchar(100),
phone varchar(20),
registration_date DATE,
status_id int not null,
Foreign key (status_id) REFERENCES status(id)
);

create table users(
id int not null auto_increment primary key,
clinic_id int not null,
role_id int not null,
status_id int not null,
username varchar(100) not null,
password varchar(255) not null,
Foreign key (role_id) REFERENCES role(id),
Foreign key (clinic_id) REFERENCES clinic(id),
Foreign key (status_id) REFERENCES status(id),
constraint login_user UNIQUE(username,password)
);

create table administrative(
document varchar(20) not null primary key,
user_id int not null,
name varchar(100) not null, 
last_name varchar(100),
phone varchar(100),
address varchar(100),
email varchar(100),
position varchar(100),
Foreign key (user_id) REFERENCES users(id)
);

create table pet(
id int not null auto_increment primary key,
name varchar(100) not null,
breed varchar(100) not null,
species varchar(100) not null, 
age int not null,
document_client varchar(20)
);

create table client(
document varchar(20) not null primary key,
name varchar(20) not null,
last_name varchar(20) not null,
phone varchar(20),
email varchar(20),
address varchar(100),
id_pet int,
Foreign key (id_pet) REFERENCES pet(id)
);

ALTER TABLE pet
ADD CONSTRAINT fk_pet_client
FOREIGN KEY (document_client)
REFERENCES client(document)
ON DELETE CASCADE
ON UPDATE CASCADE;

create table veterinarian(
document varchar(20) not null primary key,
name varchar(20) not null,
last_name varchar(20) not null,
phone varchar(20),
specialty varchar(20),
email varchar(100),
user_id int not null,
Foreign key (user_id) REFERENCES users(id)
);
