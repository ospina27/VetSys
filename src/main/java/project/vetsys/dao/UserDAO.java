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
import javax.swing.JOptionPane;
import project.vetsys.model.Clinic;


public class UserDAO {
    
    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    
    public User login(String username, String password) throws ClassNotFoundException {
        
        String sql = "SELECT u.id_usuario, u.nombres, u.apellidos, "
              + "u.documento, u.telefono, u.correo, "
            + "u.username, u.contrasena, "
            + "r.nombre AS role_name, "
            + "c.nombre AS clinic_name, "
            + "e.nombre AS status_name, "
            + "c.id_clinica AS clinic_id "
            + "FROM usuario u "
            + "JOIN rol r ON u.id_rol = r.id_rol "
            + "JOIN clinica c ON u.id_clinica = c.id_clinica "
            + "JOIN estado e ON u.id_estado = e.id_estado "
                + "WHERE u.username = ? ";
        
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            
            ///comparación de hash creados en la base de datos con el texto ingresado en el login 
            if (rs.next()) { 
                
                String storedPassHash = rs.getString("contrasena");
                System.out.println("HASH ingresado: " + PasswordUtil.encryptPassword(password));
                System.out.println("HASH BD:        " + storedPassHash);
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
                user.setId_user(rs.getInt("id_usuario"));
                user.setName_user(rs.getString("nombres"));
                user.setLast_name(rs.getString("apellidos"));
                user.setDocument(rs.getString("documento"));
                user.setPhone(rs.getString("telefono"));
                user.setEmail(rs.getString("correo"));
                user.setUsername(rs.getString("username"));
                user.setName_role(rs.getString("role_name"));
                user.setName_status(rs.getString("status_name"));
                
                Clinic clinic = new Clinic();
                clinic.setId_clinic(rs.getInt("clinic_id"));
                clinic.setName_clinic(rs.getString("clinic_name"));
                user.setClinic(clinic);
                user.setId_clinic(rs.getInt("clinic_id"));
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
        String sqlInsert = "Insert into usuario (id_clinica, nombres, apellidos, documento, telefono, correo, "
                + "username, contrasena, id_rol, id_estado) VALUES (?,?,?,?,?,?,?,?,?,?)";
        
        try {
            connection = DBConnection.getConnection();
           ps = connection.prepareStatement(sqlInsert);

            ps.setInt(1, user.getId_clinic());
            ps.setString(2, user.getName_user());
            ps.setString(3,user.getLast_name());
            ps.setString(4, user.getDocument());
            ps.setString(5, user.getPhone());
            ps.setString(6, user.getEmail());
            ps.setString(7, user.getUsername());
            
            //metodo para encriptar la contraseña
            String passEncrypted = PasswordUtil.encryptPassword(user.getPassword()); 
            ps.setString(8,passEncrypted);
            
            ps.setInt(9, user.getId_role());
            ps.setInt(10, user.getId_status());
            
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
    
    public List<User> ReadAll(User logUser) {  ///Lista los usuarios según la clinica del user logueado 
        
        List<User> listUsers = new ArrayList<>();

        String sql = "SELECT u.id_usuario AS user_id, "
                    + "u.nombres, u.apellidos, u.documento, "
                    + "u.telefono, u.correo, u.username, "
                   + "r.nombre AS role_name, e.nombre AS status_name, "
                   + "c.id_clinica AS clinic_id, c.nombre AS clinic_name "
                   + "FROM usuario u "
                   + "JOIN rol r ON u.id_rol = r.id_rol "
                   + "JOIN estado e ON u.id_estado = e.id_estado "
                   + "JOIN clinica c ON u.id_clinica = c.id_clinica "
                   + "WHERE c.id_clinica = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){
            //ResultSet rs = ps.executeQuery()) {
            ps.setInt(1,logUser.getId_clinic()); ///pasar el id de la clinica para listar
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                User user = new User();
                Clinic clinic = new Clinic();

                user.setId_user(rs.getInt("user_id"));
                user.setName_user(rs.getString("nombres"));
                user.setLast_name(rs.getString("apellidos"));
                user.setDocument(rs.getString("documento"));
                user.setPhone(rs.getString("telefono"));
                user.setEmail(rs.getString("correo"));
                user.setUsername(rs.getString("username"));
                user.setName_role(rs.getString("role_name"));
                user.setName_status(rs.getString("status_name"));

                clinic.setId_clinic(rs.getInt("clinic_id"));
                clinic.setName_clinic(rs.getString("clinic_name"));
                user.setClinic(clinic);
                user.setName_clinic(clinic.getName_clinic());

                listUsers.add(user);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al listar todos los usuarios: " + e.getMessage());
        }
        return listUsers;
    }
    
    public User ReadById(int id) {  
        String sql = "SELECT u.id_usuario AS user_id, "
                  + "u.nombres, u.apellidos, u.documento, u.telefono, u.correo, "
                   + "u.username, u.contrasena, "
                   + "r.id_rol AS role_id, r.nombre AS role_name, "
                   + "e.id_estado AS status_id, e.nombre AS status_name, "
                   + "c.id_clinica AS clinic_id, c.nombre AS clinic_name "
                   + "FROM usuario u "
                   + "JOIN rol r ON u.id_rol = r.id_rol "
                   + "JOIN estado e ON u.id_estado = e.id_estado "
                   + "JOIN clinica c ON u.id_clinica = c.id_clinica "
                   + "WHERE u.id_usuario = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User user = new User();
                Clinic clinic = new Clinic();

                user.setId_user(rs.getInt("user_id"));
                user.setName_user(rs.getString("nombres"));
                user.setLast_name(rs.getString("apellidos"));
                user.setDocument(rs.getString("documento"));
                user.setPhone(rs.getString("telefono"));
                user.setEmail(rs.getString("correo"));
                user.setUsername(rs.getString("username"));
                user.setId_role(rs.getInt("role_id"));
                user.setName_role(rs.getString("role_name"));
                user.setId_status(rs.getInt("status_id"));
                user.setName_status(rs.getString("status_name"));

                clinic.setId_clinic(rs.getInt("clinic_id"));
                clinic.setName_clinic(rs.getString("clinic_name"));
                user.setClinic(clinic);
                user.setName_clinic(clinic.getName_clinic());

                return user;
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar usuario por ID: " + e.getMessage());
        }
        return null;
    }
   
     
    public List<User> ReadByClinicAndRole(int clinicId, Integer roleId) {
        List<User> listUsers = new ArrayList<>();
       
        StringBuilder sql = new StringBuilder(
            "SELECT u.id_usuario AS user_id, "
            + "u.nombres, u. apellidos, u.documento, "
            + "u.telefono, u.correo, u.username, " +
            "r.id_rol AS role_id, r.nombre AS role_name, " +
            "e.nombre AS status_name, c.id_clinica AS clinic_id, c.nombre AS clinic_name " +
            "FROM usuario u " +
            "JOIN rol r ON u.id_rol = r.id_rol " +
            "JOIN estado e ON u.id_estado = e.id_estado " +
            "JOIN clinica c ON u.id_clinica = c.id_clinica " +
            "WHERE c.id_clinica = ?"
            );
        
        if (roleId != null && roleId >0) {
            sql.append(" AND r.id_rol = ?");
        }

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql.toString())) {

            ps.setInt(1, clinicId);
            if (roleId != null && roleId >0){
                ps.setInt(2, roleId);
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    User user = new User();
                    Clinic clinic = new Clinic();

                    user.setId_user(rs.getInt("user_id"));
                    user.setName_user(rs.getString("nombres"));
                    user.setLast_name(rs.getString("apellidos"));
                    user.setDocument(rs.getString("documento"));
                    user.setPhone(rs.getString("telefono"));
                    user.setEmail(rs.getString("correo"));
                    user.setUsername(rs.getString("username"));
                    user.setName_role(rs.getString("role_name"));
                    user.setName_status(rs.getString("status_name"));
                    
                    clinic.setId_clinic(rs.getInt("clinic_id"));
                    clinic.setName_clinic(rs.getString("clinic_name"));
                    user.setId_role(rs.getInt("role_id"));
                    user.setClinic(clinic);
                    user.setName_clinic(clinic.getName_clinic());

                    listUsers.add(user);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al listar usuarios por clínica y rol: " + e.getMessage());
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
        String sqlUpdate = "UPDATE usuario SET nombres=?, apellidos=?, documento=?, telefono=?, correo=?, username=? "
                + "id_estado=?, id_rol=? "
                + "WHERE id_usuario=?";
        
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sqlUpdate);
            ps.setString(1, user.getName_user());
            ps.setString(2, user.getLast_name());
            ps.setString(3, user.getDocument());            
            ps.setString(4,user.getPhone());
            ps.setString(5,user.getEmail());
            ps.setString(6,user.getUsername());
            ps.setInt(7,user.getId_status());
            ps.setInt(8,user.getId_role());
            ps.setInt(9,user.getId_user());
           
                    
            
            
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
    
     ///buscar los datos del usuario para hacer la verificacion en la BD
    public User searchUserPass(String name, String document) {
        
        String sql = "SELECT * FROM usuario WHERE nombres = ? AND documento = ? AND id_estado = 1";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, document);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    user.setId_user(rs.getInt("id_usuario"));
                    user.setName_user(rs.getString("nombres"));
                    user.setDocument(rs.getString("documento"));
                    user.setPassword(rs.getString("contrasena"));
                    return user;
                }
            }

        } catch (SQLException e) {
            System.err.println("Error buscando usuario: " + e.getMessage());
        }

        return null;
    }
  
   
   ///actualizar la contraseña 
    public boolean updatePassword(int idUser, String password){
       
       String passEncrypted = PasswordUtil.encryptPassword(password); ///encripta la clave nueva
       String sql = "UPDATE usuario SET contrasena = ? WHERE id_usuario = ?";
       
       try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, passEncrypted);
            ps.setInt(2, idUser);
            
            return ps.executeUpdate() > 0;           
            
        } catch (Exception e) {
            System.out.println("Error al actualizar la contraseña "+e.getMessage());
            return false;
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
    }
   
   
   ///verificar que el usuario exista, para el cambio de clave
   public boolean userExists(String nombre, String documento) {
        String sql = "SELECT COUNT(*) FROM usuario WHERE nombres = ? AND documento = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, documento);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error validando usuario: " + e.getMessage());
        }
        return false;
    }


    
    public boolean Delete(User user, User logUser){
        ///No borramos al usuario de la tabla, por las llaves foraneas
        ///que estan en otras tablas, entonces lo desactivamos y así ya no
        ///tiene acceso de nuevo a la aplicación
        
        String sql = "UPDATE usuario SET id_estado = 2 WHERE id_usuario = ? AND id_clinica = ?";
        
        try (Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, user.getId_user());
        ps.setInt(2, logUser.getId_clinic());
        int rowsAffected = ps.executeUpdate();
        return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Error desactivando el usuario: " + e.getMessage());
            return false;
        }
    }
   
}
