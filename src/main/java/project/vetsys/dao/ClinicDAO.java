/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.vetsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import project.vetsys.database.DBConnection;
import project.vetsys.model.Clinic;


public class ClinicDAO {
    
    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean Create(Clinic clinic){
        String sqlInsert = "Insert into clinic (name, nit, address, phone, registration_date, status_id )"
                + "VALUES (?,?,?,?,?,?)";
        try{
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sqlInsert);
            ps.setString(1, clinic.getName_clinic());
            ps.setString(2,clinic.getNit());
            ps.setString(3, clinic.getAddress());
            ps.setString(4, clinic.getPhone());
            ps.setString(5, clinic.getRegistration_date());
            ps.setInt(6,clinic.getId_status());
            ps.executeUpdate();
            return true;
        }catch (Exception e){
            System.out.println("Error en la creación de la clinica: " + e.getMessage());
            return false; 
        }
    }   
}
