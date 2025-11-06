/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.vetsys.model;

/**
 *
 * @author User
 */
public class User {
    
    private int id_user;
    private int id_clinic;
    private String name_user;
    private String last_name;
    private String document;
    private String phone;
    private String email;
    private String username;
    private String password;
    private int id_role;
    private int id_status;    
    private String name_clinic;
    private String name_role;
    private String name_status;
    private Clinic clinic;
    
    public User() {
        
    }

    public User(int id, Clinic clinic, String name_user, String last_name,
            String document, String phone, String email,
            String role, String status, String username, String password) {
        this.id_user = id;
        this.clinic = clinic;
        this.name_role = role;
        this.name_status = status;
        this.username = username;
        this.password = password;
        this.name_user = name_user;
        this.last_name = last_name;
        this.document = document;
        this.phone = phone;
        this.email = email;
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }
    
    
    
    public int getId_user() {
        return id_user;
    }

    public int getId_clinic() {
        return id_clinic;
    }

    public int getId_role() {
        return id_role;
    }

    public int getId_status() {
        return id_status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public String getName_clinic() {
        return name_clinic;
    }

    public String getName_role() {
        return name_role;
    }

    public String getName_status() {
        return name_status;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_clinic(int id_clinic) {
        this.id_clinic = id_clinic;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public void setId_status(int id_status) {
        this.id_status = id_status;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName_clinic(String name_clinic) {
        this.name_clinic = name_clinic;
    }

    public void setName_role(String name_rol) {
        this.name_role = name_rol;
    }

    public void setName_status(String name_status) {
        this.name_status = name_status;
    }

     @Override
    public String toString() {
        return "Usuario: " + username + ", Clinica: " 
                + (clinic != null ? clinic.getName_clinic():"Sin asignar") 
                + ", Rol: " + name_role + ", Estado: " + name_status;
    }

}
