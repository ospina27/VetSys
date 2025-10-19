/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.vetsys.dao;

<<<<<<< HEAD
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
    
=======
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import project.vetsys.database.DBConnection;
import project.vetsys.model.User;


/**
 *
 * @author User
 */
public class UserDAO {
    
    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    
    public User login(String username, String password) {
        
        String sql = "SELECT u.id, u.username, u.password, "
            + "r.name AS role_name, c.name AS clinic_name, s.name AS status_name "
            + "FROM users u "
            + "JOIN role r ON u.role_id = r.id "
            + "JOIN clinic c ON u.clinic_id = c.id "
            + "JOIN status s ON u.status_id = s.id "
            + "WHERE u.username = ? AND u.password = ?";
        
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                String estado = rs.getString("status_name");
                
                if (!estado.equalsIgnoreCase("Activo")) {
                    System.out.println("Usuario no activo");
                    return null;
                }
                
                User user = new User();
                user.setId_user(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setName_clinic(rs.getString("clinic_name"));
                user.setName_role(rs.getString("role_name"));
                user.setName_status(rs.getString("status_name"));
                return user;
            } else {
                System.out.println("Usuario o contraseña incorrectos");
            }

        } catch (SQLException e) {
             System.out.println("Error en login: " + e.getMessage());
            
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return null;
    }
>>>>>>> origin/login
}
