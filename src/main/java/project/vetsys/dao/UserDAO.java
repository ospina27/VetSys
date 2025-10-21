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
import project.vetsys.model.Clinic;


public class UserDAO {
    
    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    
    public User login(String username, String password) throws ClassNotFoundException {
        
        String sql = "SELECT u.id, u.username, u.password, "
            + "r.name AS role_name, c.name AS clinic_name, s.name AS status_name, c.id AS clinic_id "
            + "FROM users u "
            + "JOIN role r ON u.role_id = r.id "
            + "JOIN clinic c ON u.clinic_id = c.id "
            + "JOIN status s ON u.status_id = s.id "
            + "WHERE u.username = ? ";
        
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            
            ///comparación de hash creados en la base de datos con el texto ingresado en el login 
            if (rs.next()) { 
                
                String storedPassHash = rs.getString("password");
                if (!PasswordUtil.checkPassword(password, storedPassHash)) {
                    System.out.println("Contraseña incorrecta");
                    return null;
                }
                
                String status = rs.getString("status_name");
                
                if (!status.equalsIgnoreCase("Activo")) {
                    System.out.println("Usuario no activo");
                    return null;
                }
                // si paso las validaciones se crean losobjetos
                User user = new User();
                user.setId_user(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setName_role(rs.getString("role_name"));
                user.setName_status(rs.getString("status_name"));
                
                Clinic clinic = new Clinic();
                clinic.setId_clinic(rs.getInt("clinic_id"));
                clinic.setName_clinic(rs.getString("clinic_name"));
                user.setClinic(clinic);
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
                System.out.println("Error, cerrando conexión: " + e.getMessage());
            }
        }
        return null;
    }
    
    public boolean Create(User user){
        String sqlInsert = "Insert into users (id, clinic_id, role_id, status_id, username, password) VALUES (null,?,?,?,?,?)";
        
        try {
            connection = DBConnection.getConnection()
;           ps = connection.prepareStatement(sqlInsert);

            ps.setInt(1, user.getId_clinic());
            ps.setInt(2, user.getId_role());
            ps.setInt(3, user.getId_status());
            ps.setString(4, user.getUsername());
            //metodo para encriptar la contraseña
            String passEncrypted = PasswordUtil.encryptPassword(user.getPassword()); 
            ps.setString(5,passEncrypted);
            
            int rows = ps.executeUpdate();
            return rows > 0;
            
        } catch (Exception e) {
            System.out.println("Error en la creación del usuario: " + e.getMessage());
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                System.out.println("Error cerrando la conexión: " + ex.getMessage());
            }
        }
    }
    
    public List<User> Read(int clinicId){
    List<User> listUsers = new ArrayList<>();
    //Cambio la consulta SQL para filtrar por el id de la clinica
    String sqlRead = "SELECT u.id AS user_id, " 
                   + "u.clinic_id, u.role_id, u.status_id, u.username, "
                   + "r.id AS role_name, r.description AS role_description, "
                   + "c.name, c.nit, c.address, c.phone, c.registration_date, c.status_id AS clinic_status "
                   + "FROM users u "
                   + "JOIN role r ON u.role_id = r.id "
                   + "JOIN clinic c ON u.clinic_id = c.id "
                   + "WHERE u.clinic_id = ?";  // Filtro por el id de la clinica

    try (Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sqlRead)) {
        ps.setInt(1, clinicId);  ///primero asignamos el id de la clinica para listar

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                User user = new User();
                Clinic clinic = new Clinic();

                user.setId_user(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setName_role(rs.getString("role_name"));
                user.setName_status(rs.getString("role_description"));

                clinic.setId_clinic(rs.getInt("clinic_id"));
                clinic.setName_clinic(rs.getString("name"));
                clinic.setNit(rs.getString("nit"));
                clinic.setAddress(rs.getString("address"));
                clinic.setPhone(rs.getString("phone"));
                clinic.setRegistration_date(rs.getString("registration_date"));
                clinic.setId_status(rs.getInt("clinic_status"));

                user.setClinic(clinic);
                listUsers.add(user);
            }
        }

    } catch (Exception e) {
        System.out.println("Error al listar usuarios por clínica");
        e.printStackTrace();
    }
    
    return listUsers;
}
    
    public boolean Update(User user, User logUser){
        
        if(!"Administrador".equalsIgnoreCase(logUser.getName_role()))
        {
            System.out.println("Solo un administrador puede modificar");
            return false;
        }
        if(user.getId_clinic()!= logUser.getId_clinic())
        {
            System.out.print("No se puede actualizar usuarios de otra clinica");
            return false;
        }
        boolean updatePass = user.getPassword() != null && !user.getPassword().isEmpty(); ///actualizar contraseña o dejar la misma
                                                                                         ///según lo que elija el usuario
        String sqlUpdate;
        if(updatePass){
            sqlUpdate = "UPDATE users SET role_id=?, status_id=?, "
                + "username=?, password=? "
                + "WHERE id=?";
        }else 
        {
            sqlUpdate = "UPDATE users SET role_id = ?, status_id = ?, " 
                    + "username = ? "
                    + "WHERE id = ?";
        }
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sqlUpdate);
            ps.setInt(1, user.getId_role());
            ps.setInt(2, user.getId_status());
            ps.setString(3, user.getUsername());
            
            if(updatePass){
                String passEncrypted = PasswordUtil.encryptPassword(user.getPassword());
                ps.setString(4, passEncrypted);
                ps.setInt(5,user.getId_user());
            }else
            {
                ps.setInt(4,user.getId_user());
            }
            
            int rowUpdate = ps.executeUpdate(); ///verificar en consola si se actualizo o no alguna fila
            return rowUpdate > 0;            
            
        } catch (Exception e) {
            System.out.println("Error al actualizar el usuario "+e.getMessage());
        }finally
        {
            try 
            {
                if(ps!= null) ps.close();
                if(connection != null) connection.close();
            } catch (Exception e) 
            {
                System.out.println(e.toString());  
            }     
        }
        return false;
    }
    
    
    
    public boolean Delete(){
        return true; 
    }
}
