/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.vetsys.dao;

import project.vetsys.security.PasswordUtil;
import project.vetsys.database.DBConnection;
import project.vetsys.model.User;
import project.vetsys.model.Role;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDAO {
    
    public UserDAO(){
        
    }
   
    
    //probar con la base de datos local
    public boolean Create(User user){
        String sqlInsert = "Insert into user (id, clinic_id, role_id, status_id, username, password)VALUES(null,?,?,?,?,?)";
       try (Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sqlInsert)) {
            ps.setInt(1, user.getClinicId());
            ps.setInt(2, user.getRole().getId());
            ps.setInt(3, user.getStatusId());
            ps.setString(4, user.getUsername());
            String passEncrypted = PasswordUtil.encryptPassword(user.getPassword()); //metodo para encriptar la contraseña
            ps.setString(5,passEncrypted);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en la creación del usuario: " + e.getMessage());
            return false;
        }
    }
    
    public List<User> Read(){
        List<User> listUsers = new ArrayList<>();
        String sqlRead = """
                     SELECT u.*, r.id AS role_id, r.name AS role_name, r.description AS role_desc
                     FROM users u
                     JOIN role r ON u.role_id = r.id""";
        try(Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlRead)){
            while(rs.next()){
                Role role = new Role(rs.getInt("role_id"),rs.getString("role_name"),rs.getString("role_description"));
                listUsers.add(new User(rs.getInt("id"),rs.getInt("clinic_id"),
                role,rs.getInt("status_id"),rs.getString("username"),""));
            }
        } catch (Exception e) {
            System.out.println("Error al listar usuarios");
        }
        return listUsers;
    }
    
    public boolean Update(){
        return true;
    }
    
    public boolean Delete(){
        return true; 
    }
    
}
