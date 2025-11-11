/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.vetsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import project.vetsys.database.DBConnection;
import project.vetsys.model.Clinic;
import project.vetsys.model.Pet;
import project.vetsys.model.User;

/**
 *
 * @author User
 */
public class PetDAO {
    
    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    
    
        ///se crea la mascota buscando la cedula del cliente la cual trae su ID con el metodo creado 
        public boolean Create(Pet pet, String document){
            
            int idOwner = searchIdOwner(document);
            pet.setId_Client(idOwner);
            
            if(idOwner == -1){System.out.println("No se encontro cliente con cedula "+document);}
            String sqlInsert = "Insert into mascota (id_cliente, id_clinica, nombre, "
                    + "especie, raza, color, sexo, fecha_nacimiento)"
                    + " VALUES (?,?,?,?,?,?,?,?)";

            try {
                connection = DBConnection.getConnection();
                ps = connection.prepareStatement(sqlInsert);

                ps.setInt(1, pet.getId_Client());
                ps.setInt(2,pet.getId_Clinic());
                ps.setString(3, pet.getName_Pet());
                ps.setString(4, pet.getSpecies());
                ps.setString(5, pet.getBred());
                ps.setString(6, pet.getColor());
                ps.setString(7, pet.getSex());
                ps.setDate(8, pet.getDate_of_birth());

                int rows = ps.executeUpdate();
                return rows > 0;

            } catch (Exception e) {
                System.out.println("Error en la creación de la mascota: " + e.getMessage());
                return false;
            } finally {
                try {
                    if (ps != null) ps.close();
                    if (connection != null) connection.close();
                } catch (SQLException ex) {
                    System.out.println("Error, cerrando la conexión: " + ex.getMessage());
                }
            }
        }
        
        
        
       ///seleccionar el id del cliente para encontrar su cedula
       public int searchIdOwner(String document){
           String sql = "SELECT id_cliente FROM cliente WHERE documento = ?";
           
           
           try {
               connection = DBConnection.getConnection();
               ps = connection.prepareStatement(sql);
               ps.setString(1,document);
               
               rs = ps.executeQuery();
               if(rs.next()){
                   return rs.getInt("id_cliente");
               }
           } catch (Exception e) {
               System.out.println("Error al obtener el id_cliente: " + e.getMessage());
           }finally {
               try {
                 if (ps != null) ps.close();
                 if (connection != null) connection.close();
                } catch (SQLException ex) {
                 System.out.println("Error cerrando la conexión: " + ex.getMessage());
                }
           }
           return -1;           
       }

    
    
       public List<Pet> ReadAll(User logUser) {
            List<Pet> listPets = new ArrayList<>();

            String sql = "SELECT id_mascota, nombre, especie, raza, color, "
                    + "sexo, fecha_nacimiento "
                    + "FROM mascota "
                    + "WHERE id_clinica = ? ";

            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setInt(1, logUser.getId_clinic());

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Pet pet = new Pet();

                        pet.setId_pet(rs.getInt("id_mascota"));
                        pet.setName_Pet(rs.getString("nombre"));
                        pet.setSpecies(rs.getString("especie"));
                        pet.setBred(rs.getString("raza"));
                        pet.setColor(rs.getString("color"));
                        pet.setSex(rs.getString("sexo"));
                        pet.setDate_of_birth(rs.getDate("fecha_nacimiento"));
                        listPets.add(pet);
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error al listar mascotas: " + e.getMessage());
            }

            return listPets;
        }
       
       
       
        public List<Pet> ReadForClient(int idCliente, User logUser) {
            List<Pet> listPets = new ArrayList<>();

            String sql = "SELECT m.id_mascota, m.nombre AS nombre, m.especie, m.raza, " +
                         "m.color, m.sexo, m.fecha_nacimiento " +
                         "FROM mascota m " +
                         "WHERE m.id_clinica = ? AND m.id_cliente = ?";

            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setInt(1, logUser.getId_clinic());
                ps.setInt(2, idCliente);

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Pet pet = new Pet();
                        pet.setId_pet(rs.getInt("id_mascota"));
                        pet.setName_Pet(rs.getString("nombre"));
                        pet.setSpecies(rs.getString("especie"));
                        pet.setBred(rs.getString("raza"));
                        pet.setColor(rs.getString("color"));
                        pet.setSex(rs.getString("sexo"));
                        pet.setDate_of_birth(rs.getDate("fecha_nacimiento"));

                        listPets.add(pet);
                    }
                }

            } catch (SQLException e) {
                System.out.println("Error al listar mascotas por cliente: " + e.getMessage());
            }

            return listPets;
        }

    
       
       ///filtar mascota por cliente, mostrando informacion del cliente
       ///falta completar la consulta!!!
    /*public List<Pet> ReadForClient(User logUser) {  
        List<Pet> listPets = new ArrayList<>();

        String sql = "SELECT m.id_mascota, m.nombre AS nombre, m.especie, m.raza, " +
                     "m.color, m.sexo, m.fecha_nacimiento, " +
                     "c.id_cliente, c.nombre AS nombre_cliente, c.apellido AS apellido_cliente, " +
                     "c.telefono, c.email " +
                     "FROM mascota m " +
                     "INNER JOIN cliente c ON m.id_cliente = c.id_cliente " +
                     "WHERE m.id_clinica = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, logUser.getId_clinic());

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Pet pet = new Pet();

                    pet.setId_pet(rs.getInt("id_mascota"));
                    pet.setName_Pet(rs.getString("nombre_mascota"));
                    pet.setSpecies(rs.getString("especie"));
                    pet.setBred(rs.getString("raza"));
                    pet.setColor(rs.getString("color"));
                    pet.setSex(rs.getString("sexo"));
                    pet.setDate_of_birth(rs.getDate("fecha_nacimiento"));
                   
                    


                    listPets.add(pet);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al listar mascotas: " + e.getMessage());
        }

        return listPets;
    }*/

   
    
    public boolean Update(Pet pet, User logUser){
        
        String sql = "UPDATE mascota SET "
                + "id_cliente = ?, id_clinica = ?, nombre = ?, "
                + "especie = ?, raza = ?, color = ?, sexo = ?, "
                + "fecha_nacimiento = ? "
                + "WHERE id_mascota = ?";
       
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, pet.getId_Client());
            ps.setInt(2, pet.getId_Clinic());
            ps.setString(3, pet.getName_Pet());
            ps.setString(4, pet.getSpecies());
            ps.setString(5, pet.getBred());
            ps.setString(6, pet.getColor());
            ps.setString(7, pet.getSex());
            ps.setDate(8, pet.getDate_of_birth());
            ps.setInt(9,pet.getId_pet());
                   
            int rowUpdate = ps.executeUpdate(); ///verificar en consola si se actualizo o no alguna fila
            return rowUpdate > 0;            
            
        } catch (Exception e) {
            System.out.println("Error al actualizar mascota "+e.getMessage());
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
    
    
    
     public boolean Delete(Pet pet, User logUser){
         
        String sql = "DELETE FROM mascota WHERE id_mascota = ?";
        
        try (Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, pet.getId_pet());
        
        int rowsAffected = ps.executeUpdate();
        return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Error desactivando el usuario: " + e.getMessage());
            return false;
        }
    }
    
   

    
}
