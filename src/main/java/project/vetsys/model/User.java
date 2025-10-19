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
    private int id_role;
    private int id_status;    
    private String username;
    private String password;
    private String name_clinic;
    private String name_role;
    private String name_status;
    
    public User() {
        
    }

    public User(int id, String clinic, String role, String status, String username, String password) {
        this.id_user = id;
        this.name_clinic = clinic;
        this.name_role = role;
        this.name_status = status;
        this.username = username;
        this.password = password;
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

    public void setUsername(String username) {
        this.username = username;
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
        return "Usuario: " + username + ", clinica: " + name_clinic + ", rol: " + name_role + ", estado: " + name_status;
    }

    

    
    
    
    
    
}
