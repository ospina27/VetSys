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
import project.vetsys.model.User;
import project.vetsys.security.PasswordUtil;
import java.util.ArrayList;
import java.util.List;


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
            + "WHERE u.username = ? " /*AND u.password = ?"*/;
        
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            //ps.setString(2, password);
            rs = ps.executeQuery();
            
            ///comparación de hash creados en la base de datos con los ingresados en el login 
            if (rs.next()) { 
                String storedPassHash = rs.getString("password");
                String inputPassHash = PasswordUtil.encryptPassword(password);
                if(!storedPassHash.equals(inputPassHash)){
                    System.out.println("Contraseña Incorrecta");
                }
                
                String status = rs.getString("status_name");
                
                if (!status.equalsIgnoreCase("Activo")) {
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
    public boolean Create(User user){
        String sqlInsert = "Insert into users (id, clinic_id, role_id, status_id, username, password)VALUES(null,?,?,?,?,?)";
        try {
            connection = DBConnection.getConnection()
;           ps = connection.prepareStatement(sqlInsert);
            ps.setInt(1, user.getId_clinic());
            ps.setInt(2, user.getId_role());
            ps.setInt(3, user.getId_status());
            ps.setString(4, user.getUsername());
            String passEncrypted = PasswordUtil.encryptPassword(user.getPassword()); //metodo para encriptar la contraseña
            ps.setString(5,passEncrypted);
            ps.executeUpdate();
            return true;
            
        } catch (Exception e) {
            System.out.println("Error en la creación del usuario: " + e.getMessage());
            return false;
        }
    }
    
    public List<User> Read(){
        List<User> listUsers = new ArrayList<>();
        String sqlRead = "SELECT u.id AS user_id, "
                + "u.clinic_id, u.role_id, u.status_id, u.username, "
                + "r.id AS role_name, r.description AS role_description "
                + "FROM users u "
                + "JOIN role r ON u.role_id = r.id ";
        try(Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlRead)){
            while(rs.next()){
                User user = new User();
                user.setId_user(rs.getInt("user_id"));
                user.setId_clinic(rs.getInt("clinic_id"));
                user.setId_role(rs.getInt("role_id"));
                user.setId_status(rs.getInt("status_id"));
                user.setUsername(rs.getString("username"));
                user.setName_role(rs.getString("role_name"));
                listUsers.add(user);
            }
        } catch (Exception e) {
            System.out.println("Error al listar usuarios");
        }
        return listUsers;
    }
    
    public boolean Update(User user){
        boolean updatePass = user.getPassword() != null && !user.getPassword().isEmpty(); ///actualizar contraseña o dejar la misma
                                                                                         ///según lo que elija el usuario
        String sqlUpdate;
        if(updatePass){
            sqlUpdate = "UPDATE users SET clinic_id=?, role_id=?, status_id=?, "
                + "username=?, password=? "
                + "WHERE id=?";
        }else 
        {
            sqlUpdate = "UPDATE users SET clinic_id = ?, role_id = ?, status_id = ?, " 
                    + "username = ? "
                    + "WHERE id = ?";
        }
        
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sqlUpdate);
            ps.setInt(1, user.getId_clinic());
            ps.setInt(2, user.getId_role());
            ps.setInt(3, user.getId_status());
            ps.setString(4, user.getUsername());
            
            if(updatePass){
                String passEncrypted = PasswordUtil.encryptPassword(user.getPassword());
                ps.setString(5, passEncrypted);
                ps.setInt(6,user.getId_user());
            }else
            {
                ps.setInt(5,user.getId_user());
            }
            
            int rowUpdate = ps.executeUpdate(); ///verificar en consola si se actualizo o no alguna fila
            return rowUpdate > 0;                  
        } catch (Exception e) {
        }
        return true;
    }
    
    public boolean Delete(){
        return true; 
    }
}
