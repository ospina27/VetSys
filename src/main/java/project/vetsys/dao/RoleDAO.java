/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.vetsys.dao;


import project.vetsys.database.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import project.vetsys.model.Role;

public class RoleDAO {
    
    public List<Role> getAllRole(){
        List<Role> roles = new ArrayList<>();
        String sql = "Select * FROM role";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                roles.add(new Role(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener roles: " + e.getMessage());
        }
        return roles;
    }   
}
