/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.vetsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import project.vetsys.database.DBConnection;
import project.vetsys.model.Clinic;


public class ClinicDAO {
    
    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    
    public int Create(Clinic clinic){
        String sqlInsert = "Insert into clinic (name, nit, address, phone, registration_date, status_id )"
                + "VALUES (?,?,?,?,?,?)";
        int generatedId = -1;
        
        try{
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS); //recuperar claves generadas
            
            ps.setString(1, clinic.getName_clinic());
            ps.setString(2,clinic.getNit());
            ps.setString(3, clinic.getAddress());
            ps.setString(4, clinic.getPhone());
            ps.setString(5, clinic.getRegistration_date());
            ps.setInt(6,clinic.getId_status());
            //return true;
            int rows = ps.executeUpdate();

            if (rows > 0) {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    generatedId = rs.getInt(1);
                }
            }
        }catch (Exception e){
            System.out.println("Error en la creación de la clinica: " + e.getMessage());
            //return false; 
        } finally {
            try {
                if (ps != null) ps.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                System.out.println("Error cerrando la conexión: " + ex.getMessage());
            }   
        }
        return generatedId;
    }
    
}
