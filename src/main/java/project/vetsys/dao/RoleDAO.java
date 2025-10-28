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
import project.vetsys.model.User;

public class RoleDAO {
    
    public List<Role> getAllRole(User logUser){
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
    
    public List<Role> getRolesByClinic(int clinicId) {
    List<Role> roles = new ArrayList<>();
    String sql = "SELECT DISTINCT r.id, r.name, r.description "
               + "FROM role r "
               + "JOIN users u ON u.role_id = r.id "
               + "WHERE u.clinic_id = ?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, clinicId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) 
        {
            roles.add(new Role(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("description")
            ));
        }
    } catch (SQLException e) 
        {
           System.out.println("Error al obtener roles por clínica: " + e.getMessage());
        }
        return roles;
    }
    
}
