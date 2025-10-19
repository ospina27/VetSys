/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.vetsys.model;

/**
 *
 * @author User
 */
public class Clinic {
    
    private int id_clinic;
    private String name_clinic; 
    private String nit; 
    private String address;
    private String phone;
    private String registration_date;
    private int id_status;
    
    public Clinic(){
        
    }

    public Clinic(int id_clinic, String name_clinic, String nit, String address, String phone, String registration_date, int id_status) {
        this.id_clinic = id_clinic;
        this.name_clinic = name_clinic;
        this.nit = nit;
        this.address = address;
        this.phone = phone;
        this.registration_date = registration_date;
        this.id_status = id_status;
    }
    

    public int getId_clinic() {
        return id_clinic;
    }

    public void setId_clinic(int id_clinic) {
        this.id_clinic = id_clinic;
    }

    public String getName_clinic() {
        return name_clinic;
    }

    public void setName_clinic(String name_clinic) {
        this.name_clinic = name_clinic;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    public int getId_status() {
        return id_status;
    }

    public void setId_status(int id_status) {
        this.id_status = id_status;
    }
}
